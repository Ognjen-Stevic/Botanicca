package it355.ognjenstevic5378.eshop.model;

import java.time.LocalDateTime;

public class Order {
    private Long id;
    private Long userId;
    private Long articleId;
    private LocalDateTime orderDate;

    public Order() {
    }

    public Order(Long id, Long userId, Long articleId) {
        this.id = id;
        this.userId = userId;
        this.articleId = articleId;
        this.orderDate = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Long getArticleId() {
        return articleId;
    }

    public void setArticleId(Long articleId) {
        this.articleId = articleId;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDateTime orderDate) {
        this.orderDate = orderDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", articleId=" + articleId +
                ", orderDate=" + orderDate +
                '}';
    }
}
