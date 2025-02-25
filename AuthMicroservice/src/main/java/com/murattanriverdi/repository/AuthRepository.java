package com.murattanriverdi.repository;

import com.murattanriverdi.entity.Auth;

public interface AuthRepository extends MyGenericRepository<Auth,Long> {
    Boolean existsByUsernameAndPassword(String username, String password);
}
