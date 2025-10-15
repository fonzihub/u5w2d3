package alfosarno.u5w2d3.services;

import alfosarno.u5w2d3.entities.Author;
import alfosarno.u5w2d3.exceptions.NotFoundException;
import alfosarno.u5w2d3.payloads.NewAuthorPayload;
import alfosarno.u5w2d3.repositories.AuthorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Slf4j
@Service
public class AuthorService {
    @Autowired
    public AuthorRepository authorRepository;


    //    GET
    public List<Author> findAll() {
        return this.authorRepository.findAll();
    }


    //    POST
    public Author save(NewAuthorPayload payload) {

        Author newAuthor = new Author(payload.getNome(), payload.getCognome(), payload.getEmail(), payload.getDataDiNascita());
        newAuthor.setAvatar("https://ui-avatars.com/api/?name=" + payload.getNome() + "+" + payload.getCognome());
        // SALVO
        Author savedAuthor = this.authorRepository.save(newAuthor);
        // LOG
        log.info("L'utente con id: " + savedAuthor.getIdAuthor() + " è stato salvato con successo");
        //  Ritorno autore salvato
        return savedAuthor;
    }

//    GET byId
    public Author findById(UUID authorId){
        return this.authorRepository.findById(authorId).orElseThrow(()-> new NotFoundException(authorId));
    }


}
