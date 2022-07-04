package com.dailycodebuffer.user.service.service;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dailycodebuffer.user.service.VO.Department;
import com.dailycodebuffer.user.service.VO.ResponseTemplateVO;
import com.dailycodebuffer.user.service.entity.User;
import com.dailycodebuffer.user.service.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RestTemplate restTemplate;
    public User saveUser(User user) {
        log.info("inside UserService.saveUSer");
        return userRepository.save(user);
    }

    public ResponseTemplateVO getUserWithDepartmentId(Long userId) {
        log.info("inside UserService.getUserWithDepartmentId");
        ResponseTemplateVO vo = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);    
        
        // Create a neat value object to hold the URL
URL url;
try {
    url = new URL("http://localhost:9001/departments/"+ user.getDepartmentId());
    // Open a connection(?) on the URL(??) and cast the response(???)
HttpURLConnection connection = (HttpURLConnection) url.openConnection();

// Now it's "open", we can set the request method, headers etc.
connection.setRequestProperty("accept", "application/json");

// This line makes the request
InputStream responseStream = connection.getInputStream();


// Manually converting the response body InputStream to APOD using Jackson
ObjectMapper mapper = new ObjectMapper();
Department dep = mapper.readValue(responseStream, Department.class);

// Finally we have the response
System.out.println(dep.getDepartmentName());
vo.setUser(user);
            vo.setDepartment(dep);

} catch (MalformedURLException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
} catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
}


        

    //    Department department =  restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/" + user.getDepartmentId(),
    //             Department.class);
     //       vo.setUser(user);
    //        vo.setDepartment(department);
        return vo;
    }
}   
