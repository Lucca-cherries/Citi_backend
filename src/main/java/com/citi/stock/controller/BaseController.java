package com.citi.stock.controller;


import com.auth0.jwt.exceptions.TokenExpiredException;
import com.citi.stock.controller.ex.FileEmptyException;
import com.citi.stock.controller.ex.FileUploadException;
import com.citi.stock.interceptor.ex.JwtException;
import com.citi.stock.service.ex.*;
import com.citi.stock.util.JsonResult;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.apache.tomcat.util.http.fileupload.impl.FileUploadIOException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolationException;


/** 控制层类的基类 */
@RestControllerAdvice
@Tag(name = "控制层的基类，用于全局异常处理", description = "异常处理，返回前端信息和状态码")
public class BaseController {
    // 操作成功的状态码
    public static final int OK = 200;

    // @ExceptionHandler用于统一处理方法抛出的异常
    @ExceptionHandler({ServiceException.class,
            FileUploadException.class,
            JwtException.class,
            MethodArgumentNotValidException.class,
            ConstraintViolationException.class})
    public JsonResult<Void> handleException(Throwable e)
    {
        JsonResult<Void> result = new JsonResult<>(e);
        if (e instanceof FileEmptyException) {
            result.setState(6000);
            result.setMessage("Data Uploaded are Empty.");
        } else if (e instanceof FileUploadIOException) {
            result.setState(6004);
            result.setMessage("File Uploaded Error.");
        } else if (e instanceof JwtException) {
            result.setState(7000);
            result.setMessage("User Token Validation Failed.");
        } else if (e instanceof TokenExpiredException) {
            result.setState(7000);
            result.setMessage("Token Expired. Please Sign In Again.");
        } else if (e instanceof PasswordNotMatchException) {
            result.setState(5000);
            result.setMessage("Wrong Password");
        } else if (e instanceof UserNotFoundException) {
            result.setState(5000);
            result.setMessage("Email User Does Not Exist.");
        } else if (e instanceof UsernameDuplicateException) {
            result.setState(5000);
            result.setMessage("Email User Already Exists. Please Sign In.");
        } else if (e instanceof MethodArgumentNotValidException) {
            result.setState(5000);
            result.setMessage("Wrong Email Format.");
        } else if (e instanceof ConstraintViolationException) {
            result.setState(5000);
            result.setMessage("Wrong Email Format.");
        } else if (e instanceof InsertException) {
            result.setState(4000);
            result.setMessage("Database Insertion Error. Please Contact Admin.");
        } else if (e instanceof UpdateException) {
            result.setState(4000);
            result.setMessage("Database Insertion Error. Please Contact Admin.");
        }
        return result;
    }

}
