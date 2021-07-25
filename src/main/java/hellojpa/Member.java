package hellojpa;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
//@Table(name = "User") //이러면 원래는 Member이지만 USER테이블에 저장
//@Table(uniqueConstraints = "유니크 제한조건 걸떄는 이렇게")
public class Member {
    @Id
    private Long id;
    @Column(name = "name",insertable = true, updatable = true
            , nullable = true
            /*, unique = true*/
            /*,columnDefinition = "varchar(100) default 'EMPTY'"*/

            )
    //엥간하면 Column에 unique쓰지말기
    private String username;

    private Integer age;//가장적절한 인티저로 변환

    @Enumerated(EnumType.STRING)//db에 이넘타입 없어서 사용할떄 사용.
    private RoleType roleType;//EnumType.ORDINAL: enum의 순서를 db에 저장, EnumType.STRING : enum의 이름을 db에저장

    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    private LocalDate testLocalDate;//날짜까지 date형식으로 만들어짐
    private LocalDateTime testLocalDateTime;// 날짜+시간 timestamp로 만들어짐


    @Lob//데이터베이스에 큰 컨텐츠를 넣고 싶은 경우 dlob이랑 clob이 있는데 문자타입이면 clob 나머지는 blob으로 저장
    private String description;

    @Transient//db랑 매핑 안시킴
    private int temp;

    public Member() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getTemp() {
        return temp;
    }

    public void setTemp(int temp) {
        this.temp = temp;
    }
}
