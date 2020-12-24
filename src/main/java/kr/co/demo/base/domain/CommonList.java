package kr.co.demo.base.domain;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommonList {
    private int currentPage = 1;
    private int startIndex;
    private int pageSize;
}
