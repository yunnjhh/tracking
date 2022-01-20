package com.tacking.back.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@EqualsAndHashCode(callSuper=false)
@Table(name = "CONTENTS")
public class Contents extends Audit {

    @Id
    private String id;

    private String name;

    private String description;

    private String img_path;

    private Boolean deleted;

    @Column(name = "view_time")
    private LocalDateTime viewedAt;

}
