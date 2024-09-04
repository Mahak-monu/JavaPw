package PracticeRelationships;

import javax.persistence.*;

@Entity
public class OperatingSystem {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int osId;
    private String osName;
    @ManyToOne
    private Employee employee;
    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }


    public int getOsId(){
        return osId;
    }
    public void setOsId(int osId){
        this.osId=osId;
    }

    public String getOsName() {
        return osName;
    }

    public void setOsName(String osName) {
        this.osName = osName;
    }
}
