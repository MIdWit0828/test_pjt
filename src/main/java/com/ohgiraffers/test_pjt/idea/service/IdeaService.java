package com.ohgiraffers.test_pjt.idea.service;

import com.ohgiraffers.test_pjt.idea.dto.IdeaDTO;
import com.ohgiraffers.test_pjt.idea.dto.IdeaRegistDTO;
import com.ohgiraffers.test_pjt.idea.entity.Idea;
import com.ohgiraffers.test_pjt.idea.repository.IdeaRepository;
import jakarta.persistence.Id;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class IdeaService {
    private final IdeaRepository ideaRepository;
    private final ModelMapper modelMapper;

    public IdeaDTO findIdeaByIdeaCode(int ideaCode) {
        Idea foundIdea = ideaRepository.findById(ideaCode).orElseThrow(IllegalAccessError::new);
        return modelMapper.map(foundIdea, IdeaDTO.class);
    }

    public Page<IdeaDTO> findAllIdea(Pageable pageable) {
        pageable = PageRequest.of(
                pageable.getPageNumber() <= 0 ? 0 : pageable.getPageNumber() - 1,
                pageable.getPageSize(),
                Sort.by("IdeaCode").descending()
        );
        Page<Idea> foundIdeaList = ideaRepository.findAll(pageable);
        log.info("ideaList의 길이 {}", foundIdeaList.getSize());
        return foundIdeaList.map(idea -> modelMapper.map(idea, IdeaDTO.class));
    }

    public List<IdeaDTO> findByMenuName(String ideaNmae) {
        List<Idea> list = ideaRepository.findByIdeaNameContaining(ideaNmae);
        return list.stream().map(idea -> modelMapper.map(idea, IdeaDTO.class)).toList();
    }

    @Transactional
    public void saveNewIdea(IdeaRegistDTO newIdea) {
        Idea idea = modelMapper.map(newIdea, Idea.class);
        log.info("추가하려는 idea정보 : {}", idea);
        ideaRepository.save(idea);
    }

    public IdeaDTO getLastInsertedIdea() {
        Idea idea = ideaRepository.getLastInsertedIdea();
        ideaRepository.flush();
        return modelMapper.map(idea, IdeaDTO.class);
    }


    @Transactional
    public void modifyIdea(IdeaDTO dto) {
        Idea targetIdea = ideaRepository.findById(dto.getIdeaCode()).orElseThrow(IllegalAccessError::new);

        targetIdea.modifyAll(dto);
        ideaRepository.flush();
    }

    public void deleteById(int ideaCode) {
        ideaRepository.deleteById(ideaCode);
    }
}
