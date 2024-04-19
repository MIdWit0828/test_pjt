package com.ohgiraffers.test_pjt.idea.dto;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.bind.annotation.GetMapping;

@Getter
@Setter
@ToString
public class CategoryDTO {
    private int categoryCode;
    private String categoryName;
}
