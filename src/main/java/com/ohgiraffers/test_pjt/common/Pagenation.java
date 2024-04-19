package com.ohgiraffers.test_pjt.common;

import org.springframework.data.domain.Page;

public class Pagenation {
    public static PagingButton getPagingButtonInfo(Page page) {
        int currentPage = page.getNumber() + 1; //page는 0부터 시작하므로 현재 패이지는 +1
        int defaultButtonCount = 10;            //각 패이지 마다 10장씩 보여줌
        int startPage
                = (int) (Math.ceil((double) currentPage / defaultButtonCount) - 1)
                * defaultButtonCount + 1;
        int endPage = startPage + defaultButtonCount - 1;
        if(page.getTotalPages() < endPage) endPage = page.getTotalPages();
        if(page.getTotalPages() == 0 && endPage == 0) endPage = startPage;
        return new PagingButton(currentPage, startPage, endPage);
    }
}
