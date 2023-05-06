package ru.muctr.PrepodWebService.controllers;

import org.springframework.web.bind.annotation.*;

/**
 * @author Evgenia Skichko
 */

@RestController //Методы возвращают данные, не html-страницы
public class MainController {

    //localhost:8189/app/home
    @GetMapping("/home")
    public String getHomeString(){
        return "Home Page";
    }

    /**
     * Передача данных на сервер в параметрах запроса
     * localhost:8189/app/sum?i1=10&i2=15
     */
    @GetMapping("/sum")
    public Integer getSum(@RequestParam Integer i1, @RequestParam Integer i2){
        return i1 + i2;
    }

    /**
     * Передача данных на сервер с помощью переменных пути
     * localhost:8189/app/10
     */
    @GetMapping("/echo/{i}")
    public Integer getParam(@PathVariable Integer i){
        return i;
    }
}
