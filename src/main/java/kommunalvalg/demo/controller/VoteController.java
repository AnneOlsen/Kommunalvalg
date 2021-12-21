package kommunalvalg.demo.controller;

import kommunalvalg.demo.models.Votes;
import kommunalvalg.demo.repositories.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VoteController {

    @Autowired
    VoteRepository votes;

    @GetMapping("/votes")
    public Iterable<Votes> getVotes(){
        return votes.findAll();
    }
}
