package com.am.basketballshop.controller;

import com.am.basketballshop.api.SectionEndpoint;
import com.am.basketballshop.api.dto.SectionDto;
import com.am.basketballshop.api.dto.subSection.RequestSubSectionDto;
import com.am.basketballshop.api.dto.subSection.ResponseSubSectionDto;
import com.am.basketballshop.services.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/section")
public class SectionController implements SectionEndpoint {

    private final SectionService sectionService;

    @Override
    public SectionDto createSection(SectionDto sectionDto) {
        return sectionService.createSection(sectionDto);
    }

    @Override
    public SectionDto getSection(String sectionId) {
        return sectionService.getSection(sectionId);
    }

    @Override
    public List<SectionDto> getAllSections() {
        return sectionService.getAllSections();
    }

    @Override
    public SectionDto updateSection(String sectionId, SectionDto sectionDto) {
        return sectionService.updateSection(sectionId, sectionDto);
    }

    @Override
    public void deleteSection(String sectionId) {
        sectionService.deleteSection(sectionId);
    }

    @Override
    public ResponseSubSectionDto createSubSection(RequestSubSectionDto subSectionDto) {
        return sectionService.createSubSection(subSectionDto);
    }

    @Override
    public ResponseSubSectionDto getSubSection(String subSectionId) {
        return sectionService.getSubSection(subSectionId);
    }

    @Override
    public List<ResponseSubSectionDto> getAllSubSectionsBySection(String sectionId) {
        return sectionService.getAllSubSectionsBySection(sectionId);
    }

    @Override
    public ResponseSubSectionDto updateSubSection(String subSectionId, RequestSubSectionDto subSectionDto) {
        return sectionService.updateSubSection(subSectionId, subSectionDto);
    }

    @Override
    public void deleteSubSection(String subSectionId) {
        sectionService.deleteSubSection(subSectionId);
    }

}
