package com.meryem.entity;

import com.meryem.entity.enums.EBrans;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_randevu")
public class Randevu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private EBrans brans;
    @ManyToOne
    private Hasta hasta;
    @ManyToOne
    private Doktor doktor;
    private Date tarih;
}
