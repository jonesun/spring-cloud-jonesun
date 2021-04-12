package org.jonesun.auth.api;

/**
 * 封装API的错误码
 * @author jone.sun
 * 2021/4/12 13:03
 */
public interface IErrorCode {
    long getCode();

    String getMessage();
}
