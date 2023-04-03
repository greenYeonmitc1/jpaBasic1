package org.example;

import org.example.domain.Member;

import javax.persistence.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // entityManagerFactory 어플리케이션에 단 1개 만들어지는 객체
        EntityManager em = emf.createEntityManager(); // 요청마다 만들어지는 객체 -> 영속성 컨텍스트 객체 생성
        EntityTransaction tx = em.getTransaction(); // 영속성 컨텍스트 객체 생성
        tx.begin(); // 트렌지션을 열고
        
        String query ="select m from Member m";
        List<Member> result = em.createQuery(query, Member.class).getResultList();

//        String query = "select m from Member m where m.loginId = :loingId";
//        Member result = em.createQuery(query, Member.class).setParameter("login_id" , "test7").getSingleResult();

        for(Member m : result){
            System.out.println("m = " + m);
        }

        query = "select m from Member m where m.age =:age";
        Member findMember = em.createQuery(query, Member.class).setParameter("age" , 800).getSingleResult();
        System.out.println("findMember = " + findMember);

        query = "select m from Member m where m.loginId =:login_id";
        findMember = em.createQuery(query, Member.class).setParameter("login_id" , "test7").getSingleResult();
        System.out.println("findMember = " + findMember);

        // 객체
//        Member m1 = new Member();
//        m1.setLoginId("test7");
//        m1.setAge(7);
//        em.persist(m1);
//        Member m2 = em.find(Member.class, m1.getId());
//        System.out.println("m2 == m1" + (m2 == m1));
//        Member m3 = em.find(Member.class, 5L);
        //em.remove(m3); // 영속성 컨텍스트에 있는 객체를 삭제


//        System.out.println("m1 = " + m1);
//        Member m2 = new Member();
//        m2.setLoginId("test");
//        m2.setAge(200);
//        em.persist(m2);
//        System.out.println("m2 = " + m2);
//        Member m3 = new Member();
//        m3.setLoginId("test");
//        m3.setAge(300);
//        em.persist(m3);
//        System.out.println("m3 = " + m3);
     //  find()
//       Member member = em.find(Member.class, 1L);
//        System.out.println("member = " + member);
//        Member member2 = em.find(Member.class, 4L);
//        System.out.println("member2 = " + member2);
//        // 이미 찾은 값을 다시 찾으면 1차 캐시에서 데이터를 꺼내옴
//        Member member3 = em.find(Member.class, 4L);
//        System.out.println("member3 = " + member3);

       tx.commit(); // 영속성컨텍스트를 삭제 -> db 쿼리문을 날려준다
    }
}