package com.tacking.back.domain.mapper;

import com.tacking.back.domain.dto.ContentsDto;
import com.tacking.back.domain.entity.Contents;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-01-21T00:03:00+0900",
    comments = "version: 1.4.1.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.1.jar, environment: Java 1.8.0_282 (Azul Systems, Inc.)"
)
@Component
public class ContentsMapperImpl implements ContentsMapper {

    @Override
    public Contents dtoToEntity(ContentsDto contentsRequest) {
        if ( contentsRequest == null ) {
            return null;
        }

        Contents contents = new Contents();

        contents.setId( contentsRequest.getId() );
        contents.setName( contentsRequest.getName() );
        contents.setDescription( contentsRequest.getDescription() );
        contents.setImg_path( contentsRequest.getImg_path() );
        contents.setDeleted( contentsRequest.getDeleted() );
        contents.setViewedAt( contentsRequest.getViewedAt() );

        return contents;
    }

    @Override
    public ContentsDto entityToDto(Contents contents) {
        if ( contents == null ) {
            return null;
        }

        ContentsDto contentsDto = new ContentsDto();

        contentsDto.setId( contents.getId() );
        contentsDto.setName( contents.getName() );
        contentsDto.setDescription( contents.getDescription() );
        contentsDto.setImg_path( contents.getImg_path() );
        contentsDto.setDeleted( contents.getDeleted() );
        contentsDto.setViewedAt( contents.getViewedAt() );
        contentsDto.setRegisteredAt( contents.getRegisteredAt() );
        contentsDto.setModifiedAt( contents.getModifiedAt() );

        return contentsDto;
    }

    @Override
    public ContentsDto entityToDto(Contents contents, String categoryId) {
        if ( contents == null ) {
            return null;
        }

        ContentsDto contentsDto = new ContentsDto();

        contentsDto.setCategoryId( setCategoryId( contents, categoryId ) );
        contentsDto.setId( contents.getId() );
        contentsDto.setName( contents.getName() );
        contentsDto.setDescription( contents.getDescription() );
        contentsDto.setImg_path( contents.getImg_path() );
        contentsDto.setDeleted( contents.getDeleted() );
        contentsDto.setViewedAt( contents.getViewedAt() );
        contentsDto.setRegisteredAt( contents.getRegisteredAt() );
        contentsDto.setModifiedAt( contents.getModifiedAt() );

        return contentsDto;
    }
}
