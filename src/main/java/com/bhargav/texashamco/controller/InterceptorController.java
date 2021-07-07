package com.bhargav.texashamco.controller;

import com.bhargav.texashamco.dto.interceptor.InterceptorDTO;
import com.bhargav.texashamco.models.Interceptor;
import com.bhargav.texashamco.service.interceptor.InterceptorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/interceptors")
public class InterceptorController {

    @Autowired
    InterceptorService interceptorService;

    @GetMapping("/name/{name}")
    public ResponseEntity<List<InterceptorDTO>> findInterceptorByName(@PathVariable("name") String name){

        try {
            List<InterceptorDTO> interceptorDTOs = interceptorService.getInterceptorByName(name);
            if(interceptorDTOs.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(interceptorDTOs,HttpStatus.OK);
        }catch(Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }


    }

    @GetMapping("/date/{date}")
    public ResponseEntity<List<InterceptorDTO>> getInterceptorByDate(@PathVariable("date") String date){
        try {
            List<InterceptorDTO> interceptorDTOs = interceptorService.getInterceptorByDate(date);
            if(interceptorDTOs.isEmpty()) {

                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(interceptorDTOs,HttpStatus.OK);
        }catch(Exception e) {

            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
