package com.ifba.proj_inov.api.mapper;

import com.ifba.proj_inov.api.dto.PageableDto;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;

public class PageableMapper {

    public PageableMapper() {
        // Private constructor to prevent instantiation
    }

    public static PageableDto toDto(Page page) {
        return new ModelMapper().map(page, PageableDto.class);
    }
}
