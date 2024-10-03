package tn.esprit.charekyosr4twin5.entites;import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@NoArgsConstructor
@Setter
@ToString
@Table
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long numCourse ;
    private int level ;
    private Float price ;
    private int timeSlot ;
    @Enumerated(EnumType.STRING)
    private Course.Support support;
    public enum Support {
        SKI, SNOWBOARD
    }

    @Enumerated(EnumType.STRING)
    private Course.TypeCourse typeCourse;
    public enum TypeCourse {
        COLLECTIVE_CHILDREN, COLLECTIVE_ADULT, INDIVIDUAL
    }

}