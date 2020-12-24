package kr.co.demo.base.service;


import kr.co.demo.base.common.util.Pagination;
import kr.co.demo.base.domain.Product;
import kr.co.demo.base.domain.User;
import kr.co.demo.base.mapper.RootMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
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
        if(rootMapper.selectUserByEmailPw(user) > 0){
            return true;
        }
        return false;
    }
    public List<Product> productList(int pageSize, int startIndex){
        List<Product> productList = new ArrayList<>();

        productList = rootMapper.selectProduct(pageSize, startIndex);
        return productList;
    }
    public int productCount(){
        return rootMapper.selectProductCnt();
    }

    public int insertProduct(Product product){
        return rootMapper.insertProductSimple(product);
    }
}
