package hellojpa;

import lombok.Data;
import lombok.Getter;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
//@Table(name = "User") //이러면 원래는 Member이지만 USER테이블에 저장
//@Table(uniqueConstraints = "유니크 제한조건 걸떄는 이렇게")
/*@SequenceGenerator(
        name = “MEMBER_SEQ_GENERATOR",
        sequenceName = “MEMBER_SEQ", //매핑할 데이터베이스 시퀀스 이름
        initialValue = 1, allocationSize = 1)*/
@TableGenerator(
        name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", allocationSize = 50)
@Data
public class Member {
//    @Id
//    //@GeneratedValue(strategy = GenerationType.IDENTITY)
//    //@GeneratedValue(strategy = GenerationType.SEQUENCE generator = "MEMBER_SEQ_GENERATOR")// Auto 디비방언에 따라 자동생성
//    @GeneratedValue(strategy = GenerationType.TABLE,generator = "MEMBER_SEQ_GENERATOR")
//
//    private Long id;
//    @Column(name = "name",insertable = true, updatable = true
//            , nullable = true
//            /*, unique = true*/
//            /*,columnDefinition = "varchar(100) default 'EMPTY'"*/
//
//            )
//    //엥간하면 Column에 unique쓰지말기
//    private String username;
//
//    private Integer age;//가장적절한 인티저로 변환
//
//    @Enumerated(EnumType.STRING)//db에 이넘타입 없어서 사용할떄 사용.
//    private RoleType roleType;//EnumType.ORDINAL: enum의 순서를 db에 저장, EnumType.STRING : enum의 이름을 db에저장
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date createdDate;
//
//    @Temporal(TemporalType.TIMESTAMP)
//    private Date lastModifiedDate;
//
//    private LocalDate testLocalDate;//날짜까지 date형식으로 만들어짐
//    private LocalDateTime testLocalDateTime;// 날짜+시간 timestamp로 만들어짐
//
//
//    @Lob//데이터베이스에 큰 컨텐츠를 넣고 싶은 경우 dlob이랑 clob이 있는데 문자타입이면 clob 나머지는 blob으로 저장
//    private String description;
//
//    @Transient//db랑 매핑 안시킴
//    private int temp;
//
//    public Member() {
//
//    }



    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name = "USERNAME")
    private String username;


    //다대일 양방향
    @ManyToOne
    @JoinColumn(name = "TEAM_ID",insertable = false,updatable = false)
    private Team team;

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

//    @OneToMany(mappedBy = "member")
//    private List<MemberProduct> memberProducts = new ArrayList<>();
//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "TEAM_ID")
//    private Team team;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

//    public Team getTeam() {
//        return team;
//    }
//
//    public void changeTeam(Team team) {
//        this.team = team;
//        team.getMembers().add(this);
//    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
     

}
