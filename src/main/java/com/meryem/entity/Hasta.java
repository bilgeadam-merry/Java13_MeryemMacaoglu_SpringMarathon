package com.meryem.entity;

import com.meryem.entity.enums.ECinsiyet;
import com.meryem.entity.enums.ETedavi;
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
@Table(name = "tbl_hasta")
public class Hasta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ad",nullable = false,length = 50)
    private String ad;
    @Column(name = "soyad",nullable = false,length = 50)
    private String soyad;
    @Enumerated
    private ECinsiyet cinsiyet;
    @Column(name = "tckimlik",nullable = false,length = 50)
    private String tcKimlik;
    @Column(name = "telefon",nullable = false,length = 20)
    private String telefon;
    private String email;
    @ManyToOne
    private Hastane hastane;
    @OneToMany
    private List<Randevu> randevular;
    @Enumerated
    private ETedavi tedavi;
}