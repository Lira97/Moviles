package mx.itesm.csf.almacenamientofiles;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main extends AppCompatActivity {
    EditText texto;
    static final int LEE_BLOQUE = 100;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        texto= (EditText) findViewById(R.id.editText2);
    }

    public void Guardar(View view)
    {
        String str = texto.getText().toString();
        try
        {
            FileOutputStream fOut = openFileOutput("archivo.txt",MODE_PRIVATE);
            OutputStreamWriter osw = new OutputStreamWriter(fOut);

            try{
                osw.write(str);

            }catch (IOException e)
            {
                e.printStackTrace();
            }
            osw.flush();
            osw.close();
            Toast.makeText(getBaseContext(),"archivo guardado satifactorio",Toast.LENGTH_LONG).show();
            texto.setText("");
        }catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    public void Cargar(View view)
    {
        try
        {
            FileInputStream fIn = openFileInput("archivo.txt");
            InputStreamReader isr = new InputStreamReader(fIn);
            char[] inputBuffer = new char[LEE_BLOQUE];
            String s = "";
            int charRead;
            while ((charRead = isr.read(inputBuffer))>0)
            {
                String readString = String.copyValueOf(inputBuffer,0,charRead);
                s += readString;
                inputBuffer=new char[LEE_BLOQUE];
            }
            texto.setText(s);
            Toast.makeText(getBaseContext(),"archivo cargado satifactorio",Toast.LENGTH_LONG).show();
        }catch (IOException ioe)
        {
            ioe.printStackTrace();
        }
    }
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton:
                if (checked) {


                } else {


                }

                break;
            case R.id.radioButton2:
                if (checked) {
                } else {


                }
                break;

        }
    }
}
