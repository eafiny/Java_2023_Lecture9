package ru.muctr.PrepodWebService.repositories;

import org.springframework.stereotype.Repository;
import ru.muctr.PrepodWebService.models.Prepod;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

/**
 * @author Evgenia Skichko
 */

@Repository
public class InMemoryPrepodRepository {
    List<Prepod> prepods;

    public Optional<Prepod> getPrepodById(int id){
        for(Prepod prepod:prepods){
            if(prepod.getId()==id){
                return Optional.of(prepod);
            }
        }
        return Optional.empty();
    }

    public void createPrepod(Prepod prepod){
        prepods.add(prepod);
    }

    @PostConstruct
    public void init(){
        prepods = new ArrayList<>(Arrays.asList(
                new Prepod(1, "John", 50000),
                new Prepod(2, "Peter", 70000)
        ));
    }
}
