package com.tacking.back.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CategoryDto {

    private String id;

    private String name;

    private Boolean enabled;

}
