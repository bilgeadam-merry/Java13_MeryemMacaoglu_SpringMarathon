package com.meryem.repository;

import com.meryem.entity.Doktor;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDoktorRepository extends JpaRepository<Doktor,Long> {
}
