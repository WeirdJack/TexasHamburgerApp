package com.bhargav.texashamco.interceptor;

import com.bhargav.texashamco.models.Interceptor;
import com.bhargav.texashamco.service.interceptor.InterceptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;

public class ExecutionTime implements HandlerInterceptor {

    @Autowired
    Interceptor interceptor;
    InterceptorService interceptorService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {


        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        interceptor.setStartTime(startTime);
        interceptor.setUrl(request.getRequestURL().toString());
        interceptor.setUrlDate(LocalDate.now());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        long endTime = System.currentTimeMillis();

        interceptor.setEndTime(endTime);
        long totalExecutionTime = interceptor.getStartTime() - endTime;

        interceptor.setExecutionTime(totalExecutionTime);

        interceptorService.insertExecutionTimeData(interceptor);
    }
}
