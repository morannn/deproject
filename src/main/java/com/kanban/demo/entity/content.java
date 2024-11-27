package com.kanban.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName(value = "content")
public class content {
    private Integer id;
    private String mattercontent;
}
