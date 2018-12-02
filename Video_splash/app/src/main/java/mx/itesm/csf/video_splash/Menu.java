package mx.itesm.csf.video_splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_menu);
        Button btnActividad_1 = (Button) findViewById(R.id.button6);
        Button btnActividad_2 = (Button) findViewById(R.id.button5);
        Button btnActividad_3 = (Button) findViewById(R.id.button7);
        btnActividad_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(Menu.this,Actividad1.class);
                startActivity(actividad);
            }
        });

        btnActividad_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(Menu.this,Actividad2.class);
                startActivity(actividad);
            }
        });

        btnActividad_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(Menu.this,Actividad3.class);
                startActivity(actividad);
            }
        });

    }
}
