package com.meryem.dto.response;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import com.meryem.entity.enums.EBrans;
import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoktorSaveResponseDto {
    private String adSoyad;
    private String unvan;
    @Enumerated(EnumType.STRING)
    private EBrans brans;
    @Builder.Default
    private String message = "Doktor başarı ile kaydedildi.";
}
