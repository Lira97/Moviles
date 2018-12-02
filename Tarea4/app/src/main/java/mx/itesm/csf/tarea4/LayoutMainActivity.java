package mx.itesm.csf.tarea4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class LayoutMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        Button btnActividad_1 = (Button) findViewById(R.id.button5);
        Button btnActividad_2 = (Button) findViewById(R.id.button6);
        Button btnActividad_3 = (Button) findViewById(R.id.button7);
        Button btnActividad_4 = (Button) findViewById(R.id.button11);
        btnActividad_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(LayoutMainActivity.this,Toast.class);
                startActivity(actividad);
            }
        });

        btnActividad_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(LayoutMainActivity.this,Url.class);
                startActivity(actividad);
            }
        });

        btnActividad_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(LayoutMainActivity.this,Calculadora.class);
                startActivity(actividad);
            }
        });
        btnActividad_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(LayoutMainActivity.this,Promedio.class);
                startActivity(actividad);
            }
        });
    }
}
