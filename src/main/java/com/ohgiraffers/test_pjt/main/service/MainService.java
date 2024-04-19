package com.ohgiraffers.test_pjt.main.service;

import com.ohgiraffers.test_pjt.idea.dto.IdeaDTO;
import com.ohgiraffers.test_pjt.idea.dto.IdeaRegistDTO;
import com.ohgiraffers.test_pjt.idea.entity.Idea;
import com.ohgiraffers.test_pjt.idea.repository.IdeaRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class MainService {
    private final IdeaRepository repository;
    private final ModelMapper modelMapper;
    @Transactional
    public int createDummyIdeaForTest(IdeaRegistDTO dto) {
        repository.save(modelMapper.map(dto, Idea.class));
        return 1;
    }
}
