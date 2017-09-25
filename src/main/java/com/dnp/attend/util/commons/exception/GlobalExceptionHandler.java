package com.dnp.attend.util.commons.exception;

import com.dnp.attend.vo.ResponseResultVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 全局的的异常拦截器（拦截所有的控制器）（带有@RequestMapping注解的方法上都会拦截）
 *
 * @Author 华仔
 * @DATE 2017/9/25 10:43
 */
@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger log = LoggerFactory.getLogger(this.getClass());

    /**
     * 处理所有未知异常
     *
     * @param response HttpServletResponse
     * @param e        exception
     * @return 响应结果实体类
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseResultVo allException(HttpServletResponse response, Exception e) {
        log.error(e.getLocalizedMessage());
        response.setStatus(1024);
        return new ResponseResultVo(1024, "error", "未知异常，请联系管理员");
    }

    /**
     * 请求参数类型不匹配
     *
     * @param response HttpServletResponse
     * @param e        exception
     * @return 响应结果实体类
     */
    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    @ResponseBody
    public ResponseResultVo methodArgumentTypeMismatchException(HttpServletResponse response, Exception e) {
        log.error(e.getLocalizedMessage());
        response.setStatus(400);
        return new ResponseResultVo(400, "error", "请求参数类型不匹配");
    }

    /**
     * 缺少请求参数
     *
     * @param response HttpServletResponse
     * @param e        exception
     * @return 响应结果实体类
     */
    @ExceptionHandler(MissingServletRequestParameterException.class)
    @ResponseBody
    public ResponseResultVo missingServletRequestParameterException(HttpServletResponse response, Exception e) {
        log.error(e.getLocalizedMessage());
        response.setStatus(400);
        return new ResponseResultVo(400, "error", "请求参数缺少");
    }

    /**
     * 数据库键值重复
     *
     * @param response HttpServletResponse
     * @param e        exception
     * @return 响应结果实体类
     */
    @ExceptionHandler(DuplicateKeyException.class)
    @ResponseBody
    public ResponseResultVo duplicateKeyException(HttpServletResponse response, HttpServletRequest request, Exception e) {
        if (request.getServletPath().contains("user")) {
            if (e.getMessage().contains("Duplicate entry")) {
                return new ResponseResultVo(1025, "error", "用户email重复");
            }
        }
        return new ResponseResultVo(1025, "error", "键值重复");
    }
}
