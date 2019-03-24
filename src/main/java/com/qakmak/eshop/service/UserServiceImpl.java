package com.qakmak.eshop.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;
import com.qakmak.eshop.common.User;
import com.qakmak.eshop.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
    public User findUser(Integer userId) {
        return userDao.findUser(userId);
    }

    @Override
    public PageInfo<User> queryAll(Integer page, Integer pageSize) {
        List<User> resultList = userDao.queryAll(); // 查询用户信息的结果
        Integer count = resultList.size();
        //封装返回结果
        Page<User> pageSetting = new Page<>(page,pageSize);
        pageSetting.setTotal (count);
        PageInfo<User> pageInfo = new PageInfo<>( pageSetting);
        pageInfo.setList(resultList);
        return pageInfo;
    }

    @Override
    public PageInfo<User> findAllUser(Integer page, Integer pageSize) {
        List<User> resultList = userDao.findAllUser(); // 查询用户信息的结果
        Integer count = resultList.size();
        //封装返回结果
        Page<User> pageSetting = new Page<>(page,pageSize);
        pageSetting.setTotal (count);
        PageInfo<User> pageInfo = new PageInfo<>( pageSetting);
        pageInfo.setList(resultList);
        return pageInfo;
    }

    @Override
    public PageInfo<User> fuzzyQuery(String key,Integer page, Integer pageSize) {
        List<User> resultList = userDao.fuzzyQuery(key); // 查询数据结果
        Integer count = resultList.size(); // 查询数据量

//        封装返回结果
        Page<User> pageSetting = new Page<>(page, pageSize); // 设置分页的当前页面和页面大小
        pageSetting.setTotal(count); // 总数据量
        PageInfo<User> pageInfo = new PageInfo <>(pageSetting);
        pageInfo.setList(resultList);
        return pageInfo;
    }

    @Override
    public PageInfo<User> fuzzyFindUser(String userName,Integer page, Integer pageSize) {
        List<User> resultList = userDao.fuzzyQuery(userName); // 查询数据结果
        Integer count = resultList.size(); // 查询数据量

//        封装返回结果
        Page<User> pageSetting = new Page<>(page, pageSize); // 设置分页的当前页面和页面大小
        pageSetting.setTotal(count); // 总数据量
        PageInfo<User> pageInfo = new PageInfo <>(pageSetting);
        pageInfo.setList(resultList);
        return pageInfo;
    }

}
