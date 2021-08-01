package joel.fontecilla.geektext.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import joel.fontecilla.geektext.entities.Person;

import java.util.*;

public interface PersonRepository extends JpaRepository<Person, Integer> {

    public List<Person> findByUsername(String username);
    public List<Person> findAll();
}
