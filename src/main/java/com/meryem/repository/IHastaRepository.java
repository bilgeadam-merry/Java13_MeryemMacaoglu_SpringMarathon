package com.meryem.repository;

import com.meryem.entity.Hasta;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IHastaRepository extends JpaRepository<Hasta,Long> {
    Optional<Hasta> findByTcKimlik(String tcKimlik);

}
