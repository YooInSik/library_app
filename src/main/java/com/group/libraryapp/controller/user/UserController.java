package com.group.libraryapp.controller.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.service.user.UserService;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserController {

    private final UserService userService;

    public UserController(JdbcTemplate jdbcTemplate) {
        this.userService = new UserService(jdbcTemplate);
    }

    @PostMapping("/user") // POST /user
    public void saveUser(@RequestBody UserCreateRequest request)
    {
        userService.saveUser(request);
    }

    @GetMapping("/user") // GET /user
    public List<UserResponse> getUsers(){
        return userService.getUsers();
    }

    @PutMapping("/user")
    public void updateUser(@RequestBody UserUpdateRequest request)
    {
        userService.UpdateUser(request);
    }

    @DeleteMapping("/user")
    public void deleteUser(@RequestParam String name)
    {
        userService.DeleteUser(name);
    }
}
