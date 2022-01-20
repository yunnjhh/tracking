package com.tacking.back.service;

import com.tacking.back.domain.dto.CategoryDto;
import com.tacking.back.domain.dto.ContentsDto;
import com.tacking.back.domain.entity.CategoryContents;
import com.tacking.back.domain.entity.CategoryContentsId;
import com.tacking.back.domain.mapper.CategoryMapper;
import com.tacking.back.domain.mapper.ContentsMapper;
import com.tacking.back.repository.CategoryContentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class CategoryContentsService {

    @Autowired
    CategoryService categoryService;

    @Autowired
    ContentsService contentsService;

    @Autowired
    CategoryContentsRepository categoryContentsRepository;


    public void setCategoryContentsId(String categoryId, String contentsId, CategoryContentsId id) {

        CategoryDto categoryDto = categoryService.findCategoryByCategoryId(categoryId);
        ContentsDto contentsDto = contentsService.findContentsById(contentsId);

        id.setCategory(CategoryMapper.INSTANCE.dtoToEntity(categoryDto));
        id.setContentsId(ContentsMapper.INSTANCE.dtoToEntity(contentsDto));

    }


    public void registerCategoryContentsMapping(String categoryId, String contentsId) {

        CategoryContentsId id = new CategoryContentsId();
        System.out.println("--->1 " + id.toString());
        setCategoryContentsId(categoryId, contentsId, id);

        System.out.println("--->2 " + id.toString());

        CategoryContents categoryContents = new CategoryContents();
        categoryContents.setId(id);
        categoryContents.setListOrder(0);

        categoryContentsRepository.save(categoryContents);
    }




}
