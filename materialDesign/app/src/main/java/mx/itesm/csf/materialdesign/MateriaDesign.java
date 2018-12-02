package mx.itesm.csf.materialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import com.gc.materialdesign.views.ButtonRectangle;

public class MateriaDesign extends AppCompatActivity {
    int contador;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_materia_design);

        final ButtonRectangle btnActividad_1 = (ButtonRectangle) findViewById(R.id.button);
        btnActividad_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent actividad = new Intent(MateriaDesign.this,Actividad2.class);
                Toast.makeText(
                        btnActividad_1.getContext()
                        ,"me has pulsado"+ ++contador + " veces"
                        ,Toast.LENGTH_LONG).show();

                startActivity(actividad);

            }
        });
    }
}
