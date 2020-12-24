package kr.co.demo.base.common.util;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Pagination {

    /**
     * 한 페이지당 게시글 수
     **/
    private int pageSize = 10;

    /**
     * 한 블럭(range)당 페이지 수
     **/
    private int rangeSize = 5;

    /**
     * 현재 페이지
     **/
    private int currentPage = 1;

    /**
     * 현재 블럭(range)
     **/
    private int currentRange = 1;

    /**
     * 총 게시글 수
     **/
    private int listCount;

    /**
     * 총 페이지 수
     **/
    private int pageCount;

    /**
     * 총 블럭(range) 수
     **/
    private int rangeCount;

    /**
     * 시작 페이지
     **/
    private int startPage = 1;

    /**
     * 끝 페이지
     **/
    private int endPage;

    /**
     * 시작 index
     **/
    private int startIndex = 0;

    /**
     * 이전 페이지
     **/
    private int previousPage;

    /**
     * 다음 페이지
     **/
    private int nextPage;

    public Pagination(int listCount, int currentPage){
        /**
         * 1. 총 페이지 수
         * 2. 총 블럭 수
         * 3. 블럭 세팅
         */

        /** 현재페이지 **/
        setCurrentPage(currentPage);

        /** 총 게시물 수 **/
        setListCount(listCount);

        /** 1. 총 페이지 수 **/
        setPageCount(listCount);

        /** 2. 총 블럭 수 **/
        setRangeCount(pageCount);

        /** 3. 블럭 세팅 **/
        rangeSetting(currentPage);

        /** DB 질의를 위한 startIndex 설정 **/
        setStartIndex(currentPage);
    }

    public void setPageCount(int listCount) {
        this.pageCount = (int) Math.ceil(listCount * 1.0 / pageSize);
    }

    public void setRangeCount(int pageCount){
        this.rangeCount = (int) Math.ceil(listCount * 1.0 / rangeSize);
    }
    public void setCurrentPage(int currentPage) {
        this.currentRange = (int) ((currentPage - 1) / rangeSize) + 1;
    }

    public void setStartIndex(int currentPage){
        this.startIndex = (currentPage - 1) * pageSize;
    }
    public void rangeSetting(int currentPage){
        setCurrentRange(currentRange);

        this.startPage = (currentRange -1) * rangeSize + 1;
        this.endPage = startPage + rangeSize - 1;

        if(endPage > pageCount) {
            this.endPage = pageCount;
        }

        this.previousPage = currentPage - 1;
        this.nextPage = currentPage + 1;
    }
}
