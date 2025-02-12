package com.dbapi.db_crud_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dbapi.db_crud_api.entity.User;

public interface UserRepository extends JpaRepository<User , Integer> {


}
