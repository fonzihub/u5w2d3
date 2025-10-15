package alfosarno.u5w2d3.controllers;

import alfosarno.u5w2d3.entities.Author;
import alfosarno.u5w2d3.payloads.NewAuthorPayload;
import alfosarno.u5w2d3.services.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/*

1. GET http://localhost:3001/users
2. POST http://localhost:3001/users (+ request body)
3. GET http://localhost:3001/users/{userId}
4. PUT http://localhost:3001/users/{userId} (+ request body)
5. DELETE  http://localhost:3001/users/{userId}

*/

@RestController
@RequestMapping("/authors")
public class AuthorController {
    @Autowired
    AuthorService authorService;

    //   GET http://localhost:3001/authors
    @GetMapping
    public List<Author> findAll() {
        return this.authorService.findAll();
    }

    //POST http://localhost:3001/authors (+ request body)
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Author createAuthor(@RequestBody NewAuthorPayload payload) {
        return this.authorService.save(payload);
    }


    //    GET http://localhost:3001/users/{userId}
    @GetMapping("/{authorId}")
    public Author findById(@PathVariable UUID authorId) {
        return this.authorService.findById(authorId);
    }


    //    PUT
//    @PutMapping("/{authorId}")
//    public Author findByIdAndDelete(@PathVariable UUID authorId, @RequestBody NewAuthorPayload payload) {
//
//
//    }

    //        DELETE
//    @DeleteMapping
//    @ResponseStatus(HttpStatus.NO_CONTENT)
//    public Author findByIdAndDelete(@PathVariable UUID authorId) {
//
//    }
}
