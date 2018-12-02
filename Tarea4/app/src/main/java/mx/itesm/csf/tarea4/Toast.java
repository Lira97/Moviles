package mx.itesm.csf.tarea4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Toast extends AppCompatActivity {
    int contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_toast);
        final Button btnActividad_1= (Button) findViewById(R.id.button2);
        btnActividad_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                android.widget.Toast.makeText(
                        btnActividad_1.getContext()
                        ,"me has pulsado"+ ++contador + " veces"
                        , android.widget.Toast.LENGTH_LONG).show();

            }
        });
    }
}
