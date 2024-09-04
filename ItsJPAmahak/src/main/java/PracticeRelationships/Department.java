package PracticeRelationships;

import javax.persistence.*;

@Entity
public class Department {
    @Column
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int deptId;
    @Column
    private String deptName;


    @OneToOne(mappedBy = "department")
    private Employee employee;
    public Employee getEmployee(){
        return employee;
    }
    public void setEmployee(Employee employee){
        this.employee=employee;
    }


    public int getDeptId() {
        return deptId;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public void setDeptId(int deptId) {
        this.deptId = deptId;
    }
}
