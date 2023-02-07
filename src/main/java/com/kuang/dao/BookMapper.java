package com.kuang.dao;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookMapper {

    //    增加一本书
    int addBook(Books books);

    //删除一本书
    int deleteBookById(@Param("bookId") int id);
/*  用注解来简化xml配置的时候（比如Mybatis的Mapper.xml中的sql参数引入），@Param注解的作用是给参数命名,
    参数命名后就能根据名字得到参数值,正确的将参数传入sql语句中（一般通过#{}的方式，${}会有sql注入的问题）*/

    //更新一本书
    int updateBook(Books books);

    //查询一本书  根据Id来查询  且返回的是具体的书
    Books queryBookById(@Param("bookId") int id);

    //查询全部书籍
    List<Books> queryAllBook();

}
