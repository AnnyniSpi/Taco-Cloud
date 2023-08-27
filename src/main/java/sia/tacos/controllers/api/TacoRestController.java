package sia.tacos.controllers.api;


import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;
import sia.tacos.model.Taco;
import sia.tacos.repositories.TacoRepository;

import java.util.Optional;

@RestController
@RequestMapping(path = "/api/tacos",
                produces = "application/json")
@CrossOrigin(origins = "http://tacocloud:8080")
public class TacoRestController {

    private final TacoRepository tacoRepo;

    public TacoRestController(TacoRepository tacoRepo) {
        this.tacoRepo = tacoRepo;
    }

    @GetMapping(params = "recent")
    public Iterable<Taco> recentTacos(){
        PageRequest page = PageRequest.of(
                0,12, Sort.by("createdAt").descending());
        return tacoRepo.findAll(page).getContent();
    }

    @GetMapping("/{id}")
    public Optional<Taco> tacoById(@PathVariable("id") Long id){
        return tacoRepo.findById(id);
    }

}
