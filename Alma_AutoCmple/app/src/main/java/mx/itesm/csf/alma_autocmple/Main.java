package mx.itesm.csf.alma_autocmple;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Main extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
        Button btnActividad_1 = (Button) findViewById(R.id.button2);
        Button btnActividad_2 = (Button) findViewById(R.id.button3);

        btnActividad_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(Main.this,Autocompletar.class);
                startActivity(actividad);
            }
        });

        btnActividad_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(Main.this,RefrenciasCompartidad.class);
                startActivity(actividad);
            }
        });

    }
}
