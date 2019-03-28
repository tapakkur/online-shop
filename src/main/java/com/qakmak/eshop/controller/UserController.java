package com.qakmak.eshop.controller;

import com.github.pagehelper.PageInfo;
import com.qakmak.eshop.AppRun;
import com.qakmak.eshop.common.ResultData;
import com.qakmak.eshop.common.User;
import com.qakmak.eshop.service.UserServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

/**
 * @author tapakkur
 * @ProjectName eshop
 * @Date 2019/2/24 1:29
 */

//@Controller表明该类内的所有方法默认返回页面路径，加了@ResponseBody的方法返回数据。
//@RestController则是相当于@Controller@ResponseBody两个注解，该类返回的都是数据，不返回页面。
@RestController
//@Controller
@Api(value = "用户信息管理", description = "管理用户信息，并提供相应的服务的后台接口")
@RequestMapping(value = "/user")
public class UserController {

    //    输出日志信息
    private static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserServiceImpl userService;

    @ApiOperation(value = "添加用户", notes = "添加用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "id", value = "用户编号",required = true),
        @ApiImplicitParam(paramType = "query", name = "name", value = "用户姓名",required = true),
        @ApiImplicitParam(paramType = "query", name = "loginName", value = "登录名",required = true),
        @ApiImplicitParam(paramType = "query", name = "password", value = "登录密码",required = true),
        @ApiImplicitParam(paramType = "query", name = "phone", value = "手机号",required = true),
        @ApiImplicitParam(paramType = "query", name = "address", value = "用户地址",required = true)
    })
    @RequestMapping(value = "/saveUser", method = RequestMethod.POST)
    public void saveUser(
         @RequestParam(value = "id") Integer id,
         @RequestParam(value = "name") String name,
         @RequestParam(value = "loginName") String loginName,
         @RequestParam(value = "password") String password,
         @RequestParam(value = "phone") String phone,
         @RequestParam(value = "address") String address
    ){
        User user = new User(id,name,loginName,password,phone,address);
        userService.saveUser(user);
    }

    @ApiOperation(value = "删除用户", notes = "删除用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true)
    })
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public void deleteUser(@RequestParam(value = "userId") Integer userId){
        userService.deleteUser(userId);
    }

    @ApiOperation(value = "修改用户", notes = "修改用户信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "id", value = "用户编号",required = true),
        @ApiImplicitParam(paramType = "query", name = "name", value = "用户姓名"),
        @ApiImplicitParam(paramType = "query", name = "loginName", value = "登录名"),
        @ApiImplicitParam(paramType = "query", name = "password", value = "登录密码"),
        @ApiImplicitParam(paramType = "query", name = "phone", value = "手机号"),
        @ApiImplicitParam(paramType = "query", name = "address", value = "用户地址")
    })
    @RequestMapping(value = "/updateUser", method = RequestMethod.POST)
    public void updateUser(
        @RequestParam(value = "id") Integer id,
        @RequestParam(value = "name") String name,
        @RequestParam(value = "loginName") String loginName,
        @RequestParam(value = "password") String password,
        @RequestParam(value = "phone") String phone,
        @RequestParam(value = "address") String address
    ){
        User user = new User(id,name,loginName,password,phone,address);
        userService.updateUser(user);
    }

    @ApiOperation(value = "查询个体用户的所有信息", notes = "查询个体用户的所有信息（包括订单，产品信息）")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true)
    })
    @RequestMapping(value = "/queryByUserId", method = RequestMethod.POST)
    public ResultData queryByUserId(
        @RequestParam(value = "userId") Integer userId
    ){
        ResultData resultData = new ResultData();
        resultData.setCode(200);
        resultData.setMessage("成功执行<queryByUserId>");
        resultData.setData(userService.queryByUserId(userId));
        return resultData;
    }

    @ApiOperation(value = "查询个体用户的个人信息", notes = "查询个体用户的个人信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "userId", value = "用户id", required = true)
    })
    @RequestMapping(value = "/findUser", method = RequestMethod.POST)
    public ResultData findUser(
        @RequestParam(value = "userId") Integer userId
    ) {
        ResultData resultData = new ResultData();
        resultData.setCode(200);
        resultData.setMessage("成功执行<findUser>");
        resultData.setData(userService.findUser(userId));
        return resultData;
    }

    @ApiOperation(value = "分页查询所有用户的所有信息", notes = "分页查询所有用户的所有信息（包括订单，产品信息）")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", defaultValue = "1"),
        @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示的记录数", defaultValue = "10")
    })
    @RequestMapping(value = "/queryAll", method = RequestMethod.POST)
    public PageInfo<User> queryAll(
        @RequestParam(value = "page") Integer page,
        @RequestParam(value = "pageSize") Integer pageSize
    ){
        return userService.queryAll(page, pageSize);
    }

    @ApiOperation(value = "分页查询所有用户的个人信息", notes = "分页查询所有用户的个人信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", defaultValue = "1"),
        @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示的记录数", defaultValue = "10")
    })
    @RequestMapping(value = "/findAllUser", method = RequestMethod.POST)
    public PageInfo<User> findAllUser(
        @RequestParam(value = "page") Integer page,
        @RequestParam(value = "pageSize") Integer pageSize
    ){
        return userService.findAllUser(page,pageSize);
    }

    @ApiOperation(value = "分页模糊查询（多个）用户的所有信息", notes = "分页模糊查询（多个）用户的所有信息（包括订单，产品信息）")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", defaultValue = "1"),
        @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示的记录数", defaultValue = "10"),
        @ApiImplicitParam(paramType = "query", name = "key", value = "按姓名模糊查询", required = true)
    })
    @RequestMapping(value = "/fuzzyQuery", method = RequestMethod.POST)
    public PageInfo<User> fuzzyQuery(
         @RequestParam(value = "key") String key,
         @RequestParam(value = "page") Integer page,
         @RequestParam(value = "pageSize") Integer pageSize
    ){
        return userService.fuzzyQuery(key,page,pageSize);
    }

    @ApiOperation(value = "分页模糊查询（多个）用户的个人信息", notes = "分页模糊查询(多个)用户的个人信息")
    @ApiImplicitParams({
        @ApiImplicitParam(paramType = "query", name = "page", value = "当前页", defaultValue = "1"),
        @ApiImplicitParam(paramType = "query", name = "pageSize", value = "每页显示的记录数", defaultValue = "10"),
        @ApiImplicitParam(paramType = "query", name = "key", value = "按姓名模糊查询", required = true)
    })
    @RequestMapping(value = "/fuzzyFindUser", method = RequestMethod.POST)
    public PageInfo<User> fuzzyFindUser(
        @RequestParam(value = "key") String key,
        @RequestParam(value = "page") Integer page,
        @RequestParam(value = "pageSize") Integer pageSize
    ){
        return userService.fuzzyFindUser(key,page,pageSize);
    }

    @ApiOperation(value = "登录系统", notes = "通过身份验证后登入系统")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "loginName", value = "登录名", required = true),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true)
    })
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public ResultData checkLogin(
            @RequestParam(value = "loginName") String loginName,
            @RequestParam(value = "password") String password
    ){
        User user = userService.queryByLoginName(loginName);
        ResultData resultData = new ResultData();
        if (user != null && user.getPassword().equals(password)){
            logger.info("欢迎您："+user.getName());
            resultData.setCode(200); // status is normal
            resultData.setMessage("身份验证成功");
            resultData.setData(user);
            return resultData;
        }
        logger.info("身份验证失败，请重新输入！");
        resultData.setCode(400); // bad request
        resultData.setMessage("身份验证失败");
        resultData.setData(null);
        return resultData;
    }

    /**
     * 本地访问内容地址 ：http://localhost:8080/user/hello
     * @return
     *
     * 提示：由于本项目初衷是实现微服务后台接口，因此在这儿暂时不提供相应的页面访问功能
     * 后续更新项目的时候再加访问页面的功能
     */
//    @RequestMapping("/hello")
//    public String helloHtml(Model model) {
//        model.addAttribute("say","欢迎欢迎,热烈欢迎");
//        return "hello";
//    }

}
