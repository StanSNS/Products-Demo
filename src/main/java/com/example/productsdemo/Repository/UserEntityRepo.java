package com.example.productsdemo.Repository;

import com.example.productsdemo.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityRepo extends JpaRepository<UserEntity,Long> {

    UserEntity findFirstByOrderByIdAsc(); // Assuming 'id' is the primary key field

}
