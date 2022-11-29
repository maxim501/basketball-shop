package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.SectionDto;
import com.am.basketballshop.api.dto.subSection.SubSectionDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface SectionEndpoint {

    @PostMapping(value = "/")
    SectionDto createSection(@RequestBody SectionDto sectionDto);

    @GetMapping(value = "/{sectionId}")
    SectionDto getSection(@PathVariable String sectionId);

    @GetMapping(value = "/all")
    List<SectionDto> getAllSections();

    @PutMapping(value = "/{sectionId}")
    SectionDto updateSection(@PathVariable String sectionId, @RequestBody SectionDto sectionDto);

    @DeleteMapping(value = "/{sectionId}")
    void deleteSection(@PathVariable String sectionId);

    @PostMapping(value = "/sub")
    SubSectionDto createSubSection(@RequestBody SubSectionDto subSectionDto);

    @GetMapping(value = "/sub/{subSectionId}")
    SubSectionDto getSubSection(@PathVariable String subSectionId);

    @GetMapping(value = "/{sectionId}/sub/all")
    List<SubSectionDto> getAllSubSectionsBySection(@PathVariable String sectionId);

    @PutMapping(value = "/sub/{subSectionId}")
    SubSectionDto updateSubSection(@PathVariable String subSectionId, @RequestBody SubSectionDto subSectionDto);

    @DeleteMapping(value = "/sub/{subSectionId}")
    void deleteSubSection(@PathVariable String subSectionId);
}
