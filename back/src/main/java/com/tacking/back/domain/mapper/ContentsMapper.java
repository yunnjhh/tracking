package com.tacking.back.domain.mapper;

import com.tacking.back.domain.dto.ContentsDto;
import com.tacking.back.domain.entity.Contents;
import org.mapstruct.Context;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.ERROR,
        nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_DEFAULT)
public interface ContentsMapper {

    ContentsMapper INSTANCE = Mappers.getMapper(ContentsMapper.class);

    Contents dtoToEntity(ContentsDto contentsRequest);

    @Mapping(target = "categoryId", ignore = true)
    ContentsDto entityToDto(Contents contents);

    @Mapping(target = "categoryId", source = "contents", qualifiedByName = "setCategoryId")
    ContentsDto entityToDto(Contents contents, @Context String categoryId);

    @Named("setCategoryId")
    default String setCategoryId(Contents contents, @Context String categoryId) {
        if (categoryId.isEmpty()) {
            return null;
        } else {
            return categoryId;
        }
    }
}
