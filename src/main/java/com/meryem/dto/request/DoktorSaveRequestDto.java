package com.meryem.dto.request;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import com.meryem.entity.enums.EBrans;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class DoktorSaveRequestDto {
    @NotNull
    private String adSoyad;
    @NotNull
    private EBrans brans;
}
