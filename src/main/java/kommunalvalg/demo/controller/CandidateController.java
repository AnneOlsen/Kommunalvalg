package kommunalvalg.demo.controller;


import kommunalvalg.demo.models.Candidates;
import kommunalvalg.demo.repositories.CandidateRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class CandidateController {

    @Autowired
    CandidateRepository candidates;


    @GetMapping("/candidates")
    public Iterable<Candidates> getCandidates(){
        return candidates.findAll();
    }

    @GetMapping("/candidates/{id}")
    public Candidates findCandidateById(@PathVariable Long id){
        return candidates.findById(id).get();
    }

    @PostMapping("/candidates")
    public Candidates addCandidate(@RequestBody Candidates newCandidates){
        //newCandidate.setId(null);
        return candidates.save(newCandidates);
    }

    @PutMapping("/candidates/{id}")
    public String updateCandiatetBtId(@PathVariable Long id, @RequestBody Candidates candidatesToUpdate){
        if(candidates.existsById(id)){
            candidatesToUpdate.setId(id);
            candidates.save(candidatesToUpdate);
            return "Candidate was created";
        } else {
            return "Candidate was not found";
        }
    }

    @PatchMapping("/candidates/{id}")
    public String patchCandidateById(@PathVariable Long id, @RequestBody Candidates candidatesToUpdate){
            return candidates.findById(id).map(foundCandidates -> {
               if(candidatesToUpdate.getName() != null) foundCandidates.setName(candidatesToUpdate.getName());
               if(candidatesToUpdate.getPoliticalParty() != null) foundCandidates.setPoliticalParty(candidatesToUpdate.getPoliticalParty());

               candidates.save(foundCandidates);
               return "Candidate was updated";

                }) .orElse("Candidate was not found");
    }


    @DeleteMapping("/candidates/{id}")
    public void deleteCandidateById(@PathVariable Long id){
        candidates.deleteById(id);
    }


}
