package com.example.demo.repository;

import com.example.demo.models.entity.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRecordRepository extends JpaRepository<UserRecord, Long> {

  UserRecord findByUsername(String username);
}
