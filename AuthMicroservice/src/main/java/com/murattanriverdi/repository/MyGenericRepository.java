package com.murattanriverdi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MyGenericRepository<T, ID>  extends JpaRepository<T, ID> {
}
