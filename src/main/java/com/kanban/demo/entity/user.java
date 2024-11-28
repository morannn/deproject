package com.kanban.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "user")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "这是user类")
public class user {
    private String username;
    private String department;
    private String ranknum;
}
