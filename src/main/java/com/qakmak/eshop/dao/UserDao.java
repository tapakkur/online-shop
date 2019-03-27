package com.qakmak.eshop.dao;

import com.qakmak.eshop.common.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @author tapakkur
 * @ProjectName eshop
 * @Date 2019/2/16 19:57
 */
//@Mapper
public interface UserDao {

    void saveUser(User user); // 添加用户
    void deleteUser(int userId); // 删除用户
    void updateUser (User user); // 修改用户
    User queryByUserId(int userId); // 查询用户的（所有）信息
    User queryByLoginName(String loginName); // 用于登录验证
    User findUser(Integer userId); // 查询用户的信息
    List<User> queryAll(); // 查询（所有）用户的（所有）信息
    List<User> findAllUser(); // 查询（所有）用户的信息
    List<User> fuzzyQuery(String userName); // 模糊查询用户的（所有）信息
    List<User> fuzzyFindUser(String userName); // 模糊查询用户的信息

}
