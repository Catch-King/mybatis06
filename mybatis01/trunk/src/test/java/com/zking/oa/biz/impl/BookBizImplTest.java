package com.zking.oa.biz.impl;

import com.zking.oa.biz.IBookBiz;
import com.zking.oa.mapper.BookMapper;
import com.zking.oa.model.Book;
import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import util.MybatisSessionFactoryUtils;

public class BookBizImplTest {

   //spring依赖注入
    private IBookBiz bookBiz;
    private Book book;
    private SqlSession sqlSession;

    @Before
    public void setUp() throws Exception {

        //1.spring管理
        BookBizImpl bookBizImpl=new BookBizImpl();

        //2.
        sqlSession= MybatisSessionFactoryUtils.openSession();
        BookMapper bookMapper = sqlSession.getMapper(BookMapper.class);
        bookBizImpl.setBookMapper(bookMapper);  //DI

        book=new Book();
        bookBiz=bookBizImpl;

    }

    @After
    public void tearDown() throws Exception {
        sqlSession.commit();  //spring管理声明事务
    }

    @Test
    public void add() throws Exception {

      book.setBookName("zj");
      book.setBookPrice(88f);
      book.setBookBrief("aaaa");

      Integer id= bookBiz.add(book);
      System.out.println(id);

    }

    @Test
    public void edit() throws Exception {

        book.setBookId(5);
        book.setBookName("xx");
        book.setBookPrice(66f);
        book.setBookBrief("haha");
        bookBiz.edit(book);

    }

    @Test
    public void del() throws Exception {

        book.setBookId(5);
        bookBiz.del(book);

    }

    @Test
    public void load() throws Exception {

        book.setBookId(3);

        Book b= bookBiz.load(book);
        System.out.println(b);
    }

}