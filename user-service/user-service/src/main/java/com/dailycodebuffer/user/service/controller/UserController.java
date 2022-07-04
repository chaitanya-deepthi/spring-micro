package com.dailycodebuffer.user.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailycodebuffer.user.service.VO.ResponseTemplateVO;
import com.dailycodebuffer.user.service.entity.User;
import com.dailycodebuffer.user.service.service.UserService;

import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/users")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/")
    public User saveUser(@RequestBody User user){
        log.info("inside UserController.saveUser save User");
        return userService.saveUser(user);
    }    
    @GetMapping("/{id}")
    public ResponseTemplateVO getUserWithDepartment(@PathVariable("id") String id, Long userId){
        log.info("inside UserController.getUserWithDepartment");
        userId = Long.valueOf(id);
        return userService.getUserWithDepartmentId(userId);
        
    }
}
