package com.qakmak.eshop.controller;

import com.github.pagehelper.PageInfo;
import com.qakmak.eshop.common.User;
import com.qakmak.eshop.service.UserService;
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
@Api(value = "qakmak 商城", description = "qakmak 商城是个在线购物平台")
@RequestMapping(value = "/qakmak")
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "添加用户", notes = "添加用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "user", value = "用户")
    })
    @RequestMapping(value = "saveUser/", method = RequestMethod.POST)
    public void saveUser(@RequestParam(value = "user") User user){
        userService.saveUser(user);
    }

    @ApiOperation(value = "删除用户", notes = "删除用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true)
    })
    @RequestMapping(value = "deleteUser/", method = RequestMethod.POST)
    public void deleteUser(@RequestParam(value = "userId", required = true) Integer userId){
        userService.deleteUser(userId);
    }

    @ApiOperation(value = "更新用户", notes = "更新用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "user", value = "用户")
    })
    @RequestMapping(value = "updateUser/", method = RequestMethod.POST)
    public void updateUser(User user){
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
    public PageInfo<User> queryAll(){
        return userService.queryAll();
    }

    @ApiOperation(value = "模糊查询", notes = "按用户名模糊查询")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "key", value = "user name", required = true)
    })
    @RequestMapping(value = "fuzzyQuery/", method = RequestMethod.POST)
    public PageInfo<User> fuzzyQuery(@RequestParam(value = "key") String key){
        return userService.fuzzyQuery(key);
    }
}
