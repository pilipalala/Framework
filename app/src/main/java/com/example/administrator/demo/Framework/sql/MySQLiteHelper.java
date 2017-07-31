package com.example.administrator.demo.Framework.sql;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by wangyujie
 * Date 2017/6/13
 * Time 21:05
 * TODO 数据库传统的建表方式
 *
 * 新建一张news表，其中有title，content，publishdate，commentcount这几列，分别代表着新闻标题、新闻内容、发布时间和评论数
 *
 *
 */

public class MySQLiteHelper extends SQLiteOpenHelper {
    public static final String CREATE_NEWS = "create table news ("
            + "id integer primary key autoincrement, "
            + "title text, "
            + "content text, "
            + "publishdate integer,"
            + "commentcount integer)";
    public MySQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_NEWS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
