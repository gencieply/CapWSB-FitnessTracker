package com.capgemini.wsb.fitnesstracker.user.internal;
import org.springframework.format.annotation.DateTimeFormat;
import com.capgemini.wsb.fitnesstracker.user.api.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/users")
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

    @PostMapping
    public User addUser(@RequestBody UserDto userDto) throws InterruptedException {

        // Demonstracja how to use @RequestBody
        System.out.println("User with e-mail: " + userDto.email() + "passed to the request");

        // TODO: saveUser with Service and return User
        return null;
    }
    @GetMapping("/older/{date}")
    public List<UserDto>getUsersOlderThan(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate date) {
        List<User> users = userService.findUsersOlderThan(date);
        List<UserDto> userDtos = new ArrayList<>();
        for (User user : users) {
            userDtos.add(userMapper.toDto(user));
        }
        return userDtos;
    }
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

}