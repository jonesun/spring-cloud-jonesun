//package org.jonesun.common.result;
//
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.MethodParameter;
//import org.springframework.core.annotation.AnnotatedElementUtils;
//import org.springframework.http.HttpHeaders;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.MediaType;
//import org.springframework.http.ResponseEntity;
//import org.springframework.http.converter.HttpMessageConverter;
//import org.springframework.http.server.ServerHttpRequest;
//import org.springframework.http.server.ServerHttpResponse;
//import org.springframework.util.CollectionUtils;
//import org.springframework.validation.ObjectError;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//import org.springframework.web.context.request.WebRequest;
//import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;
//import org.springframework.web.util.WebUtils;
//
//import java.lang.annotation.Annotation;
//import java.util.List;
//
///**
// * 全局异常处理
// *
// * @author jone.sun
// * @date 2020-08-21 11:19
// */
//@RestControllerAdvice
//public class ResponseResultBodyAdvice implements ResponseBodyAdvice<Object> {
//
//    private static final Logger logger = LoggerFactory.getLogger(ResponseResultBodyAdvice.class);
//
//    private static final Class<? extends Annotation> ANNOTATION_TYPE = ResponseResultBody.class;
//
//    /**
//     * 判断类或者方法是否使用了 @ResponseResultBody
//     */
//    @Override
//    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
//        return AnnotatedElementUtils.hasAnnotation(methodParameter.getContainingClass(), ANNOTATION_TYPE) || methodParameter.hasMethodAnnotation(ANNOTATION_TYPE);
//    }
//
//    /**
//     * 当类或者方法使用了 @ResponseResultBody 就会调用这个方法
//     */
//    @Override
//    public Object beforeBodyWrite(Object body, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
//        // 防止重复包裹的问题出现
//        if (body instanceof Result) {
//            return body;
//        }
//        return Result.success(body);
//    }
//
//
//    /**
//     * 提供对标准Spring MVC异常的处理
//     *
//     * @param ex      the target exception
//     * @param request the current request
//     */
//    @ExceptionHandler(Exception.class)
//    public final ResponseEntity<Result<?>> exceptionHandler(Exception ex, WebRequest request) {
//        logger.error("ExceptionHandler: {}", ex.getMessage());
//        HttpHeaders headers = new HttpHeaders();
//        if (ex instanceof ResultException) {
//            return this.handleResultException((ResultException) ex, headers, request);
//        } else if(ex instanceof MethodArgumentNotValidException) {
//            return this.handleMethodArgumentNotValidException((MethodArgumentNotValidException) ex, headers, request);
//        }
//        // TODO: 2019/10/05 galaxy 这里可以自定义其他的异常拦截
//        return this.handleException(ex, headers, request);
//    }
//
//    /** 对ResultException类返回返回结果的处理 */
//    protected ResponseEntity<Result<?>> handleResultException(ResultException ex, HttpHeaders headers, WebRequest request) {
//        Result<?> body = Result.failure(ex.getResultStatus(), ex.getMessage());
//        HttpStatus status = ex.getResultStatus().getHttpStatus();
//        return this.handleExceptionInternal(ex, body, headers, status, request);
//    }
//
//    protected ResponseEntity<Result<?>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex, HttpHeaders headers, WebRequest request) {
//        //参数传递错误的处理
//        ResultStatus badRequestStatus = ResultStatus.BAD_REQUEST;
//        Result<?> body = Result.failure(badRequestStatus);
//
//        List<ObjectError> objectErrors = ex.getBindingResult().getAllErrors();
//        if(!CollectionUtils.isEmpty(objectErrors)) {
//            StringBuilder msgBuilder = new StringBuilder();
//            for (ObjectError objectError : objectErrors) {
//                msgBuilder.append(objectError.getDefaultMessage()).append(",");
//            }
//            String errorMessage = msgBuilder.toString();
//            if (errorMessage.length() > 1) {
//                errorMessage = errorMessage.substring(0, errorMessage.length() - 1);
//            }
//            body.setMessage(errorMessage);
//        } else {
//            body.setMessage(ex.getMessage());
//        }
//        return this.handleExceptionInternal(ex, body, headers, badRequestStatus.getHttpStatus(), request);
//    }
//
//    /** 异常类的统一处理 */
//    protected ResponseEntity<Result<?>> handleException(Exception ex, HttpHeaders headers, WebRequest request) {
//        Result<?> body = Result.failure();
//        HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;
//        return this.handleExceptionInternal(ex, body, headers, status, request);
//    }
//
//    /**
//     * org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler#handleExceptionInternal(java.lang.Exception, java.lang.Object, org.springframework.http.HttpHeaders, org.springframework.http.HttpStatus, org.springframework.web.context.request.WebRequest)
//     * <p>
//     * A single place to customize the response body of all exception types.
//     * <p>The default implementation sets the {@link WebUtils#ERROR_EXCEPTION_ATTRIBUTE}
//     * request attribute and creates a {@link ResponseEntity} from the given
//     * body, headers, and status.
//     */
//    protected ResponseEntity<Result<?>> handleExceptionInternal(
//            Exception ex, Result<?> body, HttpHeaders headers, HttpStatus status, WebRequest request) {
//
//        if (HttpStatus.INTERNAL_SERVER_ERROR.equals(status)) {
//            request.setAttribute(WebUtils.ERROR_EXCEPTION_ATTRIBUTE, ex, WebRequest.SCOPE_REQUEST);
//        }
//        return new ResponseEntity<>(body, headers, status);
//    }
//
//}
