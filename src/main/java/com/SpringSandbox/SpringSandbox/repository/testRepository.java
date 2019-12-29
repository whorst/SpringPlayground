package com.SpringSandbox.SpringSandbox.repository;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface testRepository extends PagingAndSortingRepository<String,String> {
    //You can automagically define methods to return values from your DB layer, or you can define the SQL yourself.
    // More on this later
    public List<String> findAll();
    public Page<String> findByState(@Param("state") String state, Pageable firstPageWithTwoElements);
}
