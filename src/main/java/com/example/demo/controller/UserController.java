package com.example.demo.controller;

import com.example.demo.models.Response;
import com.example.demo.models.UserRecordRequest;
import com.example.demo.service.UserService;
import com.sun.istack.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController()
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService userService;

  @GetMapping("/")
  public Map<String, Object> test() {
    return Collections.singletonMap("message", "Welcome to DKP Backend Challenge");
  }

  @PostMapping(value = "/add", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> saveUserRecord(@NotNull @RequestBody UserRecordRequest record){

    if(userService.saveUserRecord(record))
      return ResponseEntity.ok().body(Response.builder().code("100")
              .message("Data successfully saved.").build());
    else
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Response.builder().code("500")
              .message("Error occurred while processing.").build());
  }

  @GetMapping(value = "/{username}", produces = MediaType.APPLICATION_JSON_VALUE)
  ResponseEntity<Object> getUserRecord(@NotNull @PathVariable("username") String username){

    return ResponseEntity.ok().body(Response.builder().code("100")
            .message("Successfully retrieved.")
            .data(userService.getUserRecord(username))
            .build());
  }
}