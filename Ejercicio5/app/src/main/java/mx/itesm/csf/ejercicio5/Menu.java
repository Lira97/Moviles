package mx.itesm.csf.ejercicio5;

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

        Button btnActividad_1 = (Button) findViewById(R.id.button1);
        Button btnActividad_2 = (Button) findViewById(R.id.button2);
        Button btnActividad_3 = (Button) findViewById(R.id.button3);
        btnActividad_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(Menu.this,Actividad3.class);
                startActivity(actividad);
            }
        });

        btnActividad_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(Menu.this,Activividad4.class);
                startActivity(actividad);
            }
        });

        btnActividad_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(Menu.this,Actividad5.class);
                startActivity(actividad);
            }
        });
    }
}
