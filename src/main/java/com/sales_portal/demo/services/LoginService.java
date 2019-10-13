package com.sales_portal.demo.services;

import com.sales_portal.demo.data.DAO.PendingUser;
import com.sales_portal.demo.data.DAO.Users;
import com.sales_portal.demo.data.repositories.PendingUserRepository;
import com.sales_portal.demo.data.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class LoginService implements UserDetailsService {
    private UserRepository userRepository;
    private PendingUserRepository pendingUserRepository;

    @Autowired
    public LoginService(UserRepository userRepository, PendingUserRepository pendingUserRepository) {
        this.userRepository = userRepository;
        this.pendingUserRepository = pendingUserRepository;
    }


    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Users u = userRepository.findByEmailAddress(s).orElseThrow(() -> new UsernameNotFoundException(s));
        return new CustomUserDetails(u);
    }

    public void validateUser(String a) {
        Optional<PendingUser> opt = pendingUserRepository.findByActivationCode(a);
        if (opt.isPresent()) {
            PendingUser pendingUser = opt.get();
            if (pendingUser.getActivationCode().equals(a)) {
                System.out.println(pendingUser.getId());
                deletePendingUser(pendingUser.getId());
            }
        }
    }


    public void deletePendingUser(Integer id) {

        pendingUserRepository.deleteById(id);
    }

}


