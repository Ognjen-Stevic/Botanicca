package it355.ognjenstevic5378.eshop.model;

import it355.ognjenstevic5378.eshop.model.Article;

import java.time.LocalDateTime;

public class ArticleOrderDTO {
    private Long orderID;
    private Article article;
    private LocalDateTime purchaseDate;

    public ArticleOrderDTO() {
    }

    @Override
    public String toString() {
        return "ArticleOrderDTO{" +
                "orderID=" + orderID +
                ", article=" + article +
                ", purchaseDate=" + purchaseDate +
                '}';
    }

    public Long getOrderID() {
        return orderID;
    }

    public void setOrderID(Long orderID) {
        this.orderID = orderID;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }

    public LocalDateTime getPurchaseDate() {
        return purchaseDate;
    }

    public void setPurchaseDate(LocalDateTime purchaseDate) {
        this.purchaseDate = purchaseDate;
    }

    public ArticleOrderDTO(Long orderID, Article article, LocalDateTime purchaseDate) {
        this.orderID = orderID;
        this.article = article;
        this.purchaseDate = purchaseDate;
    }
}
