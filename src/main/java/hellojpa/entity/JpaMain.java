package hellojpa.entity;

import hellojpa.entity.ch7고급매핑.Movie;
import hellojpa.entity.ch8프록시.ch8Member;
import hellojpa.entity.ch8프록시.ch8Team;

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
            ch8Team team = new ch8Team();
            team.setName("파랑팀");
            em.persist(team);

            ch8Member member = new ch8Member();
            member.setName("박기성");
            member.setTeam(team);
            em.persist(member);

            em.flush();
            em.clear();

            ch8Member findMember = em.find(ch8Member.class, member.getId());
            System.out.println(findMember.getName());
            System.out.println(findMember.getTeam().getClass());
            System.out.println("====================");
            System.out.println(findMember.getTeam().getName());
            System.out.println("===================");


            tx.commit();
        }catch (Exception e){
            tx.rollback();

        }finally {
            em.close();
        }
        emf.close();
    }
}
