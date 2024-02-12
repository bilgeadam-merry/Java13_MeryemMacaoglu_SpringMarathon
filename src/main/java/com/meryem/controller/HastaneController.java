package com.meryem.controller;

import com.meryem.dto.request.DoktorSaveRequestDto;
import com.meryem.dto.response.DoktorSaveResponseDto;
import com.meryem.entity.Doktor;
import com.meryem.service.DoktorService;
import com.meryem.service.HastaService;
import com.meryem.service.RandevuService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static com.meryem.constants.RestApiUrls.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(HASTANE)
public class HastaneController {
    private final DoktorService doktorService;


    @PostMapping(DOKTOR_SAVE)
    public ResponseEntity<DoktorSaveResponseDto> doktorEkle(@RequestBody @Valid DoktorSaveRequestDto dto) {
        return ResponseEntity.ok(doktorService.save(dto));
    }

    @GetMapping(GET_BY_ID_DOKTOR)
    public ResponseEntity<Optional<Doktor>> idIleDoktorBul(@RequestParam Long id) {
        return ResponseEntity.ok(doktorService.findById(id));
    }

    @GetMapping(GET_ALL_DOKTOR)
    public ResponseEntity<List<Doktor>> doktorlariListele() {
        return ResponseEntity.ok(doktorService.getAllDoktor());
    }

    @DeleteMapping(DELETE_DOKTOR)
    public ResponseEntity<Void> doktorSil(@RequestParam Long id) {
        doktorService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}

