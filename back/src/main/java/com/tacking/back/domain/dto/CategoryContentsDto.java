package com.tacking.back.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryContentsDto {

    private String categoryId;

    private String contentsId;

    private Integer listOrder;

}
