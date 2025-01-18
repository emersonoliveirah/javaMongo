package com.javaMongo.api;

import com.javaMongo.api.request.UserRequestDTO;
import com.javaMongo.api.response.UserResponseDTO;
import com.javaMongo.business.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @PostMapping()
    public ResponseEntity<UserResponseDTO> recordUser(@RequestBody UserRequestDTO userRequestDTO) {
        return ResponseEntity.ok(userService.recordUser(userRequestDTO));
    }

    @GetMapping()
    public ResponseEntity<UserResponseDTO> getUser(@RequestParam ("email") String email) {
        return ResponseEntity.ok(userService.getUser(email));
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteUser(@RequestParam ("email") String email) {
        userService.deleteUser(email);
        return ResponseEntity.accepted().build();
    }
}
