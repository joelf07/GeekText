package joel.fontecilla.geektext.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Table(name = "Person")
public class Person implements Serializable{
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private int id;
    @Column(name = "username")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "name")
    private String name;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "homeaddress")
    private String homeAddress;

    public Person()
    {

    }

    public Person(String username, String password, String name, String lastName, String homeAddress)
    {
        this.username = username;
        this.password = password;
        this.name = name;
        this.lastName = lastName;
        this.homeAddress = homeAddress;
    }

    public int getId()
    {
        return this.id;
    }

    public String getUsername()
    {
        return this.username;
    }

    public String getPassword()
    {
        return this.password;
    }

    public String getName()
    {
        return this.name;
    }

    public String getLastname()
    {
        return this.lastName;
    }

    public String getHomeAddress()
    {
        return this.homeAddress;
    }

    public void setUsername(String username)
    {
        this.username = username;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public void setLastname(String lastname)
    {
        this.lastName = lastname;
    }

    public void setHomeAddress(String homeAddress)
    {
        this.homeAddress = homeAddress;
    }

    
}