package com.meryem.entity;

import com.meryem.entity.enums.EBrans;
import com.meryem.entity.enums.ECinsiyet;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_doktor")
public class Doktor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ad",nullable = false,length = 50)
    private String ad;
    @Column(name = "soyad",nullable = false,length = 50)
    private String soyad;
    @Enumerated
    private EBrans brans;
    @Enumerated
    private ECinsiyet cinsiyet;
    @Column(name = "telefon",nullable = false,length = 20)
    private String telefon;
    private String email;
    @ManyToOne
    private Hastane hastane;
    @OneToMany
    List<Hasta> hastalar;
    @OneToMany
    List<Randevu> randevular;
}
