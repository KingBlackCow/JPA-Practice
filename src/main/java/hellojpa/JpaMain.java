package hellojpa;

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
            eZm.persist(member1);
            em.persist(member2);
            System.out.println("---------------");*/


            //엔티티 변경
            /*Member member = em.find(Member.class, 150L);
            member.setName("ZZZZZ");*/
            /*Member member = new Member();
            member.setUsername("C");
            member.setRoleType(RoleType.GUEST);*/

            //양방향 연관관계 주의 -실습
            /*
                순수 객체 상태를 고려해서 항상 양쪽에 값을 설정하자
                연관관계 편의 메소드를 생성하자
                양방향 매핑시에 무한 루프를 조심하자
             */
            //team.getMembers().add(member);Member.changeTeam에서 team을 넣었기 때문에
            //em.flush();
            //em.clear();

            /*Team findTeam = findMember.getTeam();
            System.out.println("findTeam  = " + findTeam.getName());*/

            //100번있다 가정하고 update
            /*Team newTeam= em.find(Team.class, 100L);
            findMeber.setTeam(newTeam);*/

//            Member member = new Member();
//
//            member.setUsername("member1");
//            em.persist(member);
//            Team team =new Team();
//            team.setName("teamA");
//
//            //
//            team.getMembers().add(member);
//            em.persist(team);


            /*Movie movie = new Movie();
            movie.setDirector("aah");
            movie.setActor("bobby");
            movie.setName("바람과함께사라지다");
            movie.setPrice(10000);

            em.persist(movie);

            em.flush();
            em.clear();

            Item findMovie = em.find(Item.class, movie.getId());
            System.out.println(findMovie);*/
            Member member1 = new Member();
            member1.setUsername("member1");
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            em.persist(member2);
            Member m1 = em.find(Member.class, member1.getId());
            em.flush();
            em.clear();


            /*Member m2 = em.getReference(Member.class, member2.getId());
            System.out.println("m1==m2 "+(m1 instanceof Member));
            System.out.println("m1==m2 "+(m2 instanceof Member));*/
            Member refMember = em.getReference(Member.class, member1.getId());
            System.out.println("refMember = " +refMember.getClass());
            refMember.getUsername();
            System.out.println("isLoaded = " +emf.getPersistenceUnitUtil().isLoaded(refMember));//true 이면 프록시인스턴스 초기화
            //Member findMember = em.find(Member.class, member.getId());
            //Member findMember = em.getReference(Member.class,member.getId());// 지금 가져오지않고 원할때 호출
            //em.getReeference(): 데이터베이스 조회를 미루는 가짜(프록시) 엔티티 객체 조회
            //System.out.println("findMember "+ findMember.getClass());
            //System.out.println("findMember.id = " + findMember.getId());//이미 아이디값이 있기에
            //System.out.println("findMember.username = " + findMember.getUsername());//이름값은 없기 때문에 db호출
            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
