package kr.co.demo.base.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/*
CREATE TABLE product(
        product_id BIGINT,
        name VARCHAR(100) NOT NULL,
        price INT(11),
        sub_category_code VARCHAR(20),
        on_sale BOOL DEFAULT false,
        on_discount BOOL DEFAULT false,
        created_at DATETIME DEFAULT NOW(),
        CONSTRAINT product_pk PRIMARY KEY(product_id),
        CONSTRAINT product_fk_sub_category FOREIGN KEY(sub_category_code) REFERENCES sub_category(code)
        );

*/
@Getter
@Setter
@AllArgsConstructor
public class Product implements Serializable {
    private int productID;
    private String name;
    private int price;
    private SubCategory subCategoryCode;
    private boolean onSale;
    private boolean onDiscount;
    private Timestamp createdAt;
}
