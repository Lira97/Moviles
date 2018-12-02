package mx.itesm.csf.materialdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.gc.materialdesign.views.ButtonRectangle;

public class Actividad2 extends AppCompatActivity {

    public void btnGuardar(View view)
    {
        DespliegaToast("guardar");
    }
    public void btnAbrir(View view)
    {
        DespliegaToast("abrir");
    }
    public void imageBut(View view)
    {
        DespliegaToast("imageButton");
    }
    public void textedit(View view)
    {
        final EditText texto = (EditText)findViewById(R.id.editText);
        DespliegaToast(texto.getText().toString());
    }
    public void checkbox(View view)
    {
        DespliegaToast("checkbox");
    }
    public void start1(View view)
    {
        DespliegaToast("start1");
    }
    public void radio1(View view)
    {
        DespliegaToast("radio1");
    }
    public void radio2(View view)
    {
        DespliegaToast("radio2");
    }
    public void toggle(View view)
    {
        DespliegaToast("toggle");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_actividad2);

    }
    private void DespliegaToast(String msg)
    {
        Toast.makeText(getBaseContext(),msg,Toast.LENGTH_LONG).show();
    }
}
