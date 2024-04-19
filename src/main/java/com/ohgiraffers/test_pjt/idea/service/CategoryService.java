package com.ohgiraffers.test_pjt.idea.service;

import com.ohgiraffers.test_pjt.idea.dto.CategoryDTO;
import com.ohgiraffers.test_pjt.idea.entity.Category;
import com.ohgiraffers.test_pjt.idea.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {
    private final CategoryRepository categoryRepository;
    private final ModelMapper modelMapper;

    public List<CategoryDTO> findAll() {

        List<Category> categoryList = categoryRepository.findAll();
        return categoryList.stream().map(category -> modelMapper.map(category, CategoryDTO.class)).toList();
    }
}
