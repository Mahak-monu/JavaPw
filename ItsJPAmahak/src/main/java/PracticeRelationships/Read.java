package PracticeRelationships;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Read {
    public  static void main(String [] args){
        EntityManagerFactory entityManagerFactory=Persistence.createEntityManagerFactory("MAHAKDASHORE3");
        EntityManager entityManager=entityManagerFactory.createEntityManager();
//         Employee e= entityManager.find(Employee.class, 1);
//        System.out.println(e.getDepartment().getDeptName());
//        System.out.println(e.getEmpId()+"  " +e.getEmpName()+"  "+e.getDepartment().getDeptId()+"   "+e.getDepartment().getDeptName());
//
//        Department d =entityManager.find(Department.class, 4);
//       System.out.println(d.getEmployee().getEmpId()+"    "+d.getEmployee().getEmpName()+"   "+d.getDeptId()+"  "+d.getDeptName());
//
//        OperatingSystem o=entityManager.find(OperatingSystem.class,6);
//        System.out.println(o.getOsId()+"   "+o.getOsName()+"  "+o.getEmployee().getEmpId()+"   "+o.getEmployee().getEmpName());

        Employee e=entityManager.find(Employee.class,1);
       for(OperatingSystem o: e.getOsList()){
           System.out.println(o.getOsName()+"   "+o.getOsId());
       }

    }
}
