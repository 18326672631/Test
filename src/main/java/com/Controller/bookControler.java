package com.Controller;


import com.Controller.util.R;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.damian.book;
import com.service.IboosService;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class bookControler {



    @Autowired
    private IboosService service;



    @GetMapping("/{id}")
    public R getById(@PathVariable  int id){

        return new R(true,service.getById(id));

    }

    @PostMapping
    public R save(@RequestBody book book){

        boolean flag = service.save(book);

        return new R(flag,flag?"添加成功":"添加失败");


    }

    @GetMapping
    public R getall(){

        return new R(true,service.list());
    }

    //更新
    @PutMapping
    public R update(@RequestBody  book book){

        boolean flag = service.updateById(book);

//        return new R(service.updateById(book));

        return new R(flag,flag?"修改成功":"修改失败");
    }


    @DeleteMapping("/{id}")
    public R delete(@PathVariable  int id){

        return new R(service.removeById(id));

    }


    /**
     * 分页
     * @param currentpage
     * @param pagesize
     * @return
     */
    @GetMapping("/{currentpage}/{pagesize}")                  //这里的book为Springmvc自动注入前端传入的数据
    public R getpage(@PathVariable int currentpage,@PathVariable int pagesize,book book){
        System.out.println(book);
        IPage<book> page = service.getpage(currentpage,pagesize,book);
        //前台访问页大于总页数的情况，跳转最后一个
        if (currentpage >page.getPages() ){
            page = service.getpage((int) page.getPages(),pagesize,book);
        }

        return new R(true,page);

    }



}
