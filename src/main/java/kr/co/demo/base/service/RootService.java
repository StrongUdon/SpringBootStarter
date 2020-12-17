package kr.co.demo.base.service;


import kr.co.demo.base.domain.api.User;
import kr.co.demo.base.mapper.RootMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RootService {

    @Autowired
    RootMapper rootMapper;

    public boolean checkEmail(String email){
        if(rootMapper.selectUserByEmail(email) < 1){
            return true;
        }
        return false;
    }

    public boolean insertUser(User user){
        if(rootMapper.insertUser(user) > 0){
            return true;
        }
        return false;
    }

    public boolean loginCheck(User user){
        if(rootMapper.selectUserbyEmailPw(user) > 0){
            return true;
        }
        return false;
    }
}
