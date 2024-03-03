package ru.hits.trbcore.trbusers.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import ru.hits.trbcore.trbusers.annotation.PageNumberValidation;
import ru.hits.trbcore.trbusers.annotation.PageSizeValidation;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class PageDto {

    @PageNumberValidation
    private int pageNumber;
    @PageSizeValidation
    private int pageSize;
}
