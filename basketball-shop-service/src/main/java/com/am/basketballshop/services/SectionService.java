package com.am.basketballshop.services;

import com.am.basketballshop.api.dto.SectionDto;
import com.am.basketballshop.api.dto.subSection.SubSectionDto;
import com.am.basketballshop.converters.base.UniversalConverter;
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

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Slf4j
public class SectionService {
    private final SectionRepository sectionRepository;
    private final SubSectionRepository subSectionRepository;
    private final UniversalConverter converter;

    public SectionDto createSection(SectionDto sectionDto) {
        Section saveSection = sectionRepository.save(converter.dtoToEntity(sectionDto, Section.class));

        return converter.entityToDto(saveSection, SectionDto.class);
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

    public List<SectionDto> getAllSections() {
        return sectionRepository.findAll().stream()
                .map(section -> converter.entityToDto(section, SectionDto.class))
                .collect(Collectors.toList());
    }

    public SectionDto updateSection(String sectionId, SectionDto sectionDto) {
        Optional<Section> sectionById = sectionRepository.findById(sectionId);
        Section section = sectionById.orElseThrow(() -> {
            throw new NotFoundException("Not found section by id = " + sectionId);
        });
        section.setName(sectionDto.getName());

        Section updateSection = sectionRepository.save(section);

        return converter.entityToDto(updateSection, SectionDto.class);
    }

    public void deleteSection(String sectionId) {
        Optional<Section> sectionById = sectionRepository.findById(sectionId);
        Section section = sectionById.orElseThrow(() -> {
            throw new NotFoundException("Not found section by id = " + sectionId);
        });

        sectionRepository.delete(section);
    }


    public SubSectionDto createSubSection(@RequestBody SubSectionDto subSectionDto) {
        SubSection subSection = new SubSection();
        setSubSection(subSection, subSectionDto);

        SubSection saveSubSection = subSectionRepository.save(subSection);

        return converter.entityToDto(saveSubSection, SubSectionDto.class);
    }


    public SubSectionDto getSubSection(@PathVariable String subSectionId) {
        Optional<SubSection> subSectionById = subSectionRepository.findById(subSectionId);
        SubSection subSection = subSectionById.orElseThrow(() -> {
            throw new NotFoundException("Not found sub section by id = " + subSectionId);
        });

        return converter.entityToDto(subSection, SubSectionDto.class);
    }

    public List<SubSectionDto> getAllSubSectionsBySection(String sectionId) {
        return subSectionRepository.findBySectionId(sectionId).stream()
                .map(subSection -> converter.entityToDto(subSection, SubSectionDto.class))
                .collect(Collectors.toList());
    }

    public SubSectionDto updateSubSection(String subSectionId, SubSectionDto subSectionDto) {
        Optional<SubSection> subSectionById = subSectionRepository.findById(subSectionId);
        SubSection subSection = subSectionById.orElseThrow(() -> {
            throw new NotFoundException("Not found sub section by id = " + subSectionId);
        });
        setSubSection(subSection, subSectionDto);

        SubSection updateSubSection = subSectionRepository.save(subSection);

        return converter.entityToDto(updateSubSection, SubSectionDto.class);
    }

    public void deleteSubSection(String subSectionId) {
        Optional<SubSection> subSectionById = subSectionRepository.findById(subSectionId);
        SubSection subSection = subSectionById.orElseThrow(() -> {
            throw new NotFoundException("Not found sub section by id = " + subSectionId);
        });

        subSectionRepository.delete(subSection);
    }

    public void setSubSection(SubSection subSection, SubSectionDto subSectionDto) {
        subSection.setName(subSectionDto.getName());

        String sectionId = subSectionDto.getSection().getId();
        if (sectionId != null) {
            Optional<Section> sectionById = sectionRepository.findById(sectionId);
            Section section = sectionById.orElseThrow(() -> {
                throw new NotFoundException("Not found section by id = " + sectionId);
            });
            subSection.setSection(section);
        }
    }

}
