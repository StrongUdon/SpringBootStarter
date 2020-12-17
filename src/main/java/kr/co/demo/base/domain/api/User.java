package kr.co.demo.base.domain.api;

import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;

@Getter
@Setter
@RequiredArgsConstructor
public class User implements Serializable {
    @NonNull
    private String email;
    @NonNull
    private String password;
    @NonNull
    private String name;
    private Timestamp createdAt;
}
