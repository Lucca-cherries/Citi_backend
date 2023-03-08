package com.citi.stock.controller;


import com.citi.stock.controller.ex.FileEmptyException;
import com.citi.stock.controller.ex.FileUploadException;
import com.citi.stock.interceptor.ex.JwtException;
import com.citi.stock.service.ex.PasswordNotMatchException;
import com.citi.stock.service.ex.ServiceException;
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
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(5000);
            result.setMessage("密码错误");
        }
        return result;
    }

}
