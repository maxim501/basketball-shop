package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.SectionDto;
import com.am.basketballshop.api.dto.subSection.ResponseSubSectionDto;
import com.am.basketballshop.api.dto.subSection.RequestSubSectionDto;
import org.springframework.web.bind.annotation.*;

public interface SectionEndpoint {

    @PostMapping(value = "/")
    SectionDto createSection(@RequestBody SectionDto sectionDto);

    @GetMapping(value = "/{sectionId}")
    SectionDto getSection(@PathVariable String sectionId);

    @PutMapping(value = "/{sectionId}")
    SectionDto updateSection(@PathVariable String sectionId, @RequestBody SectionDto sectionDto);

    @DeleteMapping(value = "/{sectionId}")
    void deleteSection(@PathVariable String sectionId);

    @PostMapping(value = "/sub")
    ResponseSubSectionDto createSubSection(@RequestBody RequestSubSectionDto subSectionDto);

    @GetMapping(value = "/sub/{subSectionId}")
    ResponseSubSectionDto getSubSection(@PathVariable String subSectionId);

    @PutMapping(value = "/sub/{subSectionId}")
    ResponseSubSectionDto updateSubSection(@PathVariable String subSectionId, @RequestBody RequestSubSectionDto subSectionDto);

    @DeleteMapping(value = "/sub/{subSectionId}")
    void deleteSubSection(@PathVariable String subSectionId);
}
