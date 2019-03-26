package com.qakmak.eshop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.qakmak.eshop.common.User;
import io.swagger.models.auth.In;

import java.util.List;

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
    User queryByLoginName(String loginName);
//    User checkLogin(String loginName, String password);
    User findUser(Integer userId);
    PageInfo<User> queryAll(Integer page, Integer pageSize);
    PageInfo<User> findAllUser(Integer page, Integer pageSize);
    PageInfo<User> fuzzyQuery(String key,Integer page, Integer pageSize);
    PageInfo<User> fuzzyFindUser(String userName,Integer page, Integer pageSize);

}
