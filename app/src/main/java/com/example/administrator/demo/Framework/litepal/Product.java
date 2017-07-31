package com.example.administrator.demo.Framework.litepal;

import org.litepal.crud.DataSupport;

/**
 * Created by wangyujie
 * Date 2017/6/13
 * Time 21:49
 * TODO
 */

public class Product extends DataSupport {
    private int id;
    private String product_id;
    private String product_name;
    private String product_price;
    private String product_pic;
    private Shop shop;

}
