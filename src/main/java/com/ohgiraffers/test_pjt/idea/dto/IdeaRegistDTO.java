package com.ohgiraffers.test_pjt.idea.dto;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class IdeaRegistDTO {
    private String ideaName;
    private int ideaRank;
    private int categoryCode;
}
