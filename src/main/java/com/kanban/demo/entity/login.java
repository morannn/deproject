package com.kanban.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
<<<<<<< HEAD
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
=======
import lombok.Builder;
import lombok.Data;

@Data
@TableName(value = "login")
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
public class login {
    private String username;
    private String password;
}
