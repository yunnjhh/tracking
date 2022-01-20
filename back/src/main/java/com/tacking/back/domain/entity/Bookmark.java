package com.tacking.back.domain.entity;

import com.tacking.back.domain.dto.BookmarkDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Data
@Entity
@NoArgsConstructor
@Table(name = "BOOKMARK")
public class Bookmark {

    @Id
    private String id;

    @Column(name = "contents_id")
    private String contentsId;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "register_time")
    private LocalDateTime registeredAt;

    public Bookmark(BookmarkDto dto) {
        BeanUtils.copyProperties(dto, this);
    }

    public BookmarkDto toDomain() {
        BookmarkDto bookmarkDto = new BookmarkDto();
        BeanUtils.copyProperties(this, bookmarkDto);
        return bookmarkDto;
    }
}
