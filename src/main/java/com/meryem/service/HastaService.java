package com.meryem.service;

import com.meryem.dto.request.HastaSaveRequestDto;
import com.meryem.dto.response.HastaSaveResponseDto;
import com.meryem.exception.SpringMarathonAppException;
import com.meryem.repository.IHastaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import com.meryem.entity.Hasta;
import com.meryem.exception.ErrorType;
import com.meryem.mapper.HastaMapper;


import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class HastaService {
    private final IHastaRepository hastaRepository;

    public HastaSaveResponseDto save(HastaSaveRequestDto dto){
        Optional<Hasta> hasta1 = hastaRepository.findByTcKimlik(dto.getTcKimlikNo());
        if (hasta1.isPresent()){
            throw new SpringMarathonAppException(ErrorType.BAD_REQUEST_ERROR);
        }
        Hasta hasta = HastaMapper.INSTANCE.toRequestDto(dto);
        hastaRepository.save(hasta);
        return HastaMapper.INSTANCE.toHasta(hasta);
    }

    public Optional<Hasta> findById(Long id){
        Optional<Hasta> hasta = hastaRepository.findById(id);
        if (hasta.isEmpty()){
            throw new SpringMarathonAppException(ErrorType.BAD_REQUEST_ERROR);
        }
        return  hasta;
    }

    public List<Hasta> findAll(){
        return hastaRepository.findAll();
    }

    public void deleteHasta(Long id){
        Optional<Hasta> hasta = hastaRepository.findById(id);
        if (hasta.isEmpty()){
            throw new SpringMarathonAppException(ErrorType.BAD_REQUEST_ERROR);
        }
        hastaRepository.save(hasta.get());
    }

    public Optional<Hasta> findByTcKimlik(String tcKimlikNo){
        Optional<Hasta> hasta = hastaRepository.findByTcKimlik(tcKimlikNo);
        if (hasta.isEmpty()){
            throw new SpringMarathonAppException(ErrorType.ERROR_DUPLICATE_USERNAME);
        }
        return hasta;
    }
}
