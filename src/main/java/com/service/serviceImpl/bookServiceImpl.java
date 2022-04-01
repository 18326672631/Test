package com.service.serviceImpl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.damian.book;
import com.dao.bookdao;
import com.service.IboosService;
import org.apache.ibatis.annotations.Mapper;
import org.apache.logging.log4j.util.Strings;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

           //ServiceImpl<bookdao,book>      <引用的实现类，对应的模型类>
@Service
@MapperScan("com.dao")
public class bookServiceImpl extends ServiceImpl<bookdao,book> implements IboosService {

        @Autowired
        bookdao bookdao;

        @Override
        public IPage<book> getpage(int currentpage, int pagesize) {
            IPage<book> page= new Page<>(currentpage,pagesize);
            return bookdao.selectPage(page,null);
        }

       @Override
       public IPage<book> getpage(int currentpage, int pagesize, book book) {

            /*
                         //按条件查询
                @Test
                void getBy(){
                    QueryWrapper<book> mapper = new QueryWrapper();
                    String name=null;
            //        String name="Spring"
                    //SELECT id,type,name,description FROM tbl_book WHERE (name LIKE ?)
                    //                      属性      值
                    mapper.like(name!=null,"name",name);
                    //name为空时，就不进行拼接
                    System.out.println(bookdao.selectList(mapper));
             */
           LambdaQueryWrapper<book> mapper = new LambdaQueryWrapper<book>();
           mapper.like(Strings.isNotEmpty(book.getType()), com.damian.book::getType,book.getType());
           mapper.like(Strings.isNotEmpty(book.getName()), com.damian.book::getName,book.getName());
           mapper.like(Strings.isNotEmpty(book.getDescription()), com.damian.book::getDescription,book.getDescription());

           IPage<book> page= new Page<>(currentpage,pagesize);
           return bookdao.selectPage(page,mapper);
        }


}
