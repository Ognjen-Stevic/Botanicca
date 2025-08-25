package it355.ognjenstevic5378.eshop.service;

import it355.ognjenstevic5378.eshop.model.Order;
import it355.ognjenstevic5378.eshop.repository.InMemoryOrderRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

import static it355.ognjenstevic5378.eshop.util.Util.getNewID;

@Service
public class OrderService {
    private InMemoryOrderRepository orderRepository;

    public OrderService(InMemoryOrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void createNewOrder(Long articleId, Long userId) {
        this.orderRepository.createNewOrder(new Order(getNewID(orderRepository.getLastId()), userId, articleId));
    }

    public ArrayList<Order> getOrdersByUser(Long id) {
        return this.orderRepository.getOrdersByUser(id);
    }

    public void deleteOrederById(Long id) {
        this.orderRepository.deleteOrederById(id);
    }
}
