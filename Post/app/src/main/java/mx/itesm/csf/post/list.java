package mx.itesm.csf.post;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.List;
import java.util.Map;

public class list extends AppCompatActivity {

    ListView categoryList;
    List<Object> list;
    Gson gson;
    ProgressDialog progressDialog;
    Map<String,Object> mapPost;
    Map<String,Object> mapTitle;
    int categoryID;
    String postTitle[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_list);

        String url = "http://ubiquitous.csf.itesm.mx/~pddm-1023351/CMS/wp-json/wp/v2/categories";

        // Hacemos alucion a cada elemento creado en el layout
        // creamos la barra de progreso y mostramos un mensaje
        // para despues mostrarla en la GUI
        categoryList = (ListView)findViewById(R.id.listaDeCategorias);
        progressDialog = new ProgressDialog(list.this);
        progressDialog.setMessage("Cargando datos...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        // Definimos el metodo GET para la peticion http utilizando la url definida al principio
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            // Hacemos uso de la libreria Gson para conversion de objetos
            public void onResponse(String s) {
                gson = new Gson();
                list = (List) gson.fromJson(s, List.class);
                postTitle = new String[list.size()];

                // Definimos un ciclo para poder acceder a cada uno de los elementos de la respuesta JSON del CMS
                // Para ello es mandatorio ver la respuesta y analizar que contiene que cosa
                for(int i=0;i<list.size();++i){
                    mapPost = (Map<String,Object>)list.get(i);
                    postTitle[i] = (String) mapPost.get("name");
                }

                // Definimos un adaptador para cuando un das click a un elemento
                categoryList.setAdapter(new ArrayAdapter(list.this,android.R.layout.simple_list_item_1,postTitle));
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            // Enviamos un mensaje de error si algo paso
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(list.this, "Error: " + volleyError, Toast.LENGTH_LONG).show();
            }
        });


        // Creamos un objeto de clase RequestQueue de Volley
        RequestQueue rQueue = Volley.newRequestQueue(list.this);
        rQueue.add(request);

        categoryList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mapPost = (Map<String,Object>)list.get(position);
                categoryID = ((Double)mapPost.get("id")).intValue();

                Intent intent = new Intent(getApplicationContext(),Principal.class);
                intent.putExtra("category", ""+categoryID);
                startActivity(intent);
            }
        });

    }
}
