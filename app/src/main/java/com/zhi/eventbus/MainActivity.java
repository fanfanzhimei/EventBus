package com.zhi.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Message;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import de.greenrobot.event.EventBus;

public class MainActivity extends Activity implements View.OnClickListener{
    private Button mBtnJump;
    private TextView mTvMessage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBtnJump = (Button) findViewById(R.id.btn_jump);
        mTvMessage = (TextView) findViewById(R.id.tv_message);
        mBtnJump.setOnClickListener(this);
        EventBus.getDefault().register(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_jump:
                Intent intent = new Intent(MainActivity.this, OtherActivity.class);
                startActivity(intent);
                break;
        }
    }

    public void onEventMainThread(FirstEvent firstEvent){
        Toast.makeText(MainActivity.this, "MainActivity:"+firstEvent.message, Toast
        .LENGTH_SHORT).show();
        mTvMessage.setText(firstEvent.message);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
