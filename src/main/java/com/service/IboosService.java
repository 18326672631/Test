package com.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.damian.book;
import org.springframework.stereotype.Service;



public interface IboosService extends IService<book> {

    IPage<book> getpage(int currentpage, int pagesize);

    IPage<book> getpage(int currentpage, int pagesize, book book);
}
