package com.meryem.mapper;

import com.meryem.dto.request.DoktorSaveRequestDto;
import com.meryem.dto.response.DoktorSaveResponseDto;
import com.meryem.entity.Doktor;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface DoktorMapper {

    DoktorMapper INSTANCE = Mappers.getMapper(DoktorMapper.class);

    Doktor toRequestDto(DoktorSaveRequestDto dto);

    DoktorSaveResponseDto toDoktor(Doktor doktor);

}
