package ml.sadriev.model;

import javax.persistence.*;

/**
 * Created by Andrey Sadriev aka AESFUI on 21.11.2016.
 */

@Entity
@Table(name = "scores")
public class Scores {

    @Id
    @GeneratedValue
    private Integer id;

    @Enumerated(value = EnumType.STRING)
    private Subject subject;

    private Integer scores;

    @ManyToOne
    @JoinColumn(name = "students_id")
    private Students students;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getScores() {
        return scores;
    }

    public void setScores(int scores) {
        this.scores = scores;
    }

    public Students getStudents() {
        return students;
    }

    public void setStudents(Students students) {
        this.students = students;
    }
}
