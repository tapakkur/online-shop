package com.qakmak.eshop.service;

import com.github.pagehelper.PageInfo;
import com.qakmak.eshop.common.User;
import com.qakmak.eshop.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author tapakkur
 * @ProjectName eshop
 * @Date 2019/2/24 1:01
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public void saveUser(User user) {
        userDao.saveUser(user);
    }

    @Override
    public void deleteUser(int userId) {
        userDao.deleteUser(userId);
    }

    @Override
    public void updateUser(User user) {
        userDao.updateUser(user);
    }

    @Override
    public User queryByUserId(int userId) {
        return userDao.queryByUserId(userId);
    }

    @Override
    public PageInfo<User> queryAll() {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setList(userDao.queryAll());
        return pageInfo;
    }

    @Override
    public PageInfo<User> fuzzyQuery(String key) {
        PageInfo pageInfo = new PageInfo();
        pageInfo.setList(userDao.fuzzyQuery(key));
        return pageInfo;
    }
}
