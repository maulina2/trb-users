package ru.hits.trbcore.trbusers.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.ReportingPolicy;
import ru.hits.trbcore.trbusers.dto.OfficerDto;
import ru.hits.trbcore.trbusers.dto.SignUpDto;
import ru.hits.trbcore.trbusers.entity.Officer;

@Mapper(
        componentModel = MappingConstants.ComponentModel.SPRING,
        unmappedTargetPolicy = ReportingPolicy.IGNORE
)
public interface OfficerMapper {
    @Mapping(target = "isBlocked", expression = "java(false)")
    Officer newDtoToEntity(SignUpDto dto);

    OfficerDto entityToDto(Officer officer);
}
