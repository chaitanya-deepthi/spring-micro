package com.dailycodebuffer.user.service.VO;

import com.dailycodebuffer.user.service.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseTemplateVO {

    private User user;
    private Department department;
}
