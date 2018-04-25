package com.okloong.timedown;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final long STOP_DURATION_TIME = 5000L;//停留时间

    Button bt_time ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        bt_time = findViewById(R.id.bt_time);
        bt_time.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                duartionStartTime = System.currentTimeMillis();
                checkWaitingLauncerTimeFinished();
            }
        });
    }


    private long duartionStartTime = System.currentTimeMillis();
    private boolean mSkipLauncherWaiting = false;  //是否跳过启动界面的等待

    private void checkWaitingLauncerTimeFinished(){
        long duration = System.currentTimeMillis() - duartionStartTime;


        App.get().getHandler().removeCallbacks(mWaitTingLauncher);

        if(!mSkipLauncherWaiting){
            if (duration <STOP_DURATION_TIME) {
                //继续等待
                App.get().getHandler().postDelayed(mWaitTingLauncher, 100);
                return;
            }
        }
        //do something
        Log.i("MainActivity","do somethings");
        App.get().getHandler().post(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(App.get(),"5s启动" ,Toast.LENGTH_LONG).show();
            }
        });
    }

    private Runnable mWaitTingLauncher = new Runnable() {
        @Override
        public void run() {
            checkWaitingLauncerTimeFinished();
        }
    };


}
