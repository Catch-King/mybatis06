package com.zking.oa.biz;

import com.zking.oa.model.Book;

public interface IBookBiz {

    public Integer add(Book book);

    public void edit(Book book);

    public void del(Book book);

    public Book load(Book book);

}
