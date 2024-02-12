package com.meryem.service;

import com.meryem.repository.IDoktorRepository;
import lombok.RequiredArgsConstructor;
import com.meryem.dto.request.DoktorSaveRequestDto;
import com.meryem.dto.response.DoktorSaveResponseDto;
import com.meryem.entity.Doktor;
import com.meryem.exception.ErrorType;
import com.meryem.exception.SpringMarathonAppException;
import com.meryem.mapper.DoktorMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DoktorService {
    private final IDoktorRepository doktorRepository;


    public DoktorSaveResponseDto save(DoktorSaveRequestDto dto) {
        Doktor doktor = DoktorMapper.INSTANCE.toRequestDto(dto);
        doktorRepository.save(doktor);
        return DoktorMapper.INSTANCE.toDoktor(doktor);
    }


    public void deleteById(Long id){
        Optional<Doktor> doktor = doktorRepository.findById(id);
        if (doktor.isEmpty()){
            throw new SpringMarathonAppException(ErrorType.BAD_REQUEST_ERROR);
        }
        doktorRepository.save(doktor.get());
    }

    public Optional<Doktor> findById(Long id){
        Optional<Doktor> doktor = doktorRepository.findById(id);
        if (doktor.isEmpty()){
            throw new SpringMarathonAppException(ErrorType.BAD_REQUEST_ERROR);
        }
        return doktor;
    }


    public List<Doktor> getAllDoktor(){
        return doktorRepository.findAll();
    }


}
