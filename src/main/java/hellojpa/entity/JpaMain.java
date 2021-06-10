package hellojpa.entity;

import hellojpa.entity.ch8프록시.Child;
import hellojpa.entity.ch8프록시.Parent;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Child child1 = new Child();
            child1.setName("아들");
            Child child2 = new Child();
            child2.setName("딸");

            Parent parent = new Parent();
            parent.setName("아버지");

            parent.addChild(child1);
            parent.addChild(child2);

            em.persist(parent);
            em.flush();
            em.clear();

            System.out.println("=========================");

            Parent findParent = em.find(Parent.class, parent.getId());
            em.remove(findParent);


            tx.commit();
        }catch (Exception e){
            e.printStackTrace();
            tx.rollback();

        }finally {
            em.close();
        }
        emf.close();
    }
}
