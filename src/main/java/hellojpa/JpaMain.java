package hellojpa;

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
        //code
        try {
            //삽입
            /*Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");*/

            //조회
            /*Member findMember = em.find(Member.class, 1L);
            System.out.println(findMember.getId());
            System.out.println(findMember.getName());*/

            //수정
            /*Member findMember =em.find(Member.class, 1L);
            findMember.setName("HelloJPA");*/


            //전체 조회
            /*List<Member> result = em.createQuery("select m from Member as m", Member.class)
                    .setFirstResult(5)
                    .setMaxResults(8)
                    .getResultList();//5번부터 8개 가져와
            //Member 객체를 대상으로 select을 한다.

            for (Member member : result) {
                System.out.println("member.name = " + member.getName());
            }*/

            //DB에 tx.commit 전까지 1차캐시에 저장 후 한번에 저장
            /*Member member1 = new Member(150L, "A");
            Member member2 = new Member(160L, "B");
            em.persist(member1);
            em.persist(member2);
            System.out.println("---------------");*/


            //엔티티 변경
            /*Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");*/
            Member member = new Member();
            member.setUsername("C");
            member.setRoleType(RoleType.GUEST);

            em.persist(member);
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
