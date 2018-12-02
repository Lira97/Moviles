package mx.itesm.csf.tarea4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.gc.materialdesign.views.ButtonRectangle;

public class Calculadora extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_calculadora);
        ButtonRectangle btnActividad_1 = (ButtonRectangle) findViewById(R.id.button3);
        final EditText num = (EditText)findViewById(R.id.editText4);
        final EditText num2 = (EditText)findViewById(R.id.editText5);
        btnActividad_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(Calculadora.this,Resultado.class);
                actividad.putExtra("num1",num.getText().toString());
                actividad.putExtra("num2",num2.getText().toString());
                startActivity(actividad);
            }
        });
    }
}
