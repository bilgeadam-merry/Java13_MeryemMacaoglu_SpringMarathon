package com.meryem.dto.response;


import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HastaSaveResponseDto {
    private String adSoyad;
    @Builder.Default
    private String message = "Hasta başarıyla kayıt edildi.";
}
