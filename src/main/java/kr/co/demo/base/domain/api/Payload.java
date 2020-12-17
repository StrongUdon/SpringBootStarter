package kr.co.demo.base.domain.api;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

//    채팅앱 메시지 객체
//    origin : 일반 회원
//    destination : 운영자
//    msgType : 메시지 타입
//    body : 메시지 내용
@Setter
@Getter
public class Payload implements Serializable {
    private String origin;
    private String destination;
    private String msgType;
    private String body;
}
