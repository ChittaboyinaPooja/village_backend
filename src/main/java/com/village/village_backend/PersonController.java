package com.village.village_backend;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/person")
public class PersonController {

    private final PersonRepository repo;

    public PersonController(PersonRepository repo) {
        this.repo = repo;
    }

    // 🔹 GET all persons
    @GetMapping
    public List<Person> getAllPersons() {
        return repo.findAll();
    }

    // 🔹 ADD person
    @PostMapping
    public Person addPerson(@RequestBody Person person) {
        return repo.save(person);
    }

    // 🔥 DELETE NULL surname (browser-friendly)
    @GetMapping("/delete-null")
    public String deleteNullSurnamePersons() {
        List<Person> list = repo.findBySurnameIsNull();
        repo.deleteAll(list);
        return "Deleted all persons with NULL surname";
    }
} 