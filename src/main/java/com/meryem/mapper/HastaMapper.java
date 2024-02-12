package com.meryem.mapper;

import com.meryem.dto.request.HastaSaveRequestDto;
import com.meryem.dto.response.HastaSaveResponseDto;
import com.meryem.entity.Hasta;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface HastaMapper {
    HastaMapper INSTANCE = Mappers.getMapper(HastaMapper.class);

    Hasta toRequestDto(HastaSaveRequestDto dto);
    HastaSaveResponseDto toHasta(Hasta hasta);
}
