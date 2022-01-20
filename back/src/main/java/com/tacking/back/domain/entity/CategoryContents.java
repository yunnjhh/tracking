package com.tacking.back.domain.entity;

import com.tacking.back.domain.dto.CategoryContentsDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@NoArgsConstructor
@Data
@Entity
@Table(name = "CATEGORY_CONTENTS")
public class CategoryContents {

    @Id
    private CategoryContentsId id;

    @Column(name = "list_order")
    private Integer listOrder;

    public CategoryContentsDto toDomain() {
        CategoryContentsDto categoryContentsDto = new CategoryContentsDto();
        BeanUtils.copyProperties(this, categoryContentsDto);
        return categoryContentsDto;
    }

}
