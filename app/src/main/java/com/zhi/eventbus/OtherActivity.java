package com.zhi.eventbus;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import de.greenrobot.event.EventBus;

/**
 * Created by Administrator on 2016/11/16.
 * 在这个界面点击按钮发送消息
 */
public class OtherActivity extends Activity implements View.OnClickListener{

    private Button mBtnSend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_other);
        mBtnSend = (Button) findViewById(R.id.btn_send);
        mBtnSend.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_send:
                sendMessage();
                break;
        }
    }

    private void sendMessage(){
        FirstEvent firstEvent = new FirstEvent("这是OtherActivity发送过来的消息");
        EventBus.getDefault().post(firstEvent);
    }
}