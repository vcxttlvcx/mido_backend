package io.cloudtype.Demo.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import io.cloudtype.Demo.entity.Pioneer;

@Repository
public interface PioneerRepository extends JpaRepository<Pioneer, Integer> {
    Optional<Pioneer> findByEmailAndPassword(String email, String password);

    boolean existsByEmail(String email); // 중복 확인
}
