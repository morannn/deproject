package com.kanban.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "user")
public class user {
    private String username;
    private String department;
    private String ranknum;
}
