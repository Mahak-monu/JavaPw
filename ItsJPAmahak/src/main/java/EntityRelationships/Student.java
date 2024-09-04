package EntityRelationships;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.persistence.FetchType;
import java.util.List;
import javax.persistence.OneToMany;


@Entity
@Table

public class Student {
    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.AUTO)//not necessary to set rollno , autometically set rollno in incremental way
    private int rollno;
    @OneToMany(mappedBy = "student")
    private List<Course> courseList;

    public List<Course> getCourseList() {
        return courseList;
    }

    public void setCourseList(List<Course> courseList) {
        this.courseList = courseList;
    }

    @Column(name ="student_name",nullable=false)
    private String name;
    @OneToOne(fetch = FetchType.LAZY) // jitna chhiye uti hi query run karega or utna hi data lake dega
    private StudentIdCard card;

    public StudentIdCard getCard() {
        return card;
    }

    public void setCard(StudentIdCard card) {
        this.card = card;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRollno() {
        return rollno;
    }

    public void setRollno(int rollno) {
        this.rollno = rollno;
    }
//    @Override
//    public String toString(){
//        return this.getName()+"   "+card.getCardNumber()+"   "+this.getCard().getSoftwareVersion();
//    }
}
