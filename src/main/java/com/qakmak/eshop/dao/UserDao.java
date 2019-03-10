package com.qakmak.eshop.dao;

import com.qakmak.eshop.common.User;

import java.util.List;

/**
 * @author tapakkur
 * @ProjectName eshop
 * @Date 2019/2/16 19:57
 */
public interface UserDao {
    public void saveUser (User user); // 添加用户
    public void deleteUser (int userId); // 删除用户
    public void updateUser (User user); // 更新用户
    public User queryByUserId (int userId); // 按用户ID查询
    public List<User> queryAll (); // 查询所用用户
    public List<User> fuzzyQuery (String userName); // 按姓名模糊查询
}
