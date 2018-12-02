package mx.itesm.csf.ejerciciovolley;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class Principal extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);
    }

    // creamos la función a ejecutar cuando se oprima el botón en la GUI
    public void enviarPeticion(View view) {
        // mapeamos el componente a utilizar en la GUI
        final TextView textView = (TextView)findViewById(R.id.textView);
        // creamos una cola de volley
        RequestQueue queue = Volley.newRequestQueue(this);
        // definimos la url a donde vamos a realizar la petición
        String url ="http://ubiquitous.csf.itesm.mx";
        // creamos el request de volley utilizando el método GET para
        // anexarlo a la cola
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    // solo hacemos una reuquest a un string
                    // y desplegamos sólo 500 caracteres
                    @Override
                    public void onResponse(String response) {
                        textView.setText(response.substring(0,500));
                    }
                }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText("onErrorResponse(): "+ error.getMessage());
            }
        });

        // agragamos la petición a la cola
        queue.add(stringRequest);
    }
}
