package it355.ognjenstevic5378.eshop.contoller;

import it355.ognjenstevic5378.eshop.model.SessionUser;
import it355.ognjenstevic5378.eshop.model.User;
import it355.ognjenstevic5378.eshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Controller
public class LoginController {

    private final UserService userService;
    private final SessionUser sessionUser;

    public LoginController(UserService userService, SessionUser sessionUser) {
        this.userService = userService;
        this.sessionUser = sessionUser;
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        model.addAttribute("error", false);
        return "login";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, Model model) {
        Optional<User> optionalUser = userService.login(username, password);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            sessionUser.setUser(user);
            return "redirect:/home";
        }
        model.addAttribute("error", true);
        return "login";
    }

    @PostMapping("/logout")
    public String logout() {
        sessionUser.setUser(new User());
        return "redirect:/login";
    }
}
