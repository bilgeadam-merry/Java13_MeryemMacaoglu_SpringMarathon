package com.meryem.mapper;

import com.meryem.dto.request.RandevuSaveRequestDto;
import com.meryem.entity.Randevu;
import com.meryem.service.RandevuService;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)

public interface RandevuMapper {

    RandevuMapper INSTANCE = Mappers.getMapper(RandevuMapper.class);

    Randevu toRequestDto(RandevuSaveRequestDto randevu);
}
