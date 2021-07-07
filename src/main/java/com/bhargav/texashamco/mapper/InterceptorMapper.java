package com.bhargav.texashamco.mapper;

import com.bhargav.texashamco.dto.interceptor.InterceptorDTO;
import com.bhargav.texashamco.models.Interceptor;
import org.springframework.data.domain.Page;

import java.util.List;

public interface InterceptorMapper {

    InterceptorDTO toInterceptorDTO(Interceptor interceptor);
    Interceptor toInterceptor(InterceptorDTO interceptorDTO);
    List<InterceptorDTO> toInterceptorDTOs(List<Interceptor> interceptors);
    List<Interceptor> toInterceptors(List<InterceptorDTO> interceptorDTOs);
}
