import com.sene.entities.Article;
import com.sene.entities.User;
import com.sene.repository.ArticleRepository;
import com.sene.repository.jdbc.ArticleJdbcRepository;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestArticle {
    public static void main(String[] args){
        ArticleRepository articleRepository=new ArticleJdbcRepository();
        //Article article1 =articleRepository.addArticle(new Article("titre","contenu",12,"image",1),2);
        //List<Article> articles=articleRepository.getAll();

        //for(Article article : articles){
           // System.out.println(article.toString());
        //}
    }
}
