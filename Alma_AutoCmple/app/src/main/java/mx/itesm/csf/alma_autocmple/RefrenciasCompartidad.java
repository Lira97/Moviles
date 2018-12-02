package mx.itesm.csf.alma_autocmple;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RefrenciasCompartidad extends AppCompatActivity {
    private EditText textfield,textfield2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_refrencias_compartidad);

        textfield = findViewById(R.id.editText);
        textfield2 = findViewById(R.id.editText2);
    }
    public void guardar(View v)
    {
        String nombre = textfield.getText().toString();
        String contacto = textfield2.getText().toString();
        SharedPreferences preferencias = getSharedPreferences("crm", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferencias.edit();
        editor.putString(nombre,contacto);
        editor.commit();
        Toast.makeText(this,"Datos de contacto guardados",Toast.LENGTH_LONG).show();

    }
    public void recuperar(View v)
    {
        String nombre = textfield.getText().toString();
        SharedPreferences preferencias = getSharedPreferences("crm", Context.MODE_PRIVATE);
        String datos = preferencias.getString(nombre,"");
        if(datos.length()==0)
        {
            Toast.makeText(this,"Datos de contacto guardados",Toast.LENGTH_LONG).show();
        }
        else
        {
            textfield2.setText(datos);
        }
    }
}
