package com.am.basketballshop.controller;

import com.am.basketballshop.services.SectionService;
import com.am.basketbalshop.api.SectionEndpoint;
import com.am.basketbalshop.api.dto.SectionDto;
import com.am.basketbalshop.api.dto.subSection.RequestSubSectionDto;
import com.am.basketbalshop.api.dto.subSection.ResponseSubSectionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/section")
public class SectionController implements SectionEndpoint {

    private final SectionService sectionService;

    @Override
    public SectionDto createSection(@RequestBody SectionDto sectionDto) {
        return sectionService.createSection(sectionDto);
    }

    @Override
    public SectionDto getSection(@PathVariable String sectionId) {
        return sectionService.getSection(sectionId);
    }

    @Override
    public ResponseSubSectionDto createSubSection(@RequestBody RequestSubSectionDto subSectionDto) {
        return sectionService.createSubSection(subSectionDto);
    }

    @Override
    public ResponseSubSectionDto getSubSection(@PathVariable String subSectionId) {
        return sectionService.getSubSection(subSectionId);
    }

}
