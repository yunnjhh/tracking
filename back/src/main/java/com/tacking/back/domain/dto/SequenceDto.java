package com.tacking.back.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SequenceDto {

    private Long id;

    private String type;

    private Long sequence = 1l;

    public SequenceDto(String type) {
        this.type = type;
    }

}
