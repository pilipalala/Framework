package com.example.administrator.demo.Framework.litepal;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import com.example.administrator.demo.Framework.BaseActivity;
import com.example.administrator.demo.R;

import org.litepal.tablemanager.Connector;

public class LitePalActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lite_pal);
        /*SQLiteOpenHelper dbHelper = new MySQLiteHelper(this, "demo.db", null, 1);
        SQLiteDatabase db = dbHelper.getWritableDatabase();*/

        SQLiteDatabase db = Connector.getDatabase();

    }
}
