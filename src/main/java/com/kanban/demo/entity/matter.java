package com.kanban.demo.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
<<<<<<< HEAD
import io.swagger.annotations.ApiModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
=======
import lombok.Data;
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
import org.springframework.format.annotation.DateTimeFormat;


import java.util.Date;

@Data
@TableName(value = "matter")
<<<<<<< HEAD
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(description = "这是matter类")
=======
>>>>>>> b5dc19de15dcf86a592376c6ba27475bc7288e1a
public class matter {
    private Integer id;
    private String mattername;
    private String matterstatus;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date begintime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date yujitime;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date endtime;
    private String username;
    private String department;


}
