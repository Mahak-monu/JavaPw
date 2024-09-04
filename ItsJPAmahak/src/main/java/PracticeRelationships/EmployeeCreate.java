package PracticeRelationships;

import EntityRelationships.Student;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class EmployeeCreate {
    public static void main(String [] args){
        Employee e1=new Employee();
        e1.setEmpName("vinay");
        Employee e2=new Employee();
        e2.setEmpName("karina");

       Department d1=new Department();
       d1.setDeptName("CS");
       Department d2= new Department();
       d2.setDeptName("IT");

       e1.setDepartment(d1);
       e2.setDepartment(d2);

       d1.setEmployee(e1);
       d2.setEmployee(e2);

       OperatingSystem o1=new OperatingSystem();
       o1.setOsName("windows");

       OperatingSystem o2=new OperatingSystem();
       o2.setOsName("Linux");

       o1.setEmployee(e1);
       o2.setEmployee(e1);

       e1.setOsList(List.of(o1,o2));
       e2.setOsList(List.of(o1));


        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("MAHAKDASHORE3");
        EntityManager entityManager= entityManagerFactory.createEntityManager();
        EntityTransaction entityTransaction=entityManager.getTransaction();
        entityTransaction.begin();
        entityManager.persist(e1);
        entityManager.persist(e2);
        entityManager.persist(d1);
        entityManager.persist(d2);
        entityManager.persist(o1);
        entityManager.persist(o2);
        entityTransaction.commit();


    }
}
