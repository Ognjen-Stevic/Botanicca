package it355.ognjenstevic5378.eshop.contoller;

import it355.ognjenstevic5378.eshop.model.SessionUser;
import it355.ognjenstevic5378.eshop.model.User;
import it355.ognjenstevic5378.eshop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/account")
public class AccountController {
    private final SessionUser sessionUser;
    private final UserService userService;

    public AccountController(SessionUser sessionUser, UserService userService) {
        this.sessionUser = sessionUser;
        this.userService = userService;
    }

    @GetMapping()
    public String account(Model model) {
        model.addAttribute("changedUser", sessionUser.getUser());
        return "account";
    }

    @PostMapping("/change")
    public String change(@ModelAttribute("changedUser") User changedUser) {
        sessionUser.setUser(changedUser);
        userService.changeUser(changedUser);

        return "redirect:/home";
    }
}
