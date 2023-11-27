package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.example.entity.User;
import com.example.repository.userRepo;

@Service
public class IUserDaoImpl implements IUserDao {

    @Autowired
    private userRepo userRepository;

    @Override
    public String validateUser(User user) {
        User userData = userRepository.findByEmail(user.getEmail());

        if (userData != null) {
            if (userData.getPassword().equals(user.getPassword())) {
                return "success";
            } else {
                return "invalid password";
            }
        }
        return "user not found";
    }

    public String saveUser(User user) {
        if (!isPasswordValid(user.getPassword())) {
            return "Invalid password format. Password must contain at least 8 characters including an uppercase letter and a special symbol.";
        }

        User savedUser = userRepository.save(user);
        if (savedUser != null) {
            return "User saved successfully!";
        } else {
            return "Failed to save user.";
        }
    }

    private boolean isPasswordValid(String password) {
        // Password must contain at least 8 characters including an uppercase letter and a special symbol
        String regex = "^(?=.*[A-Z])(?=.*[!@#$%^&*()-+]).{8,}$";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        return matcher.matches();
    }
}
