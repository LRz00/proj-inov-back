package com.ifba.proj_inov.core.repository;

import com.ifba.proj_inov.core.entities.Exame;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ExameRepository extends JpaRepository<Exame, Long> {
}
