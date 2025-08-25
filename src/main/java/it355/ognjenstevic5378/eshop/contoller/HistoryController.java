package it355.ognjenstevic5378.eshop.contoller;

import it355.ognjenstevic5378.eshop.model.ArticleOrderDTO;
import it355.ognjenstevic5378.eshop.model.Order;
import it355.ognjenstevic5378.eshop.model.SessionUser;
import it355.ognjenstevic5378.eshop.service.ArticleService;
import it355.ognjenstevic5378.eshop.service.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
@RequestMapping("/history")
public class HistoryController {

    private final OrderService orderService;
    private final SessionUser sessionUser;
    private final ArticleService articleService;

    public HistoryController(OrderService orderService, SessionUser sessionUser, ArticleService articleService) {
        this.orderService = orderService;
        this.sessionUser = sessionUser;
        this.articleService = articleService;
    }

    @GetMapping()
    public String history(Model model) {
        Long sessionUserID = sessionUser.getUser().getId();
        ArrayList<Order> orders = orderService.getOrdersByUser(sessionUserID);
        ArrayList<ArticleOrderDTO> articles = new ArrayList<>();

        for (Order o : orders)
            articles.add(new ArticleOrderDTO(o.getId(), articleService.getArticleByID(o.getArticleId()), o.getOrderDate()));

        model.addAttribute("articles", articles);
        model.addAttribute("sessionUserID", sessionUserID);
        return "history";
    }

    @PostMapping("/delete")
    public String delete(@RequestParam Long orderID) {
        orderService.deleteOrederById(orderID);

        return "redirect:/history";
    }
}
