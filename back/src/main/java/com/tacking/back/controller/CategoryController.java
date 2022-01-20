package com.tacking.back.controller;

import com.tacking.back.domain.dto.CategoryDto;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public void findCategory(String id) {

    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void registerCateogry(@RequestBody CategoryDto dto) {

    }

}
