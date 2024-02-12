package com.meryem.repository;

import com.meryem.entity.Randevu;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IRandevuRepository extends JpaRepository<Randevu,Long> {
    List<Randevu> findByHastaId(Long id);

    List<Randevu> findByDoktorId(Long doktorId);
}
