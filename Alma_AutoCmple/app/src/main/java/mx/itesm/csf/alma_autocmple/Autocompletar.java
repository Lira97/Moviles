package mx.itesm.csf.alma_autocmple;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class Autocompletar extends AppCompatActivity {
    String[] marcas={"Mazda","Toyota","Honda","Ford","Acura","Mini","BMW","Mercedes Benz","Baic","Kia","Jeep","Land Rover","Jaguar","GMC","Audi"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_autocompletar);
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,android.R.layout.simple_dropdown_item_1line,marcas);

        AutoCompleteTextView textView = (AutoCompleteTextView)findViewById(R.id.autoCompleteTextView3);

        textView.setThreshold(2);
        textView.setAdapter(adaptador);
    }
}
