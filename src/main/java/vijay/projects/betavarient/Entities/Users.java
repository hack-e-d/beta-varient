package vijay.projects.betavarient.Entities;

import org.hibernate.annotations.Formula;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;


@Entity(name = "users")
@Table(schema = "beta_varient")
public class Users implements Serializable {


    private static final String SuperHeroEndString = "SH";

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date_of_birth;

//    class attribute will not be present in the db
    @Transient
    public Boolean isSuperHero;

    public boolean getIsSuperHero() {
        return this.getName().contains(SuperHeroEndString);
    }

    public void setIsSuperHero(Boolean isSuperHero) {
        this.isSuperHero = isSuperHero;
    }

    public Users(String name, Date date_of_birth) {
        this.name = name;
        this.date_of_birth = date_of_birth;
    }

    public Users() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate_of_birth() {
        return date_of_birth;
    }

    public void setDate_of_birth(Date date_of_birth) {
        this.date_of_birth = date_of_birth;
    }

    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date_of_birth=" + date_of_birth +
                '}';
    }
}
