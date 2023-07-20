package com.funnycode.ministore.AccountAPI.repository;

import com.funnycode.ministore.AccountAPI.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Integer> {

    Optional<Account> findByUsername(String username);
}
