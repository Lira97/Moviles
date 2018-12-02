package mx.itesm.csf.tarea4;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Promedio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_promedio);

        Button btnActividad_1 = (Button) findViewById(R.id.button12);
        final TextView texto = (TextView) findViewById(R.id.textView2);
        final EditText resultado = (EditText)findViewById(R.id.editText3);
        btnActividad_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a = Integer.parseInt(resultado.getText().toString());

                if(a >= 10 && a <= 70 )
                {
                    texto.setText("MALO");
                }
                else if(a >= 70 && a <= 80 )
                {
                    texto.setText("REGULAR");
                }
                else if(a >= 70 && a <= 80 )
                {
                    texto.setText("REGULAR");
                }
                else if(a >= 81 && a <= 94 )
                {
                    texto.setText("BUENO");
                }
                else if(a >= 95 && a <= 100 )
                {
                    texto.setText("EXCELENTE");
                }
                else
                {
                    texto.setText("NUMERO INVALIDO");
                }

            }
        });
    }
}
