package com.SpringSandbox.SpringSandbox.caching;

import net.bytebuddy.implementation.bind.annotation.IgnoreForBinding;

public interface BookRepository {

  Book getByIsbn(String isbn);

}