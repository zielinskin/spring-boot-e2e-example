package zielinskin.springboote2e.restaurant.data;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

@Entity
public class DrinkEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    @Min(0)
    @Max(10)
    private Integer carbonationScale;
    private Boolean ageRestricted;

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

    public Integer getCarbonationScale() {
        return carbonationScale;
    }

    public void setCarbonationScale(Integer carbonationScale) {
        this.carbonationScale = carbonationScale;
    }

    public Boolean getAgeRestricted() {
        return ageRestricted;
    }

    public void setAgeRestricted(Boolean ageRestricted) {
        this.ageRestricted = ageRestricted;
    }
}
