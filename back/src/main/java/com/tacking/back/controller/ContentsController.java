package com.tacking.back.controller;

import com.tacking.back.domain.dto.ContentsDto;
import com.tacking.back.service.ContentsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/contents")
public class ContentsController {

    @Autowired
    ContentsService contentsService;

    @GetMapping
    public String hello() {
        return "HELLO~";
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ContentsDto findContents(@PathVariable String id) {
        System.out.println("find : "+id);
        return contentsService.findContentsById(id);
    }

    @GetMapping("/by")
    @ResponseStatus(HttpStatus.OK)
    public List<ContentsDto> findContentsByCategory(@RequestParam("categoryId") String categoryId) {
        System.out.println("--------------------");
        System.out.println(categoryId);
        return contentsService.findContentsByCategory(categoryId);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ContentsDto registerContents(@RequestBody ContentsDto dto) {
        return contentsService.registerContents(dto);
    }

    @PutMapping("/{id}")
    public ContentsDto updateContents(@PathVariable String id, @RequestBody ContentsDto dto) {
        System.out.println("update : "+id);
        return contentsService.updateContents(id, dto);
    }

    @PutMapping(value = "/{id}", params = "delete")
    public void deleteContents(@PathVariable String id) {
        System.out.println("delete : "+id);
        contentsService.deleteContents(id);
    }



}
