package com.qakmak.eshop.controller;

import com.github.pagehelper.PageInfo;
import com.qakmak.eshop.common.User;
import com.qakmak.eshop.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tapakkur
 * @ProjectName eshop
 * @Date 2019/2/24 1:29
 */
@RestController
@Api(value = "用户信息管理", description = "管理平台里注册的用户的信息，并提供相应的服务")
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "添加用户", notes = "添加用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "用户编号"),
            @ApiImplicitParam(paramType = "query", name = "name", value = "用户姓名"),
            @ApiImplicitParam(paramType = "query", name = "loginName", value = "登录名"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "登录密码"),
            @ApiImplicitParam(paramType = "query", name = "phone", value = "手机号"),
            @ApiImplicitParam(paramType = "query", name = "address", value = "用户地址")
    })
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public void saveUser(
            @RequestParam(value = "id",required = true) Integer id,
             @RequestParam(value = "name",required = true) String name,
             @RequestParam(value = "loginName", required = true) String loginName,
             @RequestParam(value = "password", required = true) String password,
             @RequestParam(value = "phone" ,required = true) String phone,
             @RequestParam(value = "address",required = true) String address
             ){
        User user = new User(id,name,loginName,password,phone,address);
        userService.saveUser(user);
    }

    @ApiOperation(value = "删除用户", notes = "删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true)
    })
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public void deleteUser(@RequestParam(value = "userId", required = true) Integer userId){
        userService.deleteUser(userId);
    }

    @ApiOperation(value = "更新用户", notes = "更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "name", value = "用户姓名"),
            @ApiImplicitParam(paramType = "query", name = "loginName", value = "登录名"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "登录密码"),
            @ApiImplicitParam(paramType = "query", name = "phone", value = "手机号"),
            @ApiImplicitParam(paramType = "query", name = "address", value = "用户地址")
    })
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public void updateUser(
            @RequestParam(value = "name",required = true) String name,
            @RequestParam(value = "loginName", required = true) String loginName,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "phone" ,required = true) String phone,
            @RequestParam(value = "address",required = true) String address
    ){
        User user = new User(name,loginName,password,phone,address);
        userService.updateUser(user);
    }

    @ApiOperation(value = "按用户ID查询", notes = "按用户ID查询具体的用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "user id", required = true)
    })
    @RequestMapping(value = "/queryByUserId", method = RequestMethod.POST)
    public User queryByUserId(@RequestParam(value = "userId",required = true) Integer userId
                              ){
        return userService.queryByUserId(userId);
    }

    @ApiOperation(value = "查询所用用户信息", notes = "查询所用用户信息")
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public PageInfo<User> queryAll(@RequestParam(value = "Page", required = false, defaultValue = "1") Integer page,
                                   @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
                                   ){
        return userService.queryAll(page, pageSize);
    }

    @ApiOperation(value = "模糊查询", notes = "按用户名模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "key", value = "user name", required = true)
    })
    @RequestMapping(value = "/fuzzyQuery", method = RequestMethod.POST)
    public PageInfo<User> fuzzyQuery(@RequestParam(value = "key") String key,
                                     @RequestParam(value = "Page", required = false, defaultValue = "1") Integer page,
                                     @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize
                                     ){
        return userService.fuzzyQuery(key,page,pageSize);
    }
}
