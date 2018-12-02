package mx.itesm.csf.video_splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Actividad1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_actividad1);

        Button btnActividad_1 = (Button) findViewById(R.id.button2);
        final EditText texto = (EditText)findViewById(R.id.editText4);
        btnActividad_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(Actividad1.this,Actividad2.class);
                actividad.putExtra("url",texto.getText().toString());
                startActivity(actividad);
            }
        });
    }
}
