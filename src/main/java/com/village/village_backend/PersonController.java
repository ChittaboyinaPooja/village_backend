package com.village.village_backend;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*") // 🔥 allows frontend (Netlify) to connect
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository repo;

    public PersonController(PersonRepository repo) {
        this.repo = repo;
    }

    // ✅ GET all persons
    @GetMapping
    public List<Person> getAllPersons() {
        return repo.findAll();
    }

    // ✅ ADD person
    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return repo.save(person);
    }

    // ✅ DELETE persons with NULL surname
    @DeleteMapping("/delete-null")
    public String deleteNullSurnamePersons() {
        List<Person> list = repo.findBySurnameIsNull();
        repo.deleteAll(list);
        return "Deleted all persons with NULL surname";
    }

    // ✅ DELETE specific family by surname
    @DeleteMapping("/delete-family/{surname}")
    public String deleteFamily(@PathVariable String surname) {
        List<Person> list = repo.findBySurname(surname);
        repo.deleteAll(list);
        return "Deleted family: " + surname;
    }
}