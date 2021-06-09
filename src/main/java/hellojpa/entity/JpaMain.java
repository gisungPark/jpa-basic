package hellojpa.entity;

import hellojpa.entity.ch8프록시.Child;
import hellojpa.entity.ch8프록시.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Child child1 = new Child();
            Child child2 = new Child();

            Parent parent = new Parent();

            parent.getChildren().add(child1);
            parent.getChildren().add(child2);

            em.persist(parent);



            tx.commit();
        }catch (Exception e){
            tx.rollback();

        }finally {
            em.close();
        }
        emf.close();
    }
}
