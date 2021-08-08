package hellojpa;

import javax.persistence.*;
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

            /*System.out.println("refMember = " +m.getClass());
            m.getUsername();
            System.out.println("isLoaded = " +emf.getPersistenceUnitUtil().isLoaded(m));*///true 이면 프록시인스턴스 초기화
            //Member findMember = em.find(Member.class, member.getId());
            //Member findMember = em.getReference(Member.class,member.getId());// 지금 가져오지않고 원할때 호출
            //em.getReeference(): 데이터베이스 조회를 미루는 가짜(프록시) 엔티티 객체 조회
            //System.out.println("findMember "+ findMember.getClass());
            //System.out.println("findMember.id = " + findMember.getId());//이미 아이디값이 있기에
            //System.out.println("findMember.username = " + findMember.getUsername());//이름값은 없기 때문에 db호출


            /*Team teamA = new Team();
            teamA.setName("teamA");
            em.persist(teamA);

            Team teamB = new Team();
            teamB.setName("teamB");
            em.persist(teamB);

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setTeam(teamA);
            em.persist(member1);

            Member member2 = new Member();
            member2.setUsername("member2");
            member2.setTeam(teamB);
            em.persist(member2);


            em.flush();
            em.clear();*/

            /*Member m = em.find(Member.class, member1.getId());
            System.out.println("m= " +m.getTeam().getClass());
            System.out.println("========================================");
            m.getTeam().getName();
            System.out.println("========================================");*/

            //List<Member> members =em.createQuery("select m from Member m",Member.class)
            //      .getResultList();
//            Parent parent=new Parent();
//            Child child1 =new Child();
//            Child child2 =new Child();
//
//            parent.addChild(child1);
//            parent.addChild(child2);
//
//            em.persist(parent);
//
//            em.flush();
//            em.clear();
//
//            Parent findParent=em.find(Parent.class, parent.getId());
//            findParent.getChildList().remove(0);
            //member.setWorkPeriod(new Period());

            Address address = new Address("city", "street", "100");

            Member member = new Member();
            member.setUsername("member1");
            member.setHomeAddress(address);
            em.persist(member);

            Address newAddress = new Address("NewCity", address.getStreet(), address.getZipcode());
            Address newAddress2 = new Address("NewCity", address.getStreet(), address.getZipcode());
            member.setHomeAddress(newAddress);
            em.persist(member);
//            Address copyAddress = new Address(address.getCity(), address.getStreet(), address.getZipcode());
//
//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(copyAddress);
//            em.persist(member2);
//



            tx.commit();
        } catch (Exception e) {
            tx.rollback();
        } finally {
            em.close();
        }
        emf.close();
    }
}
