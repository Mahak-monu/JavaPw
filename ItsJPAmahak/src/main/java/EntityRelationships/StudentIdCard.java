package EntityRelationships;

import javax.persistence.*;

@Entity
public class StudentIdCard {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int  cardNumber;
    private String softwareVersion;
    @OneToOne(mappedBy = "card")
    private Student student;

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public int getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(int cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getSoftwareVersion() {
        return softwareVersion;
    }

    public void setSoftwareVersion(String softwareVersion) {
        this.softwareVersion = softwareVersion;
    }


}
