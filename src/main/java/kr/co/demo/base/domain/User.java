package kr.co.demo.base.domain;

import kr.co.demo.base.common.enums.UserTypeEnum;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

/*
CREATE TABLE user(
	email VARCHAR(100),
	pw VARCHAR(50) NOT NULL,
	role_enum ENUM('NOT', 'VER', 'ADM'),
	first_name VARCHAR(20) NOT NULL,
	last_name VARCHAR(20) NOT NULL,
	phone VARCHAR(45) UNIQUE NOT NULL,
	created_at DATETIME DEFAULT NOW(),
	is_dormant BOOL DEFAULT false,
	CONSTRAINT base_user_pk PRIMARY KEY(email)
);
*/
@Getter
@Setter
@RequiredArgsConstructor
public class User implements Serializable {

    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String roleEnum;
    @NonNull
    private String firstName;
    @NonNull
    private String lastName;
    @NonNull
    private String phone;
    private Timestamp createdAt;

}
