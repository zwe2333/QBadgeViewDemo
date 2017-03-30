package com.example.qbadgeviewdemo;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import q.rorbin.badgeview.Badge;
import q.rorbin.badgeview.QBadgeView;

public class MainActivity extends AppCompatActivity {
    private TextView mTextView;
    private EditText mEditText;
    private Button mButton;
    private QBadgeView mQBadgeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();
    }

    private void initViews() {
        mQBadgeView=new QBadgeView(MainActivity.this);
        mTextView= (TextView) findViewById(R.id.tv_badge);
        mEditText= (EditText) findViewById(R.id.edt_content);
        mButton= (Button) findViewById(R.id.btn_send);
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String content=mEditText.getText().toString().trim();
                mQBadgeView.bindTarget(mTextView).setBadgeBackgroundColor(Color.RED).setBadgeTextSize(18f,true).setBadgeText(content).setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
                    @Override
                    public void onDragStateChanged(int dragState, Badge badge, View targetView) {

                    }
                });
                mEditText.setText("");
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
            }
        });
    }
}
