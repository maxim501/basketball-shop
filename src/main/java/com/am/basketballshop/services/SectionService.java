package com.am.basketballshop.services;

import com.am.basketballshop.api.dto.SectionDto;
import com.am.basketballshop.api.dto.subSection.RequestSubSectionDto;
import com.am.basketballshop.api.dto.subSection.ResponseSubSectionDto;
import com.am.basketballshop.exception.NotFoundException;
import com.am.basketballshop.model.product.Section;
import com.am.basketballshop.model.product.SubSection;
import com.am.basketballshop.repository.SectionRepository;
import com.am.basketballshop.repository.SubSectionRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class SectionService {
    private final SectionRepository sectionRepository;
    private final SubSectionRepository subSectionRepository;

    public SectionDto createSection(SectionDto sectionDto) {
        Section section = new Section();
        section.setName(sectionDto.getName());

        Section saveSection = sectionRepository.save(section);

        return SectionDto.builder()
                .id(saveSection.getId())
                .name(saveSection.getName())
                .build();
    }

    public SectionDto getSection(@PathVariable String sectionId) {
        Optional<Section> sectionById = sectionRepository.findById(sectionId);
        Section section = sectionById.orElseThrow(() -> {
            throw new NotFoundException("Not found section by id = " + sectionId);
        });

        return SectionDto.builder()
                .id(section.getId())
                .name(section.getName())
                .build();
    }


    public ResponseSubSectionDto createSubSection(@RequestBody RequestSubSectionDto subSectionDto) {
        SubSection subSection = new SubSection();
        subSection.setName(subSectionDto.getName());

        String sectionId = subSectionDto.getSectionId();
        if (sectionId != null) {
            Optional<Section> sectionById = sectionRepository.findById(sectionId);
            Section section = sectionById.orElseThrow(() -> {
                throw new NotFoundException("Not found section by id = " + sectionId);
            });
            subSection.setSection(section);
        }

        SubSection saveSubSection = subSectionRepository.save(subSection);

        return ResponseSubSectionDto.builder()
                .id(saveSubSection.getId())
                .section(saveSubSection.getSection())
                .name(saveSubSection.getName())
                .build();
    }


    public ResponseSubSectionDto getSubSection(@PathVariable String subSectionId) {
        Optional<SubSection> subSectionById = subSectionRepository.findById(subSectionId);
        SubSection subSection = subSectionById.orElseThrow(() -> {
            throw new NotFoundException("Not found sub section by id = " + subSectionId);
        });

        return ResponseSubSectionDto.builder()
                .id(subSection.getId())
                .section(subSection.getSection())
                .name(subSection.getName())
                .build();
    }
}
