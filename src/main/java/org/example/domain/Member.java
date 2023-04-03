package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@ToString
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // id bigint auto_increment primary key
    @Column(name="login_id")
    private String loginId;
    private Integer age;

    // defult EnumType ORDINAL -> 0 , 1 (index 값이 저장 )
@Enumerated(EnumType.STRING)
    private Role role;

LocalDate regDate;
@Lob
private String contents;


    // 연관관계 주인 Member  -> team_id
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;



}
