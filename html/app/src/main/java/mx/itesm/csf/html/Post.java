package mx.itesm.csf.html;

import android.app.ProgressDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;

import java.util.Map;

public class Post extends AppCompatActivity {

    // definimos todos los componentes a utilizar
    // Gson es una librerÃ­a que permite la serializaciÃ³n y deserializaciÃ³n entre objetos Java
    // y su representaciÃ³n en notaciÃ³n JSON.
    TextView titulo;
    WebView contenido;
    ProgressDialog progressDialog;
    Gson gson;
    Map<String, Object> mapaPost;   // ver respuesta json del API del CMS
    Map<String, Object> mapaTitulo;
    Map<String, Object> mapaContenido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // llamada al layout
        setContentView(R.layout.layout_post);

        // obtenciÃ³n del id que noes envÃ­a la actividad principal
        final String id = getIntent().getExtras().getString("id");

        // definimos componentes de interfaz a los elementos donde queremos
        // mostrar la informaciÃ³n en el layout
        titulo = (TextView) findViewById(R.id.titulo);
        contenido = (WebView)findViewById(R.id.contenido);

        // creamos el progressDialogo para mostrar una mensaje el usuario mientras se descargan
        // los datos
        progressDialog = new ProgressDialog(Post.this);
        progressDialog.setMessage("Cargando datos...");
        progressDialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        progressDialog.show();

        // definimos la url pero ahora filtrando datos
        String url = "http://ubiquitous.csf.itesm.mx/~raulms/CMS/wp-json/wp/v2/posts/"+id+"?fields=title,content";

        // hacemos una peticiÃ³n GET
        StringRequest request = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {

                // creamos los mapas correspondientes
                // pasamos de la cadena JSON a nuestro objeto map
                gson = new Gson();
                mapaPost = (Map<String, Object>) gson.fromJson(s, Map.class);
                mapaTitulo = (Map<String, Object>) mapaPost.get("title");
                mapaContenido = (Map<String, Object>) mapaPost.get("content");

                // accedemos a los datos utilizando el atributo rendered de la respuesta JSON
                // y lo trasformamos a un elemento de tipo HTML con tipo de codificacion utf-8
                titulo.setText(mapaTitulo.get("rendered").toString());
                contenido.loadData(mapaContenido.get("rendered").toString(),"text/html","UTF-8");

                progressDialog.dismiss();
            }
        }, new Response.ErrorListener() {
            // manejamos los errores y los desplegamos en un toast
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                progressDialog.dismiss();
                Toast.makeText(Post.this, id, Toast.LENGTH_LONG).show();
            }
        });

        // desplegamos el request
        RequestQueue rQueue = Volley.newRequestQueue(Post.this);
        rQueue.add(request);
    }
}