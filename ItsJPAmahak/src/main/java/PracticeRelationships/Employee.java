package PracticeRelationships;

import javax.persistence.*;
import java.util.List;

@Entity
public class Employee {
    @Column
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private int empId;
    @Column(nullable=false)//it is must to provide a name
    private String empName;


    @OneToOne(fetch=FetchType.LAZY)

    private Department department;
    @OneToMany(mappedBy = "employee")
    private List<OperatingSystem> osList;
    public List<OperatingSystem> getOsList(){
        return osList;
    }
    public void setOsList(List<OperatingSystem> osList){
        this.osList=osList;
    }


    public Department getDepartment(){
        return department;
    }
    public void setDepartment(Department department){
        this.department=department;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }
}
