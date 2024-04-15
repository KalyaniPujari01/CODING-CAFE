package com.coding.cafe.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import com.coding.cafe.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

 public boolean existsByEmail(String email);
 public User getByEmail(String email);
 


}

