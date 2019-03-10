package com.qakmak.eshop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.qakmak.eshop.common.User;

/**
 * @author tapakkur
 * @ProjectName eshop
 * @Date 2019/2/24 1:03
 */
public interface UserService {

    void saveUser(User user);
    void deleteUser(int userId);
    void updateUser(User user);
    User queryByUserId(int userId);
    PageInfo<User> queryAll();
    PageInfo<User> fuzzyQuery(String key);
}
