package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.SectionDto;
import com.am.basketballshop.api.dto.subSection.RequestSubSectionDto;
import com.am.basketballshop.api.dto.subSection.ResponseSubSectionDto;
import com.am.basketballshop.services.SectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/section")
public class SectionController {

    private final SectionService sectionService;

    @PostMapping(value = "/")
    SectionDto createSection(@RequestBody SectionDto sectionDto) {
        return sectionService.createSection(sectionDto);
    }

    @GetMapping(value = "/{sectionId}")
    SectionDto getSection(@PathVariable String sectionId) {
        return sectionService.getSection(sectionId);
    }

    @PutMapping(value = "/{sectionId}")
    void updateSection(@PathVariable String sectionId, @RequestBody SectionDto sectionDto) {
        sectionService.updateSection(sectionId, sectionDto);
    }

    @DeleteMapping(value = "/{sectionId}")
    void deleteSection(@PathVariable String sectionId) {
        sectionService.deleteSection(sectionId);
    }

    @PostMapping(value = "/sub")
    ResponseSubSectionDto createSubSection(@RequestBody RequestSubSectionDto subSectionDto) {
        return sectionService.createSubSection(subSectionDto);
    }

    @GetMapping(value = "/sub/{subSectionId}")
    ResponseSubSectionDto getSubSection(@PathVariable String subSectionId) {
        return sectionService.getSubSection(subSectionId);
    }

    @PutMapping(value = "/sub/{subSectionId}")
    void updateSubSection(@PathVariable String subSectionId, @RequestBody RequestSubSectionDto subSectionDto) {
        sectionService.updateSubSection(subSectionId, subSectionDto);
    }

    @DeleteMapping(value = "/sub/{subSectionId}")
    void deleteSubSection(@PathVariable String subSectionId) {
        sectionService.deleteSubSection(subSectionId);
    }

}
