package base.springboot.book1.chapter7.dao;

import base.springboot.book1.chapter7.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;


import java.util.List;

/**
 * @author Clay
 * @date 2019/12/23 10:29
 */
@Mapper
public interface UserMapper {

    // 获取单个用户
    User getUser(Long id);

    // 保存用户
    int insertUser(User user);

    // 修改用户
    int updateUser(User user);

    // 查询用户，指定MyBatis的参数名称
    List<User> findUsers(@Param("userName") String userName,
                         @Param("note") String note);

    // 删除用户
    int deleteUser(Long id);
}
