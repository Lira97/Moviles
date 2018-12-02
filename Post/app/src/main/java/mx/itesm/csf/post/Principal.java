package mx.itesm.csf.post;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class Principal extends AppCompatActivity {

    String url = "http://ubiquitous.csf.itesm.mx/~pddm-1023351/CMS/wp-json/wp/v2/posts";

    // definimos todos los componentes a utilizar
    // Gson es una librerÃ­a que permite la serializaciÃ³n y deserializaciÃ³n entre objetos Java
    // y su representaciÃ³n en notaciÃ³n JSON.

    List<Object> list;
    Gson gson;
    ProgressDialog progressDialog;
    ListView postList;
    Map<String,Object> mapPost;
    Map<String,Object> mapTitle;
    int postID;
    String postTitle[];


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);

        // Hacemos aluciÃ³n a cada elemento creado en el layout
        // creamos la barra de progreso y mostramos un mensaje
        // para despues mostrarla en la GUI
        postList = (ListView)findViewById(R.id.listaDePosts);
        progressDialog = new ProgressDialog(Principal.this);
        progressDialog.setMessage("Cargando datos...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            // Hacemos uso de la librerÃ­a Gson para conversiÃ³n de objetos
            public void onResponse(String s) {
                gson = new Gson();
                list = (List) gson.fromJson(s, List.class);
                postTitle = new String[list.size()];

                // Definimos un ciclo para poder acceder a cada uno de los elementos de la respuesta JSON del CMS
                // Para ello es mandatorio ver la respuesta y analizar que contiene quÃ© cosa
                for(int i=0;i<list.size();++i){
                    mapPost = (Map<String,Object>)list.get(i);
                    mapTitle = (Map<String, Object>) mapPost.get("title");
                    postTitle[i] = (String) mapTitle.get("rendered");
                }

                // Definimos un adaptador para cuando un das click a un elemento
                postList.setAdapter(new ArrayAdapter(Principal.this,android.R.layout.simple_list_item_1,postTitle));
                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            @Override
            // Enviamos un mensaje de error si algo paso
            public void onErrorResponse(VolleyError volleyError) {
                Toast.makeText(Principal.this, "Algo pasÃ³ y hay un error", Toast.LENGTH_LONG).show();
            }
        });


        // Creamos un objeto de clase RequestQueue de Volley
        RequestQueue rQueue = Volley.newRequestQueue(Principal.this);
        rQueue.add(request);

        postList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                mapPost = (Map<String,Object>)list.get(position);
                postID = ((Double)mapPost.get("id")).intValue();

                Intent intent = new Intent(getApplicationContext(),Post.class);
                intent.putExtra("id", ""+postID);
                startActivity(intent);
            }
        });



    }
}