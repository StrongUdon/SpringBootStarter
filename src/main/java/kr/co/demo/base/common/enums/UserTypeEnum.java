package kr.co.demo.base.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum UserTypeEnum {
    NOT_VERIFIED("NOT", "본인인증 안된 회원"),
    VERIFIED("VER", "본인인증 된 회원"),
    ADMIN("ADMIN", "운영자");

    private final String code;
    private final String description;
}
