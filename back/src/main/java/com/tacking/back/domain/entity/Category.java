package com.tacking.back.domain.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@Table(name = "CATEGORY")
public class Category extends Audit {

    @Id
    private String id;

    private String name;

    private Boolean enabled;

}
