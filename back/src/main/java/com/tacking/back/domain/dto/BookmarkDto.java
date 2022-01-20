package com.tacking.back.domain.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
public class BookmarkDto {

    private String id;

    private String contentsId;

    private String userId;

    private LocalDateTime registeredAt;

}
