package com.Inti.backend.service;

import com.Inti.backend.model.Users;
import com.Inti.backend.repository.IUsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsersService implements IUsersService{

    @Autowired
    private IUsersRepository usersRepository;

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
