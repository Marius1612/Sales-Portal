package com.sales_portal.demo.services;

import com.sales_portal.demo.data.DAO.PendingUser;
import com.sales_portal.demo.data.DAO.Users;
import com.sales_portal.demo.data.DTO.UserDTO;
import com.sales_portal.demo.data.repositories.PendingUserRepository;
import com.sales_portal.demo.data.repositories.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("IUserService")
@AllArgsConstructor
public class UserService implements IUserService{
    private UserRepository userRepository;
    private JavaMailSender javaMailSender;
    private PendingUserRepository pendingUserRepository;
    private RandomStringGenerator randomStringGenerator;

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


//    @Override
//    public String linkCreator(String link, Integer user_Id){
//        randomStringGenerator.getActivationCode() = randomStringGenerator.getAlphaNumericString(6);
//        link = "http://localhost:8080/login" + "?" + activationCode;
//
//        return link;
//    }

    @Override
    public void insertUser(String emailAddress, String password, String name) {
        //String activationCode;
        String activationCode = null;
        //activationCode.equals(this.activationCode);
        Users u = Users.builder().emailAddress(emailAddress)
                .password(password).name(name).build();
        u = userRepository.save(u);
        //activationCode = randomStringGenerator.getAlphaNumericString(20);
        String link = randomStringGenerator.linkCreator(activationCode);
        insertIntoPendingUser(link,u);
        sendMail(u.getUser_id(),"mail", link);
    }

    @Override
    public void insertIntoPendingUser(String activationCode, Users user) {
        PendingUser pu = PendingUser.builder().activationCode(activationCode).user(user).build();
        pendingUserRepository.save(pu);
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
