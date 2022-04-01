package com.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.damian.book;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

import java.util.List;



public interface bookService {

    public boolean save(book book);
    public boolean delete(int id);
    public book getById(int id);
    public List<book> getall();
    public boolean update(book book);
    public IPage<book> getpage(int currentpage,int pagesize);

}
