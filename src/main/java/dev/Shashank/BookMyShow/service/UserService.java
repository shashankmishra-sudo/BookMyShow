package dev.Shashank.BookMyShow.service;

import dev.Shashank.BookMyShow.model.User;
import dev.Shashank.BookMyShow.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User login(String email,String password) throws Exception {
        User savedUser=userRepository.findUserByEmail(email);
        if(savedUser==null){
            throw new Exception("User With Email does not exist");
        }
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        if(encoder.matches(password,savedUser.getPassword())){
            return savedUser;
        }
        throw new Exception("Invalid Password");
    }
    @Transactional(isolation = Isolation.SERIALIZABLE)
    public User signUp(String name,String email,String password) throws Exception {
        User savedUser=userRepository.findUserByEmail(email);
        if(savedUser!=null){
            throw new Exception("User with same email exist");
        }
        User user=new User();
        user.setName(name);
        user.setEmail(email);
        BCryptPasswordEncoder encoder=new BCryptPasswordEncoder();
        user.setPassword(encoder.encode(password));
        user.setTickets(new ArrayList<>());
        return userRepository.save(user);
    }
}
