package com.tacking.back.service;

import com.tacking.back.domain.entity.Sequence;
import com.tacking.back.domain.enumtype.SequenceType;
import com.tacking.back.repository.SequenceRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SequenceServiceTest {

    @Autowired
    SequenceService service;

    @Autowired
    SequenceRepository repository;

    @Test
    void saveSequecne() {

        Sequence sequence = new Sequence();
        sequence.setType(SequenceType.CATEGORY.getType());
        sequence.setSequence(1L);

        sequence = repository.save(sequence);
        System.out.println(sequence.toString());

    }

    @Test
    void generateId() {

        service.generateId(SequenceType.CONTENTS);

    }
}