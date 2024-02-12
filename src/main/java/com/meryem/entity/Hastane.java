package com.meryem.entity;

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
@Table(name = "tbl_hastane")
public class Hastane {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "ad",nullable = false,length = 50)
    private String ad;
    @OneToMany
    private List<Doktor> doktorlar;
    @OneToMany
    private List<Hasta> hastalar;
}
