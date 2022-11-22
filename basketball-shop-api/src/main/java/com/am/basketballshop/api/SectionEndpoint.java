package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.SectionDto;
import com.am.basketballshop.api.dto.subSection.ResponseSubSectionDto;
import com.am.basketballshop.api.dto.subSection.RequestSubSectionDto;
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
    void updateSection(@PathVariable String sectionId, @RequestBody SectionDto sectionDto);

    @DeleteMapping(value = "/{sectionId}")
    void deleteSection(@PathVariable String sectionId);

    @PostMapping(value = "/sub")
    ResponseSubSectionDto createSubSection(@RequestBody RequestSubSectionDto subSectionDto);

    @GetMapping(value = "/sub/{subSectionId}")
    ResponseSubSectionDto getSubSection(@PathVariable String subSectionId);

    @GetMapping(value = "/{sectionId}/sub/all")
    List<ResponseSubSectionDto> getAllSubSectionsBySection(@PathVariable String sectionId);

    @PutMapping(value = "/sub/{subSectionId}")
    void updateSubSection(@PathVariable String subSectionId, @RequestBody RequestSubSectionDto subSectionDto);

    @DeleteMapping(value = "/sub/{subSectionId}")
    void deleteSubSection(@PathVariable String subSectionId);
}
