package com.kuang.service;

import com.kuang.dao.BookMapper;
import com.kuang.pojo.Books;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;


/* @Component("BookServiceImpl")  此注解使用在类上实例化Bean
*  这里使用注解的话，则不用写：
* <bean id="BookServiceImpl" class="com.kuang.service.BookServiceImpl">
        <property name="bookMapper" ref="bookMapper"/>

   使用@Component注解时，不能马上判断是哪一层的，如要精确到哪一层则使用@Service注解
   若是Controller层和Dao层，则使用@Controller和@Repository注解
* */

public class BookServiceImpl implements BookService {


    //业务层(service)调用Dao层：组合Dao层（把Dao层放进来）
    private BookMapper bookMapper;

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }





    public int addBook(Books books) {
        return bookMapper.addBook(books);
    }

    public int deleteBookById(int id) {
        return bookMapper.deleteBookById(id);
    }

    public int updateBook(Books books) {
        return bookMapper.updateBook(books);
    }

    public Books queryBookById(int id) {
        return bookMapper.queryBookById(id);
    }

    public List<Books> queryAllBook() {
        return bookMapper.queryAllBook();
    }
}
