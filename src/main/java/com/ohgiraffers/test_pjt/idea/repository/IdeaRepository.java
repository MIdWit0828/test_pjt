package com.ohgiraffers.test_pjt.idea.repository;

import com.ohgiraffers.test_pjt.idea.entity.Idea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;


public interface IdeaRepository extends JpaRepository<Idea,Integer> {

    public List<Idea> findByIdeaNameContaining(String IdeaName);

    @Query(
        value = "SELECT " +
                "    i.*, c.category_code AS category_code_category, c.category_name AS category_name_category" +
                " FROM " +
                "    tbl_idea i " +
                " JOIN " +
                "    tbl_category c " +
                " ON " +
                "    i.category_code = c.category_code " +
                " ORDER BY " +
                "    i.idea_code DESC " +
                " LIMIT " +
                "    1",
        nativeQuery = true
    )
    Idea getLastInsertedIdea();
}
