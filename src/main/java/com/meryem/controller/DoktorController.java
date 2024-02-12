package com.meryem.controller;

import com.meryem.dto.request.HastaSaveRequestDto;
import com.meryem.dto.request.RandevuSaveRequestDto;
import com.meryem.dto.response.HastaSaveResponseDto;
import com.meryem.entity.Randevu;
import com.meryem.service.DoktorService;
import com.meryem.service.HastaService;
import com.meryem.service.RandevuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.meryem.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(DOKTOR)
public class DoktorController {
    private final DoktorService doktorService;
    private final HastaService hastaService;
    private final RandevuService randevuService;

    @PostMapping(HASTA_SAVE)
    public ResponseEntity<HastaSaveResponseDto> hastaKaydet(@RequestBody @Valid HastaSaveRequestDto dto){
        return ResponseEntity.ok(hastaService.save(dto));
    }

    @PostMapping(RANDEVU_SAVE)
    public ResponseEntity<Randevu> hastaEkle(@RequestBody @Valid RandevuSaveRequestDto dto){
        return ResponseEntity.ok(randevuService.save(dto));
    }

    @GetMapping(FIND_RANDEVU_BY_DOKTOR_ID)
    public ResponseEntity<List<Randevu>> doktoraGoreRandevuGetir(@RequestParam Long doktorId){
        return ResponseEntity.ok(randevuService.findByDoktorId(doktorId));
    }
}
