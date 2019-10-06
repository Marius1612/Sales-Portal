package com.sales_portal.demo.services;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.sales_portal.demo.data.DAO.Company;
import com.sales_portal.demo.data.DAO.Users;
import com.sales_portal.demo.data.DTO.UserDTO;
import com.sales_portal.demo.data.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("IUserService")
@AllArgsConstructor
public class UserService implements IUserService{
    private UserRepository userRepository;
    private JavaMailSender javaMailSender;

    @Override
    public List<UserDTO> getAllUsers() {
        List<UserDTO> users = new ArrayList<UserDTO>();
        Iterable<Users> all = userRepository.findAll();

        all.forEach(u -> users.add(new UserDTO(u)));
        return users;
    }

    @Override
    public String getEmailAddress(String emailAddress) {
        Optional<Users> users = userRepository.findByEmailAddress(emailAddress);

        return users.get().getEmailAddress();
    }
    @Override
    public void insertUser(String emailAddress, String password, String name) {
        Users u = Users.builder().emailAddress(emailAddress)
                .password(password).name(name).build();
        userRepository.save(u);
        sendMail(u.getUser_id(),"mail","mail");
    }

    @Override
    public void sendMail(Integer userId, String subject, String content) {
        Optional<Users> users = userRepository.findById(userId);
        users.ifPresent(u -> {
            SimpleMailMessage mail = new SimpleMailMessage();
            mail.setTo(u.getEmailAddress());
            mail.setFrom("testEmailSDA@gmail.com");
            mail.setSubject(subject);
            mail.setText(content);

            javaMailSender.send(mail);
        } );
    }

}
