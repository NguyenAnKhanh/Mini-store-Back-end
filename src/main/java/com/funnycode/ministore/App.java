package com.funnycode.ministore;

import com.funnycode.ministore.AccountAPI.entity.Account;
import com.funnycode.ministore.RoleAPI.entity.Role;
import com.funnycode.ministore.AccountAPI.repository.IAccountRepository;
import com.funnycode.ministore.RoleAPI.repository.IRoleRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class App {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(App.class, args);





    }

}
