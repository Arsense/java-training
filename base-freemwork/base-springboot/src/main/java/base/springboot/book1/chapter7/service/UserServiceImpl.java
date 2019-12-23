package base.springboot.book1.chapter7.service;

import base.springboot.book1.chapter7.dao.UserMapper;
import base.springboot.book1.chapter7.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author tangwei
 * @date 2019/12/23 10:30
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    // 获取id，取参数id缓存用户
    @Override
    @Transactional
    @Cacheable(value = "redisCache", key = "'redis_user_'+#id")
    public User getUser(Long id) {
        return userMapper.getUser(id);
    }


    @Override
    @CachePut(value = "redisCache", key = "'redis_user_'+#result.id")
    public User insertUser(User user) {
        userMapper.insertUser(user);
        return user;
    }

    @Override
    public User updateUserName(Long id, String userName) {
        return null;
    }

    @Override
    public List<User> findUsers(String userName, String note) {
        return null;
    }

    @Override
    public int deleteUser(Long id) {
        return 0;
    }
}


