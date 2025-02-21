package com.Inti.backend.controller;

import com.Inti.backend.model.Users;
import com.Inti.backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/users")
public class UsersController {

    @Autowired
    UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping
    public List<Users> getUsers() {
        return this.usersService.getUsers();
    }

    @PostMapping
    public ResponseEntity<String> saveUser(@RequestBody Users user) {
        usersService.saveUser(user);
        return ResponseEntity.ok("User Created");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable Long id){
        usersService.deleteUser(id);
        return ResponseEntity.ok("User Deleted");
    }

    @GetMapping("/{id}")
    public Users findUser(@PathVariable Long id){
        return usersService.findUser(id);
    }

    @PutMapping("/{id}")
    public  ResponseEntity<String> editUser(@PathVariable Long id, @RequestBody Users users){
        usersService.editUser(id, users);
        return ResponseEntity.ok("User Updated");
    }
}
