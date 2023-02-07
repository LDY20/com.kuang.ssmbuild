package com.kuang.controller;


import com.kuang.pojo.Books;
import com.kuang.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import java.awt.print.Book;
import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller   //@Controller注解表明当前类是一个controller类，是@Component注解的一种具体形式。
@RequestMapping("/book")  //此注解表示请求映射；RequestMapping就是一个映射路径
public class BookController {
    //controller层 调 service层

    @Autowired   //自动注入（配装）  是按照数据类型从Spring容器中进行匹配的 ，可以不需写@Qualifie
    @Qualifier("BookServiceImpl")  //要注入的Bean的id  是按照id值从容器中进行匹配，但是@Qualifie要跟@Autowired一起使用


    /*即：<bean id="BookServiceImpl" class="com.kuang.service.BookServiceImpl">
        <property name="bookMapper" ref="bookMapper"/>  用了注解后，此段不用写*/

    //@Resource(name="BookServiceImpl") 此注解相当于@Autowired + @Qualifier

    /*
    * @Value()用于字段前，注入普通属性
    *
    * @Value("test")
    * private String tt; //这里test就赋值给tt了
    *
    * @Value("${}")与@Value("#{}")的区别？？？   SPel表达式？
    *
    * */

    //@Scope("singleton") 说明此处是单例


    private BookService bookService;  //将service层放进来

    //查询全部书籍，并且返回到一个书籍展示页面
    @RequestMapping("/allBook")  //请求地址 http:localhost:8080/book/allBook
    public String list(Model model) {
        List<Books> list = bookService.queryAllBook(); //调用业务层的方法，查询全部书籍
        model.addAttribute("list", list); //书籍查到后返回前端展示,把查询结果放到model里

        return "allBook"; //返回到allBook页面（写allBook.jsp）
        //return "redirect:/allBook.jsp";  //xml配置了后缀可省略.jsp
        // 重定向(redirect)和转发(forward)的区别？？？
        //转发是一次请求，重定向是多次请求；默认是转发
        //请求转发是浏览器向服务器发出请求后，服务器将请求转发到另一个资源地址再响应浏览器，是一次请求，URL地址不变
        //
    }

    //跳转到增加书籍页面
    // @RequestMapping(value = "toAddBook",method = RequestMethod.GET)  指定get请求
    @RequestMapping("toAddBook") //当属性为一个且是value则可以省略不写
    public String toAddPaper(){
        return "addBook";
    }


    //添加到书籍的请求
    public String addBook(Books books){

        bookService.addBook(books);
        return "redirect:/book/allBook"; //用重定向返回allBook页面
    }



    /**************************************************************/



    //测试页面跳转--通过ModelAndView对象
    @RequestMapping("test")
    public ModelAndView test(){  //或者是public ModelAndView test(ModelAndView modelAndView){...} 后面就不需要创建ModelAndView对象了
        /*
            Model:模型  作用是封装数据
            View:视图   作用是展示数据
         */
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("username","ceshi"); //设置模型数据
        modelAndView.setViewName("success"); //设置视图名称
        return modelAndView;
    }

    //测试文件上传
    @RequestMapping("uploadfile")
    @ResponseBody
    public void uploadFile(String name, MultipartFile file) throws IOException {
        //获得文件名称
        String originalFilename = file.getOriginalFilename();
        //保存文件(保存到桌面上)
        file.transferTo(new File("C:\\Users\\Administrator\\Desktop"));
    }
    //测试上传多个文件:使用数组，用for循环实现
    @RequestMapping("uploadfiles")
    @ResponseBody
    public void uploadFiles(String name,MultipartFile[] files) throws IOException {
        for (MultipartFile multipartFile:files) {
            String originalFilename = multipartFile.getOriginalFilename();
            multipartFile.transferTo(new File("C:\\Users\\Administrator\\Desktop"));
        }
    }



}
/* 自动装配 Autowired
* @Autowired 是一个注释，它可以对类成员变量、方法及构造函数进行标注，让 spring 完成 bean 自动装配的工作。
		@Autowired 默认是按照类去匹配，配合 @Qualifier 指定按照名称去装配 bean
			* 当在field上使用此注解，并且使用属性来传递值时，Spring会自动把值赋给此field
			* 最经常的用法是将此注解用于setter方法上
            * 用于构造方法上

* */