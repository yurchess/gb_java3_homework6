package mitroshin.task3;

import javax.persistence.*;

@Entity
@Table(name = "STUDENTS")
public class Student {

    @Id
    @GeneratedValue
    private long id;

    private String surname;
    private int score;

    public Student() {
    }

    public Student(String surname, int score) {
        this.surname = surname;
        this.score = score;
    }

    public String getSurname() {
        return surname;
    }

    public int getScore() {
        return score;
    }
}
