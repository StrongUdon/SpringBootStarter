package kr.co.demo.base.service;


import kr.co.demo.base.mapper.RootMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RootService {

    @Autowired
    RootMapper rootMapper;

}
