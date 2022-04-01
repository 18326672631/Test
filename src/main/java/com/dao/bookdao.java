package com.dao;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.damian.book;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;

@Mapper
public interface bookdao extends BaseMapper<book> {

}
