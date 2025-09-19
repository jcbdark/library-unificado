package com.example.userservice;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
public class UserController {

    @GetMapping("/users")
    public List<UserDTO> getUsers() {
        return List.of(
            new UserDTO(1L, "Carlos", "carlos@mail.com"),
            new UserDTO(2L, "Ana", "ana@mail.com"),
            new UserDTO(3L, "Lucía", "lucia@mail.com")
        );
    }
}
