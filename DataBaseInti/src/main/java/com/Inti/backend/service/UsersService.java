package com.Inti.backend.service;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import com.Inti.backend.repository.IUsersRepository;
import org.springframework.stereotype.Service;
import com.Inti.backend.model.Users;

import java.util.ArrayList;
import java.util.List;

@Service
public class UsersService implements IUsersService {

    @Autowired
    private IUsersRepository usersRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public Users registerUser(Users user) {
        Users newUser = new Users();
        newUser.setName(user.getName());
        newUser.setEmail(user.getEmail());
        newUser.setPhone(user.getPhone());
        newUser.setPassword(passwordEncoder.encode(user.getPassword()));

        return usersRepository.save(newUser);
    }

    @Override
    public UserDetails findUserByEmail(String email) {
        Users user = usersRepository.findByEmail(email);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Users user = usersRepository.findByEmail(username);
        if(user == null) {
            throw new UsernameNotFoundException("User not found");
        }
        return new org.springframework.security.core.userdetails.User(user.getEmail(), user.getPassword(), new ArrayList<>());
    }

    @Override
    public List<Users> getUsers() {
        List<Users> usersList = usersRepository.findAll();
        return usersList;
    }

    @Override
    public void saveUser(Users user) {
        usersRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        usersRepository.deleteById(id);
    }

    @Override
    public Users findUser(Long id) {
        Users user = usersRepository.findById(id).orElse(null);
        return user;
    }

    public void editUser(Long id, Users user){
        Users foundedUser = usersRepository.findById(id).orElse(null);
        if (foundedUser != null){
            foundedUser.setName(user.getName());
            foundedUser.setEmail(user.getEmail());
            foundedUser.setPhone(user.getPhone());
            foundedUser.setPassword(user.getPassword());

            usersRepository.save(foundedUser);


        } else {
            System.out.println("User was not found: " + id);
        }
    }
}
