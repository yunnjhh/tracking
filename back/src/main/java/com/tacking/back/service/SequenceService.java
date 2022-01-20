package com.tacking.back.service;

import com.tacking.back.domain.dto.SequenceDto;
import com.tacking.back.domain.entity.Sequence;
import com.tacking.back.domain.enumtype.SequenceType;
import com.tacking.back.repository.SequenceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class SequenceService {

    @Autowired
    SequenceRepository sequenceRepository;

    @Transactional
    public void saveSequence(SequenceDto dto) {

        sequenceRepository.save(new Sequence(dto));
    }

    @Transactional
    public String generateId(SequenceType sequenceType) {

        String type = sequenceType.getType();
        Optional<Sequence> sequenceOptional = sequenceRepository.findByType(type);
        SequenceDto sequenceDto = new SequenceDto(type);
        Long newSequenceNum = 1L;

        if (sequenceOptional.isPresent()) {
            sequenceDto = sequenceOptional.get().toDomain();
            newSequenceNum = sequenceOptional.get().getSequence();
            newSequenceNum++;
        }

        sequenceDto.setSequence(newSequenceNum);
        saveSequence(sequenceDto);

        return getNextId(type, newSequenceNum);
    }

    public String getNextId(String prefix, long number) {
        number = number < 0L ? -number : number;
        return String.format("%s-%s", prefix, getStr(number));
    }

    public String getStr(long number) {
        String resultStr = "";

        if (number < 0L) {
            throw new RuntimeException("Minus digit is not valid -> " + number);
        }

        if (number < 10L) {
            resultStr = resultStr + (char) ((int) (number + 48L));
        } else {
            long remain = 0L;

            for (boolean var6 = true; number > 0L; number /= 36L) {
                remain = number % 36L;
                char charDigit;
                if (remain < 10L) {
                    charDigit = (char) ((int) (remain + 48L));
                } else {
                    charDigit = (char) ((int) (remain - 10L + 65L));
                }

                resultStr = charDigit + resultStr;
            }
        }

        return resultStr;

    }


}
