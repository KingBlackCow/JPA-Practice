package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue
    @Column(name ="TEAM_ID")
    private Long id;
    private String name;

    //다대일 양방향 매핑시
//    @OneToMany(mappedBy = "team")//Member에 있는 변수명 단순한 읽기만 가능하게 해줌
//    private List<Member> members = new ArrayList<>();

    //일대다 단방향일시 단방향부분이 연관관계의 주인
    @OneToMany
    @JoinColumn(name = "TEAM_ID")
    private List<Member> members = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
//    public List<Member> getMembers() {
//        return members;
//    }
//
//    public void setMembers(List<Member> members) {
//        this.members = members;
//    }
//
//    public void addMember(Member member) {
//        member.setTeam(this);
//        members.add(member);
//    }
}