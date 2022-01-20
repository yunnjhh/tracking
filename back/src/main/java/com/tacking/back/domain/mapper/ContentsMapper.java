package com.tacking.back.domain.mapper;

import com.tacking.back.domain.dto.ContentsDto;
import com.tacking.back.domain.entity.Contents;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface ContentsMapper {

    ContentsMapper INSTANCE = Mappers.getMapper(ContentsMapper.class);

    Contents dtoToEntity(ContentsDto contentsRequest);

    ContentsDto entityToDto(Contents contents);
}
