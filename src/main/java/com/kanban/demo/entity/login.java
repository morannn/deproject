package com.kanban.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

@Data
@TableName(value = "login")
public class login {
    private String username;
    private String password;
}
