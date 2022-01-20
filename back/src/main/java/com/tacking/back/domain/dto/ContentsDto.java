package com.tacking.back.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class ContentsDto {

    private String id;

    private String categoryId;

    private String name;

    private String description;

    private String img_path;

    private Boolean deleted;

    private LocalDateTime viewedAt;

    private LocalDateTime registeredAt;

    private LocalDateTime modifiedAt;

}
