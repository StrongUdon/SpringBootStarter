package kr.co.demo.base.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RootMapper {
    void selectUser();

}
