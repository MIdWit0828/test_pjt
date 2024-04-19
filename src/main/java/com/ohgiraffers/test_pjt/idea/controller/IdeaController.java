package com.ohgiraffers.test_pjt.idea.controller;

import com.ohgiraffers.test_pjt.common.Pagenation;
import com.ohgiraffers.test_pjt.common.PagingButton;
import com.ohgiraffers.test_pjt.idea.dto.CategoryDTO;
import com.ohgiraffers.test_pjt.idea.dto.IdeaDTO;
import com.ohgiraffers.test_pjt.idea.dto.IdeaRegistDTO;
import com.ohgiraffers.test_pjt.idea.service.CategoryService;
import com.ohgiraffers.test_pjt.idea.service.IdeaService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Slf4j
@Controller
@RequestMapping("/idea")
@RequiredArgsConstructor
public class IdeaController {
    private final IdeaService ideaService;
    private final CategoryService categoryService;

    @GetMapping("/{ideaCode}")
    public String findIdeaByIdeaCode(@PathVariable int ideaCode, Model model) {
        IdeaDTO foundIdea = ideaService.findIdeaByIdeaCode(ideaCode);
        model.addAttribute("idea", foundIdea);

        return "/idea/view_one";
    }

    @GetMapping("/list")
    public void findAllIdea(@PageableDefault Pageable pageable, Model model) {
        Page<IdeaDTO> ideaList = ideaService.findAllIdea(pageable);
        log.info("{}", ideaList.getContent());
        log.info("{}", ideaList.getTotalPages());
        log.info("{}", ideaList.getTotalElements());
        log.info("{}", ideaList.getSize());
        log.info("{}", ideaList.getNumberOfElements());
        log.info("{}", ideaList.isFirst());
        log.info("{}", ideaList.isLast());
        log.info("{}", ideaList.getSort());
        log.info("{}", ideaList.getNumber());

        PagingButton paging = Pagenation.getPagingButtonInfo(ideaList);

        model.addAttribute("ideaList", ideaList);
        model.addAttribute("paging", paging);
    }

    @GetMapping("/search")
    public String findByMenuName(String ideaNmae, Model model) {
        List<IdeaDTO> ideaList = ideaService.findByMenuName(ideaNmae);
        model.addAttribute("ideaList", ideaList);
        return "/search/result";
    }

    @GetMapping("/regist")
    public void registPage() {

    }

    @PostMapping("/regist")
    public String saveNewIdea(@ModelAttribute IdeaRegistDTO newIdea) {
        ideaService.saveNewIdea(newIdea);
        log.info("아이디어 추가 완료");
        IdeaDTO idea = ideaService.getLastInsertedIdea();
        log.info("추가된 아이디어 : {}", idea);
        return "redirect:/idea/" + idea.getIdeaCode();
    }

    @ResponseBody
    @GetMapping("/get_category")
    public List<CategoryDTO> getCategoryList() {
        return categoryService.findAll();
    }

    @GetMapping("/modify")
    public void modifyPage() {

    }

    @PostMapping("/modify")
    public void modifyIdea(@ModelAttribute IdeaDTO dto) {
        ideaService.modifyIdea(dto);
    }

    @GetMapping("/delete")
    public String deleteIdea(int ideaCode, RedirectAttributes attributes) {
        ideaService.deleteById(ideaCode);
        attributes.addFlashAttribute("message", "아이디어가 삭제되었습니다.");
        return "redirect:/main";
    }
}
