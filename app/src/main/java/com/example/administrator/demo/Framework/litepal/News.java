package com.example.administrator.demo.Framework.litepal;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyujie
 * Date 2017/6/11
 * Time 17:46
 * TODO
 */

public class News extends DataSupport {
    private int id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(int commentCount) {
        this.commentCount = commentCount;
    }

    private String title;

    private String content;

//    private Date publishDate;


    public Introduction getIntroduction() {
        return introduction;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    private int commentCount;
    private Introduction introduction;  //一篇新闻对应着一个简介

    public void setIntroduction(Introduction introduction) {
        this.introduction = introduction;
    }

    private List<Comment> commentList = new ArrayList<Comment>(); //一篇新闻对应多条评论
    private List<Category> categoryList = new ArrayList<Category>();  //一篇新闻对应多种类别

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }
}
