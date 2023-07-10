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

        IAccountRepository iAccountRepository = context.getBean(IAccountRepository.class);
        IRoleRepository iRoleRepository = context.getBean(IRoleRepository.class);

        Role role = Role.builder()
                .idRole("4")
                .nameRole("ngu")
                .build();
        role = iRoleRepository.save(role);

        Account account = Account.builder()
                .username("tao")
                .password("tao")
                .role(role)
                .build();
        iAccountRepository.save(account);
    }

}
