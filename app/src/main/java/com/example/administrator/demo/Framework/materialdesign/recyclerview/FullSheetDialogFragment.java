package com.example.administrator.demo.Framework.materialdesign.recyclerview;

import android.app.Dialog;
import android.os.Bundle;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.BottomSheetDialogFragment;
import android.view.View;
import android.widget.Button;

import com.example.administrator.demo.R;


public class FullSheetDialogFragment extends BottomSheetDialogFragment implements View.OnClickListener {

    Button bsdButton;
    private BottomSheetBehavior behavior;

    @Override
    public void onStart() {
        super.onStart();
        //默认全屏展开
        behavior.setState(BottomSheetBehavior.STATE_EXPANDED);
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        BottomSheetDialog dialog = (BottomSheetDialog) super.onCreateDialog(savedInstanceState);
        View view = View.inflate(getContext(), R.layout.bottom_sheet_dialog, null);
        dialog.setContentView(view);
        bsdButton = (Button) view.findViewById(R.id.bsd_button);
        bsdButton.setOnClickListener(this);
        behavior = BottomSheetBehavior.from((View) view.getParent());
        return dialog;

    }

    @Override
    public void onClick(View v) {
        //点击关闭
        behavior.setState(BottomSheetBehavior.STATE_HIDDEN);
    }
}
