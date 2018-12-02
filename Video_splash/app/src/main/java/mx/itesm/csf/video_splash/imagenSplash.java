package mx.itesm.csf.video_splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.Timer;
import java.util.TimerTask;

public class imagenSplash extends AppCompatActivity {

    private long tiempodeEspera = 3000; //milisegundos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_imagen_splash);

        TimerTask tarea = new TimerTask() {
            @Override
            public void run() {
                finish();
                Intent intentoPrincipal = new Intent().setClass(imagenSplash.this,Video.class);
                startActivity(intentoPrincipal);
            }
        };

        Timer timer = new Timer();
        timer.schedule(tarea,tiempodeEspera);
    }
}
