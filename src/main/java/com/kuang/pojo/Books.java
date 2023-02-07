package com.kuang.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**@Data
 @AllArgsConstructor
 @NoArgsConstructor
 这三个是lombok插件中的注解，@Date为类提供读写功能（set和get方法）
 以及提供equals（）方法、hashCode（）方法、toString（）方法
 @AllArgsConstructor 为类提供有参构造方法
 @NoArgsConstructor  为类提供无参构造方法*/



@Data
@AllArgsConstructor
@NoArgsConstructor

public class Books {  //实体类

    private int bookID;
    private String bookName;
    private int bookCounts;
    private String detail;





}
