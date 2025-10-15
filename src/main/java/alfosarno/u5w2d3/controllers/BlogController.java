package alfosarno.u5w2d3.controllers;

import alfosarno.u5w2d3.entities.Blog;
import alfosarno.u5w2d3.payloads.NewAuthorPayload;
import alfosarno.u5w2d3.payloads.NewBlogPayload;
import alfosarno.u5w2d3.services.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*

1. GET http://localhost:3001/users
2. POST http://localhost:3001/users (+ request body)
3. GET http://localhost:3001/users/{userId}
4. PUT http://localhost:3001/users/{userId} (+ request body)
5. DELETE  http://localhost:3001/users/{userId}

*/
@RestController
@RequestMapping("/blogs")
public class BlogController {
    @Autowired
    private BlogService blogService;


//    GET
    @GetMapping
    public List<Blog> findAll(){
        return this.blogService.findAll();
    }

//    POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Blog createBlog(@RequestBody NewBlogPayload payload){
        return this.blogService.save(payload);
    }


}
