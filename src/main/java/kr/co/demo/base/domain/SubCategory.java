package kr.co.demo.base.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
CREATE TABLE sub_category(
        code VARCHAR(20),
        description VARCHAR(50),
        category_code VARCHAR(20),
        CONSTRAINT sub_category_pk PRIMARY KEY(code),
        CONSTRAINT sub_category_fk_category FOREIGN KEY(category_code) REFERENCES category(code)
        );
*/
@Getter
@Setter
@AllArgsConstructor
public class SubCategory {

    private final String code;
    private final String description;
    private final String categoryCode;
}
