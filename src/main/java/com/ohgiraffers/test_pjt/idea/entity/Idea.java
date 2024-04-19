package com.ohgiraffers.test_pjt.idea.entity;

import com.ohgiraffers.test_pjt.idea.dto.IdeaDTO;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@Table(name = "tbl_idea")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Idea {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ideaCode;
    private String ideaName;
    private int ideaRank;
    @Column(columnDefinition = "default 0")
    private int ideaWorkCount;
//    private int categoryCode;
    @ManyToOne
    @JoinColumn(name="categoryCode")
    private Category category;

    public void modifyAll(IdeaDTO dto) {
        ideaName = dto.getIdeaName();
        ideaRank = dto.getIdeaRank();
        category.modifyAll(dto.getCategoryCode(), dto.getCategoryName());
    }
}
