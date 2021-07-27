package com.example.demo.service;

import com.example.demo.models.UserRecordRequest;
import com.example.demo.models.entity.UserRecord;
import com.example.demo.repository.UserRecordRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class UserService {

  @Autowired
  private UserRecordRepository userRecordRepository;

  public boolean saveUserRecord(UserRecordRequest request) {

    UserRecord record = UserRecord.builder()
            .username(request.getUsername())
            .fullName(request.getRealName())
            .balance(request.getBalance()).build();

    record = userRecordRepository.save(record);

    return record.getId().intValue() > 0;
  }

  public UserRecord getUserRecord(String username) {

    return userRecordRepository.findByUsername(username);
  }
}
