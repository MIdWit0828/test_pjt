package com.ohgiraffers.test_pjt.idea.repository;


import com.ohgiraffers.test_pjt.idea.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
}
