package mx.itesm.csf.tarea6;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;


public class Opcion1 extends Fragment
{
    String[] marcas={"Mazda","Toyota","Honda","Ford","Acura","Mini","BMW","Mercedes Benz","Baic","Kia","Jeep","Land Rover","Jaguar","GMC","Audi"};

    public static Opcion1 newInstance()
    {
        Opcion1 fragment = new Opcion1();
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_opcion1, container, false);
        AutoCompleteTextView textView = (AutoCompleteTextView) rootView.findViewById(R.id.autoCompleteTextView3);
        ArrayAdapter<String> adapter =  new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, marcas);
        textView.setThreshold(2);
        textView.setAdapter(adapter);

        return rootView;

    }


}

