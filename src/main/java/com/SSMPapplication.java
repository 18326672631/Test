package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SSMPapplication {

    public static void main(String[] args) {
/*        String[] arg= new String[1];
        arg[0]="--server.port=8082";
        SpringApplication.run(SSMPapplication.class, arg);  //手动修改tomcat端口
        //临时属性*/
        //在启动时断开读取外部配置的入口
        SpringApplication.run(SSMPapplication.class);
    }

}
