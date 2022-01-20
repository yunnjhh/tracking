package com.tacking.back.domain.entity;

import com.tacking.back.domain.dto.SequenceDto;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@NoArgsConstructor
@Table(name = "SEQUENCE")
public class Sequence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String type;

    private Long sequence;

    public Sequence(SequenceDto dto) {
        if (dto.getId() != null) {
            this.id = dto.getId();
        }
        this.type = dto.getType();
        this.sequence = dto.getSequence();
    }

    public SequenceDto toDomain() {
        SequenceDto sequenceBookDto = new SequenceDto();
        BeanUtils.copyProperties(this, sequenceBookDto);
        return sequenceBookDto;
    }

}
