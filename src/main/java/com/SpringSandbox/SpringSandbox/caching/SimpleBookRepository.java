package com.SpringSandbox.SpringSandbox.caching;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

//Native Implementation Simulating Latency

@Component
public class SimpleBookRepository implements BookRepository {


  //This "@Cacheable(books) annotation is what enables caching"
  @Override
  @Cacheable("books")
  public Book getByIsbn(String isbn) {
    simulateSlowService();
    return new Book(isbn, "Some book");
  }

  // Don't do this at home
  private void simulateSlowService() {
    try {
      long time = 3000L;
      Thread.sleep(time);
    } catch (InterruptedException e) {
      throw new IllegalStateException(e);
    }
  }

}