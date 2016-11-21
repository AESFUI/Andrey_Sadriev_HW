package ml.sadriev.model;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Andrey Sadriev aka AESFUI on 21.11.2016.
 */
@Entity
@Table(name = "students")
public class Students {

    @Id
    @GeneratedValue
    private Integer id;

    private String surname;

    private String name;

    private String middlename;

    private String group;

    @OneToMany(mappedBy = "")
    private List<Scores> scores;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMiddlename() {
        return middlename;
    }

    public void setMiddlename(String middlename) {
        this.middlename = middlename;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public static void fillStudents() {
        Students stud1 = new Students();
        stud1.setName("Василий");
        stud1.setMiddlename("Петрович");
        stud1.setSurname("Иванов");
        stud1.setGroup("2016-ВЭ");

        Students stud2 = new Students();
        stud2.setName("Пётр");
        stud2.setMiddlename("Сергеевич");
        stud2.setSurname("Козлов");
        stud2.setGroup("2016-СМ");

        Students stud3 = new Students();
        stud3.setName("Степан");
        stud3.setMiddlename("Сидорович");
        stud3.setSurname("Шелезяка");
        stud3.setGroup("2016-ВЭ");

        Students stud4 = new Students();
        stud4.setName("Аркадий");
        stud4.setMiddlename("Данилович");
        stud4.setSurname("Джапаридзе");
        stud4.setGroup("2016-СМ");

        Students stud5 = new Students();
        stud5.setName("Иван");
        stud5.setMiddlename("Несторович");
        stud5.setSurname("Махнов");
        stud5.setGroup("2014-ИА");

        Students stud6 = new Students();
        stud6.setName("Георгий");
        stud6.setMiddlename("Андреевич");
        stud6.setSurname("Лопухин");
        stud6.setGroup("2014-ИА");
    }
    }
