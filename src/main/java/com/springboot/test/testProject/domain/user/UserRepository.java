package com.springboot.test.testProject.domain.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/*User의 CRUD*/
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByEmail(String email); //findByEmail : 소셜로그인으로 반환되는 값중 email을 통해 신규/기존 사용자 판단을 위한 메소드
}
