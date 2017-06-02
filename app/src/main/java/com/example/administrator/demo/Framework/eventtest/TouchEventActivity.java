package com.example.administrator.demo.Framework.eventtest;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import com.example.administrator.demo.R;

public class TouchEventActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_touchevent);
	}

	@Override
	public boolean dispatchTouchEvent(MotionEvent ev) {
		Log.w("eventTest", "Activity | dispatchTouchEvent --> " + TouchEventUtil.getTouchAction(ev.getAction()));
		return super.dispatchTouchEvent(ev);
//		return true;
	}

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		Log.w("eventTest", "Activity | onTouchEvent --> " + TouchEventUtil.getTouchAction(event.getAction()));
		return super.onTouchEvent(event);
	}

}