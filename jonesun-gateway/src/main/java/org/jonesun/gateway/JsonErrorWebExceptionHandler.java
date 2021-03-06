//package org.jonesun.gateway;
//
//import org.springframework.boot.autoconfigure.web.ResourceProperties;
//import org.springframework.boot.autoconfigure.web.reactive.error.DefaultErrorWebExceptionHandler;
//import org.springframework.boot.web.servlet.error.ErrorAttributes;
//
///**
// * @author jone.sun
// * 2021/4/1 18:40
// */
//public class JsonErrorWebExceptionHandler extends DefaultErrorWebExceptionHandler {
//
//    public JsonErrorWebExceptionHandler(ErrorAttributes errorAttributes,
//                                        ResourceProperties resourceProperties,
//                                        ErrorProperties errorProperties,
//                                        ApplicationContext applicationContext) {
//        super(errorAttributes, resourceProperties, errorProperties, applicationContext);
//    }
//
//    @Override
//    protected Map<String, Object> getErrorAttributes(ServerRequest request, boolean includeStackTrace) {
//        // 这里其实可以根据异常类型进行定制化逻辑
//        Throwable error = super.getError(request);
//        Map<String, Object> errorAttributes = new HashMap<>(8);
//        errorAttributes.put("message", error.getMessage());
//        errorAttributes.put("code", HttpStatus.INTERNAL_SERVER_ERROR.value());
//        errorAttributes.put("method", request.methodName());
//        errorAttributes.put("path", request.path());
//        return errorAttributes;
//    }
//
//    @Override
//    protected RouterFunction<ServerResponse> getRoutingFunction(ErrorAttributes errorAttributes) {
//        return RouterFunctions.route(RequestPredicates.all(), this::renderErrorResponse);
//    }
//
//    @Override
//    protected HttpStatus getHttpStatus(Map<String, Object> errorAttributes) {
//        // 这里其实可以根据errorAttributes里面的属性定制HTTP响应码
//        return HttpStatus.INTERNAL_SERVER_ERROR;
//    }
//}