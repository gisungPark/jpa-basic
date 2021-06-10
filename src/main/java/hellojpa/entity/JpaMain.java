package hellojpa.entity;

import hellojpa.entity.ch8프록시.Child;
import hellojpa.entity.ch8프록시.Parent;
import hellojpa.entity.ch9값타입.Address;
import hellojpa.entity.ch9값타입.Period;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        EntityManager em = emf.createEntityManager();
        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {

            Address homeAddress = new Address("city", "street", "zipcode");

            Member member = new Member();
            member.setName("박00");
            member.setHomeAddress(homeAddress);

            member.getFavoriteFoods().add("족발");
            member.getFavoriteFoods().add("피자");
            member.getFavoriteFoods().add("치킨");

            member.getAddressHistory().add(new Address("old1", "street", "zipcode"));
            member.getAddressHistory().add(new Address("old2", "street", "zipcode"));

            em.persist(member);


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
