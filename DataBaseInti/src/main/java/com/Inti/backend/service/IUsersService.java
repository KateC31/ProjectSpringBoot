package com.Inti.backend.service;

import com.Inti.backend.model.Users;

import java.util.List;

public interface IUsersService {
    public List<Users> getUsers();

    public void saveUser(Users user);

    public void deleteUser(Long id);

    public Users findUser(Long id);

}
