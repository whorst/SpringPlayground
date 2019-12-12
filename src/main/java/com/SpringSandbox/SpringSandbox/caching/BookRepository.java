package com.SpringSandbox.SpringSandbox.caching;

public interface BookRepository {

  Book getByIsbn(String isbn);

}