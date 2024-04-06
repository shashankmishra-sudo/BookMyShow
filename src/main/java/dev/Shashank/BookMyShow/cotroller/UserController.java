package dev.Shashank.BookMyShow.cotroller;

import dev.Shashank.BookMyShow.dto.LoginRequestDTO;
import dev.Shashank.BookMyShow.dto.UserSignUpRequestDTO;
import dev.Shashank.BookMyShow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/signUp")
    public ResponseEntity signUp(@RequestBody UserSignUpRequestDTO requestDTO) throws Exception {
            //We can validate data
            return ResponseEntity.ok(
                    userService.signUp(requestDTO.getName(), requestDTO.getEmail(), requestDTO.getPassword())
            );
    }

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody LoginRequestDTO requestDto) throws Exception {
        //validate the userdata
        return ResponseEntity.ok(
                userService.login( requestDto.getEmail(), requestDto.getPassword())
        );
    }

}
