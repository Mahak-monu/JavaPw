package EntityRelationships;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class StudentRead {
    public static void main(String[] args) {
        EntityManagerFactory entityManagerFactory= Persistence.createEntityManagerFactory("MAHAKDASHORE2");
         EntityManager entityManager=entityManagerFactory.createEntityManager();
//         Student s=entityManager.find(Student.class,1);
//         if(s!=null)
//          System.out.println(s.getName());
////        System.out.println(s.getCard().getCardNumber()+s.getCard().getSoftwareVersion());
//        StudentIdCard c=entityManager.find(StudentIdCard.class,3);
//        System.out.println(c.getCardNumber()+"  "+c.getSoftwareVersion());
           Course cc1= entityManager.find(Course.class,5);
        System.out.println(cc1.getStudent().getName());
     //   System.out.println(cc1.getCourseID()+"  "+cc1.getCourseName()+"   "+cc1.getStudent().getRollno()+"  "+cc1.getStudent().getName()+"   "+cc1.getStudent().getCard().getCardNumber()+" "+cc1.getStudent().getCard().getSoftwareVersion());
        Student s1=entityManager.find(Student.class,1);
        System.out.println(s1.getName());
        for(Course c :s1.getCourseList()){
            System.out.println(c.getCourseName()+"  "+c.getCourseID());

        }


    }
}
