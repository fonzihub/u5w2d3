package alfosarno.u5w2d3.services;

import alfosarno.u5w2d3.entities.Author;
import alfosarno.u5w2d3.entities.Blog;
import alfosarno.u5w2d3.payloads.NewBlogPayload;
import alfosarno.u5w2d3.repositories.BlogRepository;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Slf4j
@Service
public class BlogService {
    @Autowired
    private BlogRepository blogRepository;
    @Autowired
    private AuthorService authorService;

//    GET
    public List<Blog> findAll(){
        return this.blogRepository.findAll();
    }

//    POST
     public Blog save(NewBlogPayload payload){
        Blog newBlog = new Blog(payload.getCategoria(), payload.getTitolo(), payload.getContenuto());
        newBlog.setCover("https://picsum.photos/200/300”");
//        Associo autore
         if(payload.getAuthorId() != null){
             Author author = authorService.findById(payload.getAuthorId());
             newBlog.setAuthor(author);
         }
         blogRepository.save(newBlog);
        Blog savedBlog = this.blogRepository.save(newBlog);
        log.info("il blog con id: " + savedBlog.getIdBlog() + " è stato salvato con successo");
        return savedBlog;
    }

}
