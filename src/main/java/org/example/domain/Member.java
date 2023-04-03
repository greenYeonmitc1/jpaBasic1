package org.example.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Entity
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;  // id bigint auto_increment primary key
    private String loginId;
    private Integer age;
    // 영속성관계 주인 Member
    @ManyToOne(fetch = FetchType.LAZY)
    private Team team;
}
