package com.service.serviceImpl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.damian.book;
import com.dao.bookdao;
import com.service.bookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


public class BookServiceImpl2 implements bookService {

    @Autowired
    private bookdao bookdao;

    @Override
    public boolean save(book book) {
        return bookdao.insert(book)>0;
        //dao返回的是影响的行数，service返回的是boooleam类型数据，判断后返回
    }

    @Override
    public boolean delete(int id) {
        return bookdao.deleteById(id)>0;
    }

    @Override
    public book getById(int id) {
        return bookdao.selectById(id);
    }

    @Override
    public List<book> getall() {
        return bookdao.selectList(null);
    }

    @Override
    public boolean update(book book) {
        return bookdao.updateById(book)>0;
    }

    @Override
    public IPage<book> getpage(int currentpage, int pagesize) {
        IPage page = new Page(currentpage,pagesize);
        return bookdao.selectPage(page,null);  //，分页查询，查询条件为空
    }
}
