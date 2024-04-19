package com.ohgiraffers.test_pjt.idea.dto;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class IdeaDTO {
    private int ideaCode;
    private String ideaName;
    private int ideaRank;
    private int ideaWorkCount;
    private int categoryCode;
    private String categoryName;
}
