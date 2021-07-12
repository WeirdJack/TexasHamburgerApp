package com.bhargav.texashamco.service.interceptor;

import com.bhargav.texashamco.dto.interceptor.InterceptorDTO;
import com.bhargav.texashamco.mapper.InterceptorMapper;
import com.bhargav.texashamco.models.Interceptor;
import com.bhargav.texashamco.repository.interceptor.InterceptorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InterceptorService {

//    @Autowired
//    InterceptorRepository interceptorRepository;
//    InterceptorMapper interceptorMapper;
//
//    public InterceptorService() {
//    }
//
//    public void insertExecutionTimeData(Interceptor interceptor) {
//
//        interceptorRepository.save(interceptor);
//    }
//
//    public List<InterceptorDTO> getInterceptorByName(String name) {
//
//        List<InterceptorDTO> interceptor = interceptorMapper.toInterceptorDTOs(interceptorRepository.findByUrl(name));
//        return (interceptor.isEmpty()) ? null : interceptor;
//    }
//
//    public List<InterceptorDTO> getInterceptorByDate(String date) {
//
//        List<InterceptorDTO> interceptor = interceptorMapper.toInterceptorDTOs(interceptorRepository.findByUrlDate(date));
//        return interceptor.isEmpty() ? null : interceptor;
//    }
}
