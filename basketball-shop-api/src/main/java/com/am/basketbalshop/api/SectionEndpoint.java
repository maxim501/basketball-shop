package com.am.basketbalshop.api;

import com.am.basketbalshop.api.dto.SectionDto;
import com.am.basketbalshop.api.dto.subSection.RequestSubSectionDto;
import com.am.basketbalshop.api.dto.subSection.ResponseSubSectionDto;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

public interface SectionEndpoint {

    @PostMapping(value = "/")
    SectionDto createSection(@RequestBody SectionDto sectionDto);

    @GetMapping(value = "/{sectionId}")
    SectionDto getSection(@PathVariable String sectionId);

    @PostMapping(value = "/sub")
    ResponseSubSectionDto createSubSection(@RequestBody RequestSubSectionDto subSectionDto);

    @GetMapping(value = "/sub/{subSectionId}")
    ResponseSubSectionDto getSubSection(@PathVariable String subSectionId);
}
