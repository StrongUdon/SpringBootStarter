package kr.co.demo.base.mapper;

import kr.co.demo.base.domain.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RootMapper {
    void selectUser();
    int selectUserByEmail(String email);
    int insertUser(User user);
    int selectUserbyEmailPw(User user);
    int plz();
}
