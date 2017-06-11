package com.example.administrator.demo.Framework.litepal;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyujie
 * Date 2017/6/11
 * Time 18:04
 * TODO
 */

public class Category {
    private List<News> newsList = new ArrayList<News>();  //一种类别对应多篇新闻

    public List<News> getNewsList() {
        return newsList;
    }

    public void setNewsList(List<News> newsList) {
        this.newsList = newsList;
    }
}
