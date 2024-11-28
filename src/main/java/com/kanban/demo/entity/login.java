package com.kanban.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "login")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "这是login类")
public class login {
    private String username;
    private String password;
}
