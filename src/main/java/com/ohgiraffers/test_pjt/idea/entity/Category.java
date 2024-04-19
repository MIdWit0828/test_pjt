package com.ohgiraffers.test_pjt.idea.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Getter
@ToString
@Table(name = "tbl_category")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Category {
    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;

    public void modifyAll(int categoryCode, String categoryName) {
        this.categoryCode = categoryCode;
        this.categoryName = categoryName;
    }
}
