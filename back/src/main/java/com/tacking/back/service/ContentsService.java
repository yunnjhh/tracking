package com.tacking.back.service;

import com.tacking.back.domain.dto.ContentsDto;
import com.tacking.back.domain.entity.Contents;
import com.tacking.back.domain.enumtype.SequenceType;
import com.tacking.back.domain.mapper.ContentsMapper;
import com.tacking.back.repository.ContentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class ContentsService {

    @Autowired
    ContentsRepository contentsRepository;

    @Autowired
    SequenceService sequenceService;

    @Autowired
    CategoryContentsService categoryContentsService;

    public ContentsDto findContentsById(String contentsId) {

        Optional<Contents> optionalContents = contentsRepository.findById(contentsId);
        if (!optionalContents.isPresent()) {
            throw new RuntimeException("해당 컨텐츠가 존재하지 않습니다.");
        }

        return ContentsMapper.INSTANCE.entityToDto(optionalContents.get());
    }

    @Transactional
    public ContentsDto registerContents(ContentsDto contentsRequest) {

        String contentsId = sequenceService.generateId(SequenceType.CONTENTS);
        contentsRequest.setId(contentsId);

        Contents contents = contentsRepository.save(ContentsMapper.INSTANCE.dtoToEntity(contentsRequest));
        ContentsDto dto = ContentsMapper.INSTANCE.entityToDto(contents, contentsRequest.getCategoryId());

        categoryContentsService.registerCategoryContentsMapping(contentsRequest.getCategoryId(), dto.getId());

        return dto;

    }

    @Transactional
    public ContentsDto updateContents(String contentsId, ContentsDto newContents) {
        ContentsDto originalContents = findContentsById(contentsId);
        originalContents.setName(newContents.getName());
        originalContents.setDescription(newContents.getDescription());
        originalContents.setImg_path(newContents.getImg_path());
        originalContents.setViewedAt(newContents.getViewedAt());

        Contents updatedContents = contentsRepository.save(ContentsMapper.INSTANCE.dtoToEntity(originalContents));
        return ContentsMapper.INSTANCE.entityToDto(updatedContents);
    }

    @Transactional
    public void deleteContents(String contentsId) {
        ContentsDto originalContents = findContentsById(contentsId);
        originalContents.setDeleted(true);
        contentsRepository.save(ContentsMapper.INSTANCE.dtoToEntity(originalContents));
    }

    public List<ContentsDto> findContentsByCategory(String categoryId) {

        List<ContentsDto> contentsDtos = new ArrayList<>();
        List<Contents> contents = contentsRepository.findByCategory(categoryId);
        contents.stream().forEach(c -> contentsDtos.add(ContentsMapper.INSTANCE.entityToDto(c)));
        return contentsDtos;
    }
}
