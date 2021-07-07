package com.bhargav.texashamco.repository.interceptor;

import com.bhargav.texashamco.models.Interceptor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface InterceptorRepository extends JpaRepository<Interceptor, Integer> {

    List<Interceptor> findByUrl(String url);
    List<Interceptor> findByUrlDate(String date);
}
