package mx.itesm.csf.tarea6;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Opcion2 extends Fragment {
    private Context mContext;
    private EditText textfield,textfield2;
    public static Opcion2 newInstance() {
        Opcion2 fragment = new Opcion2();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        this.mContext = getContext();
        View rootView = inflater.inflate(R.layout.fragment_opcion2, container, false);
        textfield = rootView.findViewById(R.id.editText);
        textfield2 = rootView.findViewById(R.id.editText2);
        Button button = (Button) rootView.findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String nombre = textfield.getText().toString();
                String contacto = textfield2.getText().toString();
                SharedPreferences preferencias = mContext.getSharedPreferences("crm", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString(nombre,contacto);
                editor.commit();
                Toast.makeText(getActivity(),"Datos de contacto guardados",Toast.LENGTH_LONG).show();
            }
        });
        Button button2 = (Button) rootView.findViewById(R.id.button4);
        button2.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                String nombre = textfield.getText().toString();
                SharedPreferences preferencias = mContext.getSharedPreferences("crm", Context.MODE_PRIVATE);
                String datos = preferencias.getString(nombre,"");
                if(datos.length()==0)
                {
                    Toast.makeText(getActivity(),"Datos de contacto guardados",Toast.LENGTH_LONG).show();
                }
                else
                {
                    textfield2.setText(datos);
                }
            }
        });
        return rootView;
    }


}