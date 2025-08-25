package it355.ognjenstevic5378.eshop.contoller;

import it355.ognjenstevic5378.eshop.model.SessionUser;
import it355.ognjenstevic5378.eshop.service.ArticleService;
import it355.ognjenstevic5378.eshop.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/home")
public class HomeController {
    private final ArticleService articleService;
    private final OrderService orderService;
    private final SessionUser sessionUser;

    public HomeController(ArticleService articleService, OrderService orderService, SessionUser sessionUser) {
        this.articleService = articleService;
        this.orderService = orderService;
        this.sessionUser = sessionUser;
    }

    @GetMapping()
    public String home(Model model) {
        model.addAttribute("articles", articleService.getAllArticles());
        model.addAttribute("sessionUserID", sessionUser.getUser().getId());
        return "home";
    }

    @PostMapping("buy")
    public String buy(@RequestParam Long articleID, Model model) {
        orderService.createNewOrder(articleID, sessionUser.getUser().getId());

        return "redirect:/home";
    }
}
