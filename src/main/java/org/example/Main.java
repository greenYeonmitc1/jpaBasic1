package org.example;

import org.example.domain.Member;

import javax.persistence.*;

public class Main {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");
        // entityManagerFactory 어플리케이션에 단 1개 만들어지는 객체
        EntityManager em = emf.createEntityManager(); // 요청마다 만들어지는 객체 -> 영속성 컨텍스트 객체 생성
        EntityTransaction tx = em.getTransaction(); // 영속성 컨텍스트 객체 생성
        tx.begin();

        // 객체
        Member m1 = new Member();
        m1.setLoginId("test");
        m1.setAge(100);
        em.persist(m1);
        System.out.println("m1 = " + m1);
        Member m2 = new Member();
        m2.setLoginId("test");
        m2.setAge(200);
        em.persist(m2);
        System.out.println("m2 = " + m2);
        Member m3 = new Member();
        m3.setLoginId("test");
        m3.setAge(300);
        em.persist(m3);
        System.out.println("m3 = " + m3);

        em.flush(); // 쿼리 바로 날리기



        tx.commit(); // 영속성컨텍스트를 삭제 -> db 쿼리문을 날려준다
    }
}