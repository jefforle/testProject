package com.springboot.test.testProject.domain.posts;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

/* Posts 클래스로 DB를 접근하게 해줄 JpaRepository를 생성
 * JPA에선 Repository라고 부르며 인터페이스로 생성!!(Mybatis에선 Dao라고 불림)
 * JpaRepository<Entiry클래스, PK타입>을 상속하면 기본적인 CRUD메소드가 자동생성됨!!
 * ## Entity 클래스와 기본 Entity Repository는 함께 위치 ##
 */
public interface PostsRepository extends JpaRepository<Posts, Long> {
    @Query("SELECT p FROM Posts p ORDER BY p.id DESC") //SpringDataJpa 에서 제공하지 메소드를 쿼리로 작성시 이렇게 쓰면 됨
    List<Posts> findAllDesc(); //추상메소드 (return값이 List<Posts>인??)
}
