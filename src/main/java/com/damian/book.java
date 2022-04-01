package com.damian;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
@TableName("tbl_book")
public class book {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
