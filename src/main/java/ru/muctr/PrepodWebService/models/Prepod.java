package ru.muctr.PrepodWebService.models;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author Evgenia Skichko
 */

@Data
@AllArgsConstructor
public class Prepod {
    private int id;
    private String name;
    private int salary;
}
