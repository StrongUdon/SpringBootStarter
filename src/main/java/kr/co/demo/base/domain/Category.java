package kr.co.demo.base.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
CREATE TABLE category(
        code VARCHAR(20),
        description VARCHAR(50),
        CONSTRAINT base_category_pk PRIMARY KEY(code)
        );
*/
@Getter
@Setter
@AllArgsConstructor
public class Category {

    private String code;
    private String description;
}
