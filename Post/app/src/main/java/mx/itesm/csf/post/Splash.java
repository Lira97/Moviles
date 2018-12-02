package mx.itesm.csf.post;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class Splash extends AppCompatActivity {

    private long tiempo = 2000; // Miliseconds

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_splash);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent intent = new Intent().setClass(Splash.this, list.class);
                startActivity(intent);
            }
        };
        Timer timer = new Timer();
        timer.schedule(tarea, tiempo);
    }
}
