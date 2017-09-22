package com.dnp.attend.util.commons.base;

import com.dnp.attend.util.commons.result.Result;
import com.dnp.attend.util.IOUtils;
import com.dnp.attend.util.StringEscapeEditor;
import com.dnp.attend.util.URLUtils;
import com.google.common.base.Charsets;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @description：基础 controller
 * @author：zhixuan.wang
 * @date：2015/10/1 14:51
 */
public abstract class BaseController {
    @InitBinder
    public void initBinder(ServletRequestDataBinder binder) {
        /**
         * 自动转换日期类型的字段格式
         */
        binder.registerCustomEditor(Date.class, new CustomDateEditor(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"), true));
        /**
         * 防止XSS攻击
         */
        binder.registerCustomEditor(String.class, new StringEscapeEditor());
    }


    /**
     * bean validation异常
     * <p>
     * 此处只是粗略的构造了错误信息，只处理了第一条错误。
     * <p>
     * 如果要做的完美，需要将所有的错误信息展示于页面。
     *
     * @param result
     * @return
     */
    public Object renderError(BindingResult result) {
        FieldError error = result.getFieldError();
        StringBuilder errorMsg = new StringBuilder(100);
        errorMsg.append("$(form).find(\"[name=\\\"");
        errorMsg.append(error.getField());
        errorMsg.append("\\\"]\").closest(\"td\").prev().text() + \"，");
        errorMsg.append(error.getDefaultMessage());
        errorMsg.append("\"");
        return renderError(errorMsg.toString());
    }

    /**
     * ajax失败
     *
     * @param msg 失败的消息
     * @return {Object}
     */
    public Object renderError(String msg) {
        Result result = new Result();
        result.setMsg(msg);
        return result;
    }

    /**
     * ajax成功
     *
     * @return {Object}
     */
    public Object renderSuccess() {
        Result result = new Result();
        result.setSuccess(true);
        return result;
    }

    /**
     * ajax成功
     *
     * @param msg 消息
     * @return {Object}
     */
    public Object renderSuccess(String msg) {
        Result result = new Result();
        result.setSuccess(true);
        result.setMsg(msg);
        return result;
    }

    /**
     * ajax成功
     *
     * @param obj 成功时的对象
     * @return {Object}
     */
    public Object renderSuccess(Object obj) {
        Result result = new Result();
        result.setSuccess(true);
        result.setObj(obj);
        return result;
    }


    /**
     * redirect跳转
     *
     * @param url 目标url
     */
    protected String redirect(String url) {
        return new StringBuilder("redirect:").append(url).toString();
    }

    /**
     * 下载文件
     *
     * @param file 文件
     */
    protected ResponseEntity<byte[]> download(File file) throws IOException {
        String fileName = file.getName();
        return download(file, fileName);
    }

    /**
     * 下载文件
     *
     * @param file     文件
     * @param fileName 写出的文件名
     */
    protected ResponseEntity<byte[]> download(File file, String fileName) throws IOException {
        InputStream in = null;
        try {
            in = new FileInputStream(file);
            byte[] body = IOUtils.copyToByteArray(in);
            return download(body, fileName);
        } finally {
            IOUtils.closeQuietly(in);
        }
    }

    /**
     * 下载
     *
     * @param body     数据
     * @param fileName 生成的文件名
     * @return {ResponseEntity}
     */
    protected ResponseEntity<byte[]> download(byte[] body, String fileName) {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder
                .getRequestAttributes()).getRequest();
        String header = request.getHeader("User-Agent").toUpperCase();
        HttpStatus status;
        if (header.contains("MSIE") || header.contains("TRIDENT") || header.contains("EDGE")) {
            fileName = URLUtils.encodeURL(fileName, Charsets.UTF_8.name());
            status = HttpStatus.OK;
        } else {
            fileName = new String(fileName.getBytes(Charsets.UTF_8), Charsets.ISO_8859_1);
            status = HttpStatus.CREATED;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment", fileName);
        headers.setContentLength(body.length);
        return new ResponseEntity<byte[]>(body, headers, status);
    }
}
