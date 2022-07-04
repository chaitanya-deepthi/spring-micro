package com.dailycodebuffer.department.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//@Entity annotation specifies that the class is an entity and is mapped to a database table
@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    // id and generatedvalue are JPA annotations , to created auto id as primarykey - departmentid
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

}
