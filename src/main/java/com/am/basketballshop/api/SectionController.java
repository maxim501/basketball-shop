package com.am.basketballshop.api;

import com.am.basketballshop.api.dto.SectionDto;
import com.am.basketballshop.api.dto.product.RequestProductDto;
import com.am.basketballshop.api.dto.product.ResponseProductDto;
import com.am.basketballshop.api.dto.subSection.RequestSubSectionDto;
import com.am.basketballshop.api.dto.subSection.ResponseSubSectionDto;
import com.am.basketballshop.services.ProductService;
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

    @PostMapping(value = "/sub")
    ResponseSubSectionDto createSubSection(@RequestBody RequestSubSectionDto subSectionDto) {
        return sectionService.createSubSection(subSectionDto);
    }

    @GetMapping(value = "/sub/{subSectionId}")
    ResponseSubSectionDto getSubSection(@PathVariable String subSectionId) {
        return sectionService.getSubSection(subSectionId);
    }

}
