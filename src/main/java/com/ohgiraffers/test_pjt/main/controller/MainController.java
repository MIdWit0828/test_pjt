package com.ohgiraffers.test_pjt.main.controller;

import com.ohgiraffers.test_pjt.idea.dto.IdeaRegistDTO;
import com.ohgiraffers.test_pjt.idea.entity.Idea;
import com.ohgiraffers.test_pjt.main.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Locale;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final MainService mainService;
    private final MessageSourceAccessor accessor;
    @GetMapping(value = {"/","/main"})
    public String mainPage() {
        return "main/main";
    }

    @ResponseBody
    @GetMapping("/create_dummy")
    public String createDummyIdeaForTest() {
        String answer = "";
        int result = 0;
        for (int i = 0; i < 100; i++) {
            int rdRank = (int) (Math.random() * 5) + 1;
            int rdCategoryCode = (int) (Math.random() * 7) + 1;
            IdeaRegistDTO newidea = new IdeaRegistDTO("더미아이디어" + (i + 1), rdRank, rdCategoryCode);
            result += mainService.createDummyIdeaForTest(newidea);
        }

        if (result > 0) {
            answer = accessor.getMessage("create_dummy.success", Locale.KOREA) + result;
        } else {
            answer = accessor.getMessage("create_dummy.fail");
        }
        return answer;
    }
}
