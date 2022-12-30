package zielinskin.h2example.data;

import javax.persistence.*;

@Entity
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;

    private Double grade;
    @ManyToOne
    @JoinColumn(name = "student_id")
    public LectureEntity lecture;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getGrade() {
        return grade;
    }

    public void setGrade(Double grade) {
        this.grade = grade;
    }

    public LectureEntity getLecture() {
        return lecture;
    }

    public void setLecture(LectureEntity lecture) {
        this.lecture = lecture;
    }
}
