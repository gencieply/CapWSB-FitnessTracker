package com.capgemini.wsb.fitnesstracker.user.internal;

import com.capgemini.wsb.fitnesstracker.user.api.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
class UserController {

    private final UserServiceImpl userService;

    private final UserMapper userMapper;

    @GetMapping
    public List<UserDto> getAllUsers() {
        return userService.findAllUsers()
                          .stream()
                          .map(userMapper::toDto)
                          .toList();
    }


    @GetMapping("/user")
    public List<UserDto> getAllUser() {
        return userService.findAllUsers()
                .stream()
                .map(userMapper::toDto)
                .toList();
    }


    @PostMapping
    public User addUser(@RequestBody UserDto userDto) throws InterruptedException {

        // Demonstracja how to use @RequestBody
        System.out.println("User with e-mail: " + userDto.email() + "passed to the request");

        // TODO: saveUser with Service and return User
        return null;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{user_id}")
    public User removeUser(@PathVariable long user_id) throws InterruptedException {
        userService.deluser(user_id);
        // TODO: saveUser with Service and return User
        return null;
    }

}