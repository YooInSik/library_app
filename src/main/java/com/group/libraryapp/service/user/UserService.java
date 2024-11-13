package com.group.libraryapp.service.user;

import com.group.libraryapp.dto.user.request.UserCreateRequest;
import com.group.libraryapp.dto.user.request.UserUpdateRequest;
import com.group.libraryapp.dto.user.response.UserResponse;
import com.group.libraryapp.repository.user.UserRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(JdbcTemplate jdbcTemplate) {
        userRepository = new UserRepository(jdbcTemplate);
    }

    public void saveUser(UserCreateRequest request)
    {
        userRepository.saveUser(request.getName(), request.getAge());
    }

    public List<UserResponse> getUsers()
    {
        return userRepository.getUsers();
    }

    public void UpdateUser(UserUpdateRequest request)
    {
        if(userRepository.isUserNotExist(request.getId()))
        {
            throw new IllegalArgumentException();
        }

        userRepository.UpdateUserName(request.getName(), request.getId());
    }

    public void DeleteUser(String name)
    {
        if(userRepository.isUserNotExist(name))
        {
            throw new IllegalArgumentException();
        }

        userRepository.deleteUser(name);
    }
}
