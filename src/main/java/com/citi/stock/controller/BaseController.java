package com.citi.stock.controller;


import com.auth0.jwt.exceptions.TokenExpiredException;
import com.citi.stock.controller.ex.FileEmptyException;
import com.citi.stock.controller.ex.FileUploadException;
import com.citi.stock.interceptor.ex.JwtException;
import com.citi.stock.service.ex.*;
import com.citi.stock.util.JsonResult;
import org.apache.tomcat.util.http.fileupload.impl.FileUploadIOException;
import org.springframework.web.bind.annotation.ExceptionHandler;


/** 控制层类的基类 */
public class BaseController {
    // 操作成功的状态码
    public static final int OK = 200;

    // @ExceptionHandler用于统一处理方法抛出的异常
    @ExceptionHandler({ServiceException.class, FileUploadException.class, JwtException.class})
    public JsonResult<Void> handleException(Throwable e)
    {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof FileEmptyException) {
            result.setState(6000);
            result.setMessage("上传数据为空");
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
            result.setMessage("上传文件异常");
        } else if (e instanceof JwtException) {
            result.setState(7000);
            result.setMessage("用户token验证异常");
        } else if (e instanceof TokenExpiredException) {
            result.setState(7000);
            result.setMessage("token失效，请重新登录");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(5000);
            result.setMessage("密码错误");
        } else if (e instanceof UserNotFoundException) {
            result.setState(5000);
            result.setMessage("邮箱用户不存在");
        } else if (e instanceof UsernameDuplicateException) {
            result.setState(5000);
            result.setMessage("邮箱用户已存在，请输入密码登录");
        } else if (e instanceof InsertException) {
            result.setState(4000);
            result.setMessage("数据库插入故障，请联系管理员");
        } else if (e instanceof UpdateException) {
            result.setState(4000);
            result.setMessage("数据库信息更新故障，请联系管理员");
        }
        return result;
    }

}
