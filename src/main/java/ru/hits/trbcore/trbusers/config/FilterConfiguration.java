package ru.hits.trbcore.trbusers.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.hits.trbcore.trbusers.filter.RandomErrorFilter;

@Configuration
@RequiredArgsConstructor
public class FilterConfiguration {

    private final RandomErrorProperties randomErrorProperties;

    @Bean
    public FilterRegistrationBean<RandomErrorFilter> randomErrorFilterFilterRegistrationBean() {
        var registrationBean = new FilterRegistrationBean<RandomErrorFilter>();
        var filter = new RandomErrorFilter(randomErrorProperties);

        registrationBean.setFilter(filter);
        registrationBean.addUrlPatterns("/api/*");
        registrationBean.setOrder(2);

        return registrationBean;
    }

}
