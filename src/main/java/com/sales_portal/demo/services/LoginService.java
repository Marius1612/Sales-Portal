package com.sales_portal.demo.services;

import com.sales_portal.demo.data.DAO.PendingUser;
import com.sales_portal.demo.data.DAO.Users;
import com.sales_portal.demo.data.repositories.PendingUserRepository;
import com.sales_portal.demo.data.repositories.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class LoginService implements UserDetailsService {
    private UserRepository userRepository;
    private PendingUserRepository pendingUserRepository;

    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
            Users u = userRepository.findByEmailAddress(s).orElseThrow(() -> new UsernameNotFoundException(s));
        return new CustomUserDetails(u);
    }
}


