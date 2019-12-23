package base.springboot.book1.chapter7.service;

import base.springboot.book1.chapter7.domain.User;

import java.util.List;

/**
 * @author tangwei
 * @date 2019/12/23 10:33
 */
public interface UserService {
    /**
     * 获取单个用户
     * @param id
     * @return
     */
    User getUser(Long id);

    /**
     * 保存用户
     * @param user
     * @return
     */
    User insertUser(User user);

    /**
     * 修改用户，指定MyBatis的参数名称
     * @param id
     * @param userName
     * @return
     */
    User updateUserName(Long id, String userName);

    /**
     * 查询用户，指定MyBatis的参数名称
     * @param userName
     * @param note
     * @return
     */
    List<User> findUsers(String userName, String note);

    /**
     * 删除用户
     * @param id
     * @return
     */
    int deleteUser(Long id);
}
