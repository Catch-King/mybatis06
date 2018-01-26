package com.zking.oa.biz.impl;

import com.zking.oa.biz.IBookBiz;
import com.zking.oa.mapper.BookMapper;
import com.zking.oa.model.Book;

public class BookBizImpl implements IBookBiz {

    //spring依赖注入
   private BookMapper bookMapper;

    public BookBizImpl() {
    }

    public BookMapper getBookMapper() {
        return bookMapper;
    }

    public void setBookMapper(BookMapper bookMapper) {
        this.bookMapper = bookMapper;
    }

    @Override
    public Integer add(Book book) {
        int id= bookMapper.insert(book);
        return id;
    }

    @Override
    public void edit(Book book) {
        bookMapper.updateByPrimaryKey(book);
    }

    @Override
    public void del(Book book) {
        bookMapper.deleteByPrimaryKey(book.getBookId());
    }

    @Override
    public Book load(Book book) {
        return bookMapper.selectByPrimaryKey(book.getBookId());
    }

}
