package org.example.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    // 읽기 전용 필드처럼 사용해서 다대일 양방향으로 사용하자
    @OneToMany(mappedBy = "team")
    private List<Member> members = new ArrayList<>();
}
