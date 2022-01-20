package com.tacking.back.service;

import com.tacking.back.domain.dto.CategoryDto;
import com.tacking.back.domain.entity.Category;
import com.tacking.back.domain.enumtype.SequenceType;
import com.tacking.back.domain.mapper.CategoryMapper;
import com.tacking.back.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CategoryService {

    @Autowired
    CategoryRepository categoryRepository;

    @Autowired
    SequenceService sequenceService;

    public CategoryDto findCategoryByCategoryId(String categoryId) {

        Optional<Category> categoryOptional = categoryRepository.findById(categoryId);
        if (!categoryOptional.isPresent()) {
            throw new RuntimeException("해당 카테고리가 존재하지 않습니다.");
        }

        return CategoryMapper.INSTANCE.entityToDto(categoryOptional.get());
    }

    @Transactional
    public CategoryDto registerCategory(CategoryDto dto) {

        String categoryId = sequenceService.generateId(SequenceType.CATEGORY);
        dto.setId(categoryId);

        Category category = categoryRepository.save(CategoryMapper.INSTANCE.dtoToEntity(dto));
        return CategoryMapper.INSTANCE.entityToDto(category);
    }
}
