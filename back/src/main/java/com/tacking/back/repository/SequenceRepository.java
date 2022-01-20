package com.tacking.back.repository;

import com.tacking.back.domain.entity.Sequence;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SequenceRepository extends JpaRepository<Sequence, Long> {

    Optional<Sequence> findByType(String type);
}
