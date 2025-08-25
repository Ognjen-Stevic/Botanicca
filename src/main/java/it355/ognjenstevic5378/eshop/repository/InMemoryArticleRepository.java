package it355.ognjenstevic5378.eshop.repository;

import it355.ognjenstevic5378.eshop.model.Article;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Repository;
import org.springframework.web.context.annotation.ApplicationScope;

import java.util.ArrayList;

@Repository
@ApplicationScope
public class InMemoryArticleRepository {
    private ArrayList<Article> articles = new ArrayList<>();

    public InMemoryArticleRepository() {
    }

    @PostConstruct
    private void initialize() {
        addNewArticle(new Article(1L, "Teflon Trim Ravne Makaze", "img/1.png", 5.56, "Makaze za orezivanje i uzimanje reznica obložene Teflonom. Idealne su za šišanje biljaka, uzimanje reznica, kao i za sve druge jednogodišnje i dvogodišnje zeljaste i drvenaste biljke."));
        addNewArticle(new Article(2L, "Blade Trim Makaze", "/img/2.png", 3.85, "Makaze za orezivanje i uzimanje reznica. Idealne su za jednogodišnje i dvogodišnje zeljaste i drvenaste biljke."));
        addNewArticle(new Article(3L, "Digitalni Tajmer za Navodnjavanje + Adapter 6mm", "/img/3.png", 15.33, "Tajmer za navodnjavanje sa priključkom za kapilarno crevo omogućava automatsko zalivanje bašta i plastenika. Radi na baterije, povezuje se na slavinu, zaliva od 1 minuta do 10 sati, štedi vodu i vreme."));
        addNewArticle(new Article(4L, "Saksija Četvrtasta 11L", "/img/4.png", 1.0, "Ove saksije izuzetno su pogodne za uzgoj u zatvorenom prostoru, plastenicima i staklenicima. Mogu se koristiti jednako kvalitetno za sobno cveće, povrće i začinsko bilje. Četvrtaste saksije izrađene su od kvalitetnog PP (polipropilen) materijala, izuzetno su otporne, a što je najvažnije, nisu štetne po životnu sredinu i okruženje."));
        addNewArticle(new Article(5L, "Coco Saksija 30cm", "/img/5.png", 3.97, "Saksije od kokosovih vlakana su 100% bio-razgradive i prirodne. Saksije se prave od vlakana kokosa, omogućuju vazdušno orošavanje korenovog sistema, i mogu se presaditi sa sve biljkom eliminišući stres. Saksija je prečnika 30cm i visine 20cm, a ukupne zapremine oko 10 litara."));
        addNewArticle(new Article(6L, "BioBizz Acti Vera 1L", "/img/6.png", 31.28, "Biobizz Acti Vera je proizvod koji predstavlja 100% prirodne, organske, ekstrakte Aloe Vere. Jača imuni sistem biljke, ubrzava metabolizam, ubrzava isklijavanje, daje dodatnu prihranu, poboljšava usvajanje nutrijenata i omogućava bolji razvoj cvetova, listova i plodova."));
        addNewArticle(new Article(7L, "BioBizz BioBloom 1L", "/img/7.png", 16.07, "BioBizz BioBloom je tečno 100% organsko đubrivo, koje se primenjuje u fazi cvetanja biljaka."));
        addNewArticle(new Article(8L, "BioBizz Alg A Mic 1L", "/img/8.png", 20.1, "BioBizz Alg-A-Mic je organski aditiv napravljen od morskih algi, sa visokim sadržajem mikroelemenata i hormona biljnog porekla, prirodnim amino kiselinama i vitaminima."));
        addNewArticle(new Article(9L, "Plagron Light Mix 25L", "/img/9.png", 8.28, "Plagron LightMix je supstrat vrhunskog kvaliteta spreman za korišćenje, idealan za presađivanje svih vrsta cvetnica. Mešavina belog i crnog treseta, sa vlaknima i perlitom. Sadrži prihrane za prvih nedelju dana NPK (12-14-24)."));
        addNewArticle(new Article(10L, "Plagron Grow Mix 25L", "/img/10.png", 10.23, "Plagron GrowMix je supstrat vrhunskog kvaliteta spreman za korišćenje, idealan za presađivanje svih vrsta cvetnica. Mešavina belog i crnog treseta, sa vlaknima i perlitom. Sadrži prihrane za prve tri nedelje NPK (12-14-24)."));
    }

    public ArrayList<Article> getAllArticles() {
        return this.articles;
    }

    public void addNewArticle(Article a) {
        this.articles.add(a);
    }

    public Article getArticleById(Long id) {
        return this.articles.stream().filter(article -> article.getId().equals(id)).findFirst().get();
    }
}
