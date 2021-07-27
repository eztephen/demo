package com.example.demo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
public class UserRecordRequest {

  private String username;
  private String realName;
  private Double balance;
}
