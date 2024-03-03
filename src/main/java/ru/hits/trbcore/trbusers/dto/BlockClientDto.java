package ru.hits.trbcore.trbusers.dto;


import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlockClientDto {
    @NotNull
    private UUID clientId;

    @NotNull
    private UUID officerId;

}
