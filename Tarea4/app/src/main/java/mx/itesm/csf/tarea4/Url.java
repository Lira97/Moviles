package mx.itesm.csf.tarea4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Url extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_url);

        Button btnActividad_1 = (Button) findViewById(R.id.buttonURL);
        final EditText texto = (EditText)findViewById(R.id.editText);
        btnActividad_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(Url.this,Actividad2.class);
                actividad.putExtra("url",texto.getText().toString());
                startActivity(actividad);
            }
        });
    }
}
