package com.Controller.util;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
public class R {
    private boolean flag;
    private  Object  data;
    private String msg;



    //带参构造方法
    public R(boolean flag){
        this.flag=flag;
    }

    //默认构造方法
    public  R(){}

    public R(boolean flag,Object data){
        this.flag=flag;
        this.data=data;
    }

    public R(String s) {
        this.flag=false;
        this.msg=s;
    }

    public R(boolean flag,String s) {
        this.flag=flag;
        this.msg=s;
    }
}


