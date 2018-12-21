package com.bawei.www.wangshuai12212.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.EditText;
import android.widget.TextView;

@SuppressLint("AppCompatCustomView")
public class EditTextView extends TextView {
    public EditTextView(Context context) {
        super(context);
        init();
    }

    private void init() {

    }


    public EditTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

}
