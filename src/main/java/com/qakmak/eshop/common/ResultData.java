package com.qakmak.eshop.common;

/**
 * @author tapakkur
 * @ProjectName online-shop
 * @Date 2019/3/26 11:06
 */
public class ResultData {

    /**
     * 解读本系统常用的几种 HTTP 状态码（code）：
     *
     * 200（OK）：请求已成功，当前操作执行状态正常；
     * 400（Bad Request）：
     *  请求参数有误，因此无法被服务器解读，修改参数内容再提交，否则客户端不应该重复提交这个请求；
     * 401（Unauthorized）：当前请求需要用户验证；
     * 403（Forbidden）：服务器已经理解请求，但是拒绝执行它；
     * 404（Not found）：请求失败，请求所希望得到的资源未被在服务器上发现。
     */

    private int code; // 状态码
    private String message; // 响应信息
    private Object data; // 存放响应数据

    public ResultData(){
        //
    }

    public ResultData(int code, String message, Object data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
