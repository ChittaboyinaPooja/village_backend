package com.village.village_backend;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface PersonRepository extends JpaRepository<Person, Long> {

    // ⭐ find persons with null surname
    List<Person> findBySurnameIsNull();

    List<Person> findBySurname(String surname);
}
