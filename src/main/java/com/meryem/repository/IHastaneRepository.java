package com.meryem.repository;

import com.meryem.entity.Hastane;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IHastaneRepository extends JpaRepository<Hastane, Long> {
}
