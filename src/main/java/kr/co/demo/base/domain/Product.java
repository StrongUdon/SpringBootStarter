package kr.co.demo.base.domain;

import lombok.*;

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

@AllArgsConstructor
@RequiredArgsConstructor
@Getter
@Setter
public class Product extends CommonList implements Serializable {
    private int productId;
    @NonNull
    private String name;
    @NonNull
    private int price;
    @NonNull
    private String subCategoryCode;
    private boolean onSale;
    private boolean onDiscount;
    private Timestamp createdAt;
}
