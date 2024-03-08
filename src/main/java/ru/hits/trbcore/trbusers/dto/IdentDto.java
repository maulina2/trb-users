package ru.hits.trbcore.trbusers.dto;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@NoArgsConstructor
@AllArgsConstructor
@Data
public class IdentDto {

    @NotNull
    private String email;
    @NotNull
    private String password;
}
