package com.kanban.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName(value = "content")
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "这是content类")
public class content {
    private Integer id;
    private String mattercontent;
}
