package com.qakmak.eshop.controller;

import com.github.pagehelper.PageInfo;
import com.qakmak.eshop.common.User;
import com.qakmak.eshop.service.UserService;
import com.qakmak.eshop.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
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

//    @Autowired
//    private UserService userService;
@Autowired
private UserServiceImpl userService;

    public void saveUser(User user){}
    public void deleteUser(int userId){}
    public void updateUser(User user){}

    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "userId", value = "user id", required = true)
    })
    @RequestMapping(value = "/queryByUserId", method = RequestMethod.POST)
    public User queryByUserId(@RequestParam(value = "userId",required = true) Integer userId
                              ){
        return userService.queryByUserId(userId);
    }
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public PageInfo<User> queryAll(){
        return userService.queryAll();
    }
    public PageInfo<User> fuzzyQuery(String key){
        return null;
    }
}
