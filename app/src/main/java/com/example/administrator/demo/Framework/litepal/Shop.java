package com.example.administrator.demo.Framework.litepal;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wangyujie
 * Date 2017/6/13
 * Time 21:48
 * TODO
 */

public class Shop extends DataSupport {
    private int id;
    private String shop_id;
    private String shop_name;
    List<Product> products = new ArrayList<>();
}
