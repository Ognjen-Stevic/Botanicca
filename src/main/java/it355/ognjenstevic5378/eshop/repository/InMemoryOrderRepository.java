package it355.ognjenstevic5378.eshop.repository;

import it355.ognjenstevic5378.eshop.model.Order;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Repository
@ApplicationScope
public class InMemoryOrderRepository {
    private final ArrayList<Order> orders = new ArrayList<>();

    public InMemoryOrderRepository() {
    }

    @PostConstruct
    private void initialize() {
        this.orders.add(new Order(1L, 1L, 1L));
        this.orders.add(new Order(2L, 1L, 2L));
        this.orders.add(new Order(3L, 1L, 6L));
        this.orders.add(new Order(4L, 1L, 6L));
        this.orders.add(new Order(5L, 1L, 7L));
        this.orders.add(new Order(6L, 1L, 9L));
        this.orders.add(new Order(7L, 2L, 4L));
        this.orders.add(new Order(8L, 2L, 4L));
        this.orders.add(new Order(9L, 2L, 4L));
        this.orders.add(new Order(10L, 2L, 2L));
        this.orders.add(new Order(11L, 2L, 3L));
        this.orders.add(new Order(12L, 2L, 10L));
    }

    public ArrayList<Order> getOrdersByUser(Long id) {
        return this.orders.stream().filter(order -> order.getUserId().equals(id)).collect(Collectors.toCollection(ArrayList::new));
    }

    public void createNewOrder(Order o) {
        this.orders.add(o);
    }

    public Long getLastId() {
        return this.orders.get(orders.size() - 1).getId();
    }

    public void deleteOrederById(Long id) {
        this.orders.removeIf(order -> order.getId().equals(id));
    }
}
