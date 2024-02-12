package com.meryem.dto.request;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import com.meryem.entity.enums.ECinsiyet;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class HastaSaveRequestDto {
    @NotNull
    private String tcKimlikNo;
    @NotNull
    private String adSoyad;
    @NotNull
    private String telefon;
    @NotNull
    private String adres;
    @NotNull
    private int yas;
    @NotNull
    @Enumerated
    private ECinsiyet cinsiyet;
}
