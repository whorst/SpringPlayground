package com.SpringSandbox.SpringSandbox.FeignClient.clients;

//Created by Facebook, used for API Creation. A declarative HTTP Client. Simply put, the developer needs only to declare
// and annotate an interface while the actual implementation will be provisioned at runtime.
//https://www.baeldung.com/intro-to-feign

/*
* You need these dependencies
*     compile("org.springframework.cloud:spring-cloud-starter-parent:1.0.0.RELEASE")
    compile("org.springframework.cloud:spring-cloud-starter-feign:1.0.0.RELEASE")
    compile("io.github.openfeign:feign-bom:10.2.3")
    *
    * and the @EnableFeignClients annotation on your main class to work
* */


import com.SpringSandbox.SpringSandbox.FeignClient.models.Book;
import com.SpringSandbox.SpringSandbox.FeignClient.models.BookResource;
//import feign.Headers;
//import feign.RequestLine;
import org.springframework.data.repository.query.Param;
//import org.springframework.cloud.netflix.feign.*;

import java.util.List;

public interface BookClient {
//    @RequestLine("GET /book/{isbn}")
    BookResource findByIsbn(@Param("isbn") String isbn);

//    @RequestLine("GET")
    List<BookResource> findAll();

//    @RequestLine("POST")
//    @Headers("Content-Type: application/json")
    void create(Book book);
}