package it355.ognjenstevic5378.eshop.service;

import it355.ognjenstevic5378.eshop.model.Article;
import it355.ognjenstevic5378.eshop.repository.InMemoryArticleRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class ArticleService {
    private final InMemoryArticleRepository inMemoryArticleRepository;

    public ArticleService(InMemoryArticleRepository inMemoryArticleRepository) {
        this.inMemoryArticleRepository = inMemoryArticleRepository;
    }

    public ArrayList<Article> getAllArticles() {
        return this.inMemoryArticleRepository.getAllArticles();
    }

    public Article getArticleByID(Long id) {
        return this.inMemoryArticleRepository.getArticleById(id);
    }
}
