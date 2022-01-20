package com.tacking.back.repository;

import com.tacking.back.domain.entity.CategoryContents;
import com.tacking.back.domain.entity.CategoryContentsId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryContentsRepository extends JpaRepository<CategoryContents, CategoryContentsId> {
}
