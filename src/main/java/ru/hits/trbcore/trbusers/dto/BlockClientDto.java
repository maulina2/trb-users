package ru.hits.trbcore.trbusers.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class BlockClientDto {

    private UUID clientId;

    private UUID officerId;

}
