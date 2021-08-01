package joel.fontecilla.geektext.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import joel.fontecilla.geektext.repositories.PersonRepository;
import joel.fontecilla.geektext.entities.Person;
import java.util.*;

@RestController
public class PersonController {
    
    @Autowired
    public PersonRepository People;

    public PersonController(PersonRepository people)
    {
        this.People = people;
    }

    @GetMapping("/quickcreate")
    public String quickCreate()
    {
        People.save(new Person("ricardo@example.com", "ricardo", "Ricardo", "Gonzalez", "Plantation"));
        People.save(new Person("jfont041@fiu.edu", "jfont041", "Joel", "Fontecilla", "Miami"));
        return "Profiles created";
    }

    @GetMapping("/searchbyusername/{username}")
    public List<Person> getByUsername(@PathVariable String username)
    {
        List<Person> personList = People.findByUsername(username);
        List<Person> returnList = new ArrayList<>();
        for (Person foundPerson : personList)
        {
            returnList.add(new Person(foundPerson.getUsername(), foundPerson.getPassword(), foundPerson.getName(), foundPerson.getLastname(),
            foundPerson.getHomeAddress()));
        }
        return returnList;
    }

    @GetMapping("/searchall")
    public List<Person> findAll()
    {
        List<Person> personList = People.findAll();
        List<Person> returnList = new ArrayList<>();

        for (Person person : personList)
        {
            returnList.add(new Person(person.getUsername(), person.getPassword(), person.getName(), person.getLastname(), 
            person.getHomeAddress()));
        }
        return returnList;
    }

    @PostMapping("/create")
    public String createPerson(@RequestBody Person newPerson)
    {
        People.save(new Person(newPerson.getUsername(), newPerson.getPassword(), newPerson.getName(), newPerson.getLastname(), 
        newPerson.getHomeAddress()));

        return "Profile created successfully";
    }

    @PutMapping("/updateprofile/{username}")
    public String updatePerson(@RequestBody Person updatedPerson, @PathVariable String username)
    {
        List<Person> updatePerson = People.findByUsername(username);
        if (!updatePerson.isEmpty())
        {
            Person p = updatePerson.get(0);
            p.setPassword(updatedPerson.getPassword());
            p.setName(updatedPerson.getName());
            p.setLastname(updatedPerson.getLastname());
            p.setHomeAddress(updatedPerson.getHomeAddress());
            People.save(p);
            return "Profile updated successfully";
        }
        else
        {
            return "Profile not found";
        }

        
    }
}
