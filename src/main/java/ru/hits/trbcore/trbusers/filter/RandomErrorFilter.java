package ru.hits.trbcore.trbusers.filter;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.hits.trbcore.trbusers.config.RandomErrorProperties;
import ru.hits.trbcore.trbusers.exception.ApiError;

import java.io.IOException;
import java.util.Calendar;
import java.util.Random;

@Slf4j
@RequiredArgsConstructor
public class RandomErrorFilter extends OncePerRequestFilter {

    private final RandomErrorProperties properties;
    private final ObjectMapper mapper = new ObjectMapper();
    private final Random random = new Random();


    @Override
    protected void doFilterInternal(@NonNull HttpServletRequest request,
                                    @NonNull HttpServletResponse response,
                                    @NonNull FilterChain filterChain
    ) throws ServletException, IOException {
        if (properties.isEnable() && shouldThrowError()) {
            log.info("An error is returned accidentally");
            sendError(response);
            return;
        }

        filterChain.doFilter(request, response);
    }

    private boolean shouldThrowError() {
        var randomDouble = random.nextDouble();

        if (isExtremePeriod()) {
            return randomDouble <= properties.getProbabilityExtreme();
        } else {
            return randomDouble <= properties.getProbabilityAverage();
        }
    }

    private boolean isExtremePeriod() {
        var currentMin = Calendar.getInstance().get(Calendar.MINUTE);
        return (currentMin % properties.getExtremePeriodFrequencyMin()) - properties.getExtremePeriodDurationMin() < 0;
    }


    private void sendError(HttpServletResponse httpServletResponse) throws IOException {
        ApiError responseObject = new ApiError("Случилась случайная ошибка");

        String responseString = mapper.writeValueAsString(responseObject);

        httpServletResponse.setStatus(500);
        httpServletResponse.setContentType(MediaType.APPLICATION_JSON_VALUE);
        httpServletResponse.setCharacterEncoding("UTF-8");
        httpServletResponse.getWriter().write(responseString);
    }
}
