package mx.itesm.csf.tarea4;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.TextView;

import com.gc.materialdesign.views.ButtonRectangle;

public class Resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_resultado);
        final TextView Texto = (TextView) findViewById(R.id.text);
        ButtonRectangle suma = (ButtonRectangle) findViewById(R.id.button4);
        ButtonRectangle resta = (ButtonRectangle) findViewById(R.id.button9);
        ButtonRectangle multiplicacion = (ButtonRectangle) findViewById(R.id.button8);
        ButtonRectangle division = (ButtonRectangle) findViewById(R.id.button10);


        suma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                int num1 = Integer.parseInt(bundle.getString("num1"));
                int num2 = Integer.parseInt(bundle.getString("num2"));
                Texto.setText(Integer.toString(num1+num2));
            }
        });
        resta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                int num1 = Integer.parseInt(bundle.getString("num1"));
                int num2 = Integer.parseInt(bundle.getString("num2"));
                Texto.setText(Integer.toString(num1-num2));
            }
        });
        multiplicacion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                int num1 = Integer.parseInt(bundle.getString("num1"));
                int num2 = Integer.parseInt(bundle.getString("num2"));
                Texto.setText(Integer.toString(num1*num2));
            }
        });
        division.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                int num1 = Integer.parseInt(bundle.getString("num1"));
                int num2 = Integer.parseInt(bundle.getString("num2"));
                Texto.setText(Integer.toString(num1/num2));
            }
        });
    }
}
