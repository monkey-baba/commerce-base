package com.mbb.commerce.common.dto;

import lombok.Data;

/**
 * @Title ResultDto
 * @Description
 * @Author ZQian
 * @date: 2018/11/2 16:10
 */
@Data
public class ResultDto<T> {

    private T data;

    private Boolean success;

    private String message;

    public static <T> ResultDto<T> success(T data, String message) {
        ResultDto<T> dto= new ResultDto<>();
        dto.setSuccess(Boolean.TRUE);
        dto.setMessage(message);
        dto.setData(data);
        return dto;
    }

    public static <T> ResultDto<T> success(T data) {
        ResultDto<T> dto= new ResultDto<>();
        dto.setSuccess(Boolean.TRUE);
        dto.setMessage("SUCCESS");
        dto.setData(data);
        return dto;
    }

    public static <T> ResultDto<T> fail(String message) {
        ResultDto<T> dto= new ResultDto<>();
        dto.setSuccess(Boolean.FALSE);
        dto.setMessage(message);
        return dto;
    }

    public static <T> ResultDto<T> fail() {
        ResultDto<T> dto= new ResultDto<>();
        dto.setSuccess(Boolean.FALSE);
        dto.setMessage("FAILED");
        return dto;
    }
}
