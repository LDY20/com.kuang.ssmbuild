package com.kuang.service;

import com.kuang.pojo.Books;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BookService {

    int addBook(Books books);


    int deleteBookById(int id);


    int updateBook(Books books);


    Books queryBookById(int id);


    List<Books> queryAllBook();
}

/*写好后写这个接口的实现类BookServiceImpl（BookServiceImpl实现这个接口）*/