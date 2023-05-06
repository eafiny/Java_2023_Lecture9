package ru.muctr.PrepodWebService.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.muctr.PrepodWebService.models.Prepod;
import ru.muctr.PrepodWebService.services.PrepodService;

/**
 * @author Evgenia Skichko
 */

@RestController
public class PrepodController {
    PrepodService prepodService;

    @Autowired
    public PrepodController(PrepodService prepodService) {
        this.prepodService = prepodService;
    }

    /**
     * Получить преподавателя по id
     * @param id
     * @return объект типа Prepod в формате json
     */
    @GetMapping("prepod/{id}")
    public Prepod fingById(@PathVariable Integer id){
        return prepodService.findPrepodById(id);
    }

    /**
     * Добавить преподавателя через параметры запроса
     * localhost:8189/app/prepod?id=3&name=Ivan&salary=100000
     * @param id
     * @param name
     * @param salary
     * @return
     */
    @PostMapping("/prepod")
    public String createPrepod(
            @RequestParam Integer id,
            @RequestParam String name,
            @RequestParam Integer salary
    ){
        prepodService.createPrepod(new Prepod(id, name, salary));
        return "Добавлено успешно";
    }

    /**
     * Добавить преподавателя через тело запроса
     * localhost:8189/app/createPrepod    (+ тело запроса)
     */
    @PostMapping("/createPrepod")
    public String createPrepod2(@RequestBody Prepod prepod){
        prepodService.createPrepod(prepod);
        return "Добавлено успешно";
    }
}
