package com.example.unimalb.unimaadmin;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AdminReposistory extends JpaRepository<UnimalbAdmin, Long> {
    Optional<UnimalbAdmin> findAdminByEmail(String email);
}
