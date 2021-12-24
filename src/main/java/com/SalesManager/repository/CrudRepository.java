package com.SalesManager.repository;

import java.util.List;

public interface CrudRepository<T> {

      public int save(T Object);
      public int update(T Object);
      public int delete(long id);
      public T findById(long id);
      public List<T> findAll();
}
