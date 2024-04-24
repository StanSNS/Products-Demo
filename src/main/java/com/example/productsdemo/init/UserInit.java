package com.example.productsdemo.init;

import com.example.productsdemo.Entity.UserEntity;
import com.example.productsdemo.Repository.UserEntityRepo;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserInit {

    private final UserEntityRepo userEntityRepo;

    @PostConstruct
    public void userInit(){
        if(userEntityRepo.count() == 0){
            UserEntity userEntity = new UserEntity();
            userEntity.setEmail("demo@abv.bg");
            userEntity.setPassword("1234");
            userEntityRepo.save(userEntity);
        }

    }

}
