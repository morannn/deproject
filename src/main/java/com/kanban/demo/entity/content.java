package com.kanban.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
<<<<<<< HEAD
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "content")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "这是content类")
=======
import lombok.Data;

@Data
@TableName(value = "content")
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
public class content {
    private Integer id;
    private String mattercontent;
}
