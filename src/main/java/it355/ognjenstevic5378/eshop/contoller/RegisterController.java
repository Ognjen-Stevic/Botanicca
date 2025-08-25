package it355.ognjenstevic5378.eshop.contoller;

import it355.ognjenstevic5378.eshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegisterController {
    private final UserService userService;

    public RegisterController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/register")
    public String registerButton(@RequestParam String username, @RequestParam String password) {
        userService.registerNewUser(username,password);
        return "login";
    }
}
