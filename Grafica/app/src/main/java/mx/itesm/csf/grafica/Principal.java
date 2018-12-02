package mx.itesm.csf.grafica;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Principal extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);

        Button btnActividad_1 = (Button) findViewById(R.id.button);

        btnActividad_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(Principal.this,Barra.class);

                startActivity(actividad);
            }
        });

        Button btnActividad_2 = (Button) findViewById(R.id.button2);

        btnActividad_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(Principal.this,Radar.class);

                startActivity(actividad);
            }
        });
    }
}
