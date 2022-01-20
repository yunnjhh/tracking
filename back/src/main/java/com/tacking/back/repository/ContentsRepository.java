package com.tacking.back.repository;


import com.tacking.back.domain.entity.Contents;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ContentsRepository extends JpaRepository<Contents, String> {
}
