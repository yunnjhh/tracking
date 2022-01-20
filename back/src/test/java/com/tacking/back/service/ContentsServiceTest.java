package com.tacking.back.service;

import com.tacking.back.domain.dto.ContentsDto;
import com.tacking.back.domain.entity.Contents;
import com.tacking.back.domain.mapper.ContentsMapper;
import com.tacking.back.repository.ContentsRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class ContentsServiceTest {

    @Autowired
    ContentsService contentsService;

    @Autowired
    ContentsRepository contentsRepository;

    @Test
    void registerContents() {

        ContentsDto contentsDto = new ContentsDto();
        contentsDto.setName("프렌즈10");
        contentsDto.setDescription("미드~~~~~~~");
        contentsDto.setImg_path(".ddd/d.d/d/d");
        contentsDto.setDeleted(false);

//        contentsService.registerContents(contentsDto);

        contentsRepository.save(ContentsMapper.INSTANCE.dtoToEntity(contentsDto));

    }

}