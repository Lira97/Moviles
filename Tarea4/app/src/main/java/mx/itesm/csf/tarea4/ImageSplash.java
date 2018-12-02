package mx.itesm.csf.tarea4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class ImageSplash extends AppCompatActivity {
    private long tiempodeEspera = 2000; //milisegundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_splash);
        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent intentoPrincipal = new Intent().setClass(ImageSplash.this,LayoutMainActivity.class);
                startActivity(intentoPrincipal);
            }
        };

        Timer timer = new Timer();
        timer.schedule(tarea,tiempodeEspera);
    }
}
