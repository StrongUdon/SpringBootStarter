package kr.co.demo.base.domain.api;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@AllArgsConstructor
public class ChatRequest implements Serializable {
    private String content;
}
