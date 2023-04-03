package org.example;

import org.example.domain.Locker;
import org.example.domain.Member;
import org.example.domain.Team;

import javax.persistence.*;
import java.util.List;

public class Main {
    static EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
    // entityManagerFactory 어플리케이션에 단 1개 만들어지는 객체
    static EntityManager em = emf.createEntityManager(); // 요청마다 만들어지는 객체 -> 영속성 컨텍스트 객체 생성


    public static void main(String[] args) {
        EntityTransaction tx = em.getTransaction(); // 영속성 컨텍스트 객체 생성
        tx.begin(); // 트렌지션을 열고
       setDummy();
      Member member1 = em.find(Member.class, 1L);
        Locker locker = new Locker();
        locker.setName("locker1");
        locker.setMember(member1);

        member1.setLocker(locker);
        em.persist(member1);
        em.persist(locker);
//
//        Member member2 = em.find(Member.class, 2L);
//        member2.setLocker(locker);


//        System.out.println("findMember = " + findMember);
//        // 연관관계
//        Team findTeam = findMember.getTeam(); // member -> team 조회
//        System.out.println("findTeam = " + findTeam);
//
//        // team -> member
//
//
//        Team team = em.find(Team.class, 1L);
//        List<Member> list1 = findMember.getTeam().getMembers();
//    // 맴버객체 안에서 team 조회 : 다대일 양방향 맵핑 조회
//        for(Member m : list1){
//            System.out.println("m.getName() = " +m.getName());
//        }
//        System.out.println("=====================");
//// team 객체 안에서 memberList 조회    // 역방향으로 조회 -> 일대다 조회
//        List<Member> list2 = team.getMembers();
//        for(Member m : list2){
//            System.out.println("m.getName() = " + m.getName());
//        }

       tx.commit(); // 영속성컨텍스트를 삭제 -> db 쿼리문을 날려준다
    }



    private static void setDummy(){

         Member m1 = new Member();
        m1.setName("m1");
        m1.setAge(7);

        System.out.println("m1 = " + m1);
        Member m2 = new Member();
        m2.setName("m2");
        m2.setAge(200);

        System.out.println("m2 = " + m2);
        Member m3 = new Member();
        m3.setName("m3");
        m3.setAge(300);

        System.out.println("m3 = " + m3);


        Team team = new Team();
        team.setName("TeamA");
        em.persist(team);

        Team team2 = new Team();
        team2.setName("TeamB");


        Team team3 = new Team();
        team3.setName("TeamC");


        Member member = new Member();
        member.setName("member1");
        member.setTeam(team); // member 와 team 연결

        // 직접 team 객체 값을 넣어지만

        // 양방향은 값을 둘다 참조값 넣어줘야함

        // member 객체 안에 있는 team 넣어주고
        m1.setTeam(team);
        m2.setTeam(team2);
        m3.setTeam(team3);

        // team 안에있는 membmer도 같어 넣어줘야한다
        team.getMembers().add(member);
        team.getMembers().add(m1);
        team2.getMembers().add(m2);
        team3.getMembers().add(m3);

        em.persist(m1);
        em.persist(m2);
        em.persist(m3);

        em.persist(team2);
        em.persist(team3);
        em.persist(member);
        em.flush(); // 영속성 컨텍스트에 있는 겂을 db에 올림
        em.clear(); // 영속성컨텍스트 초기화

    }

}


