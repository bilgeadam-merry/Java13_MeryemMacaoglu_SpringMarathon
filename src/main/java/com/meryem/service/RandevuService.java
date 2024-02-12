package com.meryem.service;

import lombok.RequiredArgsConstructor;
import com.meryem.dto.request.RandevuSaveRequestDto;
import com.meryem.entity.Hasta;
import com.meryem.entity.Randevu;
import com.meryem.exception.ErrorType;
import com.meryem.exception.SpringMarathonAppException;
import com.meryem.mapper.RandevuMapper;
import com.meryem.repository.IRandevuRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RandevuService {
    private final IRandevuRepository randevuRepository;
    private final HastaService hastaService;

    public Randevu save (RandevuSaveRequestDto dto){
        Optional<Hasta> hasta = hastaService.findByTcKimlik(dto.getHastaTc());
        if (hasta.isEmpty()){
            throw new SpringMarathonAppException(ErrorType.BAD_REQUEST_ERROR);
        }
        Randevu randevu = RandevuMapper.INSTANCE.toRequestDto(dto);
        return randevuRepository.save(randevu);
    }

    public Optional<Randevu> findById(Long id){
        Optional<Randevu> randevu = randevuRepository.findById(id);
        if (randevu.isEmpty()){
            throw new SpringMarathonAppException(ErrorType.BAD_REQUEST_ERROR);
        }
        return randevu;
    }

    public void deleteById(Long id){
        Optional<Randevu> randevu = randevuRepository.findById(id);
        if (randevu.isEmpty()){
            throw new SpringMarathonAppException(ErrorType.BAD_REQUEST_ERROR);
        }
        randevuRepository.save(randevu.get());
    }

    public List<Randevu> findAll() {
        return randevuRepository.findAll();
    }

    public List<Randevu> findByDoktorId(Long doktorId){
        return randevuRepository.findByDoktorId(doktorId);
    }

    public List<Randevu> findByHastaTc(String hastaTc){
        Optional<Hasta> hasta = hastaService.findByTcKimlik(hastaTc);
        if (hasta.isEmpty()){
            throw new SpringMarathonAppException(ErrorType.BAD_REQUEST_ERROR);
        }
        return randevuRepository.findByHastaId(hasta.get().getId());
    }

    public List<Randevu> getAll() {return null;
    }

    public List<Randevu> findByHastaId(Long hastaId) {
        return  null;
    }

    public List<Randevu> findByTarih(Long tarih) {
        return null;
    }
}
