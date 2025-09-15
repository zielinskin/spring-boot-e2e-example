package zielinskin.springboote2e.preferences.data;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class StudentPreferenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer studentId;
    private Integer dishId;
    private Integer dishType;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getDishId() {
        return dishId;
    }

    public void setDishId(Integer dishId) {
        this.dishId = dishId;
    }

    public Integer getDishType() {
        return dishType;
    }

    public void setDishType(Integer dishType) {
        this.dishType = dishType;
    }
}
