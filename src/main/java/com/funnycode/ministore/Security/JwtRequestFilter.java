package com.funnycode.ministore.Security;

import com.funnycode.ministore.AccountAPI.entity.Account;
import com.funnycode.ministore.AccountAPI.repository.IAccountRepository;
import com.funnycode.ministore.AccountAPI.util.mapper.AccountMapper;
import com.funnycode.ministore.Model.TokenPayload;
import com.funnycode.ministore.Util.JwtTokenUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Optional;

@Component
@RequiredArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class JwtRequestFilter extends OncePerRequestFilter {
    JwtTokenUtil jwtTokenUtil;
    IAccountRepository iAccountRepository;


    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        String requestTokenHeader = request.getHeader("Authorization");

        String token = null;
        TokenPayload tokenPayload = null;
        if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
            token = requestTokenHeader.split(" ")[1];
            try {
                tokenPayload = jwtTokenUtil.getTokenPayload(token);
            } catch (ExpiredJwtException ex) {
                System.out.println("Token is expired");
            }
        } else {
            System.out.println("JWT not start with bearer");
        }

        // neu chua co payload/context thi tim`
        if (tokenPayload != null && SecurityContextHolder.getContext().getAuthentication() == null){
            Optional<Account> accountOptional = iAccountRepository.findById(tokenPayload.getAccountID());
            if (accountOptional.isPresent()){
                Account account = accountOptional.get();
                if (jwtTokenUtil.isValid(token, AccountMapper.toTokenPayload(account))){
                    // tao user detail -> luu vao context holder
                }
            }
        }
        filterChain.doFilter(request, response);
    }
}
