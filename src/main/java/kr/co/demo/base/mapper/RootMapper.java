package kr.co.demo.base.mapper;

import kr.co.demo.base.common.util.Pagination;
import kr.co.demo.base.domain.Category;
import kr.co.demo.base.domain.Product;
import kr.co.demo.base.domain.SubCategory;
import kr.co.demo.base.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface RootMapper  {
    List<User> selectUser() ;
    int selectUserByEmail(String email);
    int selectUserByEmailPw(User user);
    int insertUser(User user);
    int setUserState(User user);
    int ShallowDeleteUserByEmail(String email);
    int deepDeleteUserByEmail(String email);

    List<Category> selectCategory();
    int insertCategory(Category category);
    int updateCategory(Category category);
    int deleteCategory(String code);

    List<SubCategory> selectSubCategory();
    int insertSubCategory(SubCategory subcategory);
    int updateSubCategory(SubCategory subcategory);
    int deleteSubCategory(String code);

    List<Product> selectProduct(int pageSize, int startIndex);
    List<Product> selectProductByCategory(String categoryCode);
    int selectProductCnt();
    int insertProductSimple(Product product);
    int insertProductDeep(Product product);
    int updateProduct(Product product);
    int deleteProduct(String productId);
}
