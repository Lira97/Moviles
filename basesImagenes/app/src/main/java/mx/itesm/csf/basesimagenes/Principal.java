package mx.itesm.csf.basesimagenes;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Hashtable;
import java.util.Map;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    private Button botonEscoger;
    private Button botonSubir;
    private ImageView imageView;
    private EditText editarNombre;
    private Bitmap bitmap;
    private int SOLICITAR_REQUEST = 1;
    private String MICROSERVICIO = "http://ubiquitous.csf.itesm.mx/~pddm-1023351/content/parcial2/Subir/subir.php";
    private String LLAVE_IMAGEN = "imagen";
    private String LLAVE_NOMBRE = "nombre";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);

        botonEscoger = (Button) findViewById(R.id.Seleccionar);
        botonSubir = (Button) findViewById(R.id.Subir);
        editarNombre = (EditText) findViewById(R.id.editText);
        imageView = (ImageView) findViewById(R.id.imageView);

        botonEscoger.setOnClickListener(this);
        botonSubir.setOnClickListener(this);
    }

    public String obtieneNombreImagen(Bitmap mapadebits) {
        ByteArrayOutputStream imagen = new ByteArrayOutputStream();
        mapadebits.compress(Bitmap.CompressFormat.JPEG, 100, imagen);
        byte[] imageBytes = imagen.toByteArray();
        String imagenEncodeada = Base64.encodeToString(imageBytes, Base64.DEFAULT);
        return imagenEncodeada;
    }

    private void subirImagen() {
        // Mostramos una barra de progreso
        final ProgressDialog cargadno = ProgressDialog.show(this, "Subiendo imagen...", "Subiendo...", false, false);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, MICROSERVICIO,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String s) {
                        // Cerramos la barra de progreso
                        cargadno.dismiss();
                        // Mostramos un mensaje como respuesta
                        Toast.makeText(Principal.this, s, Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        // Cerramos el dialogo de la barra de progreso
                        cargadno.dismiss();

                        // Monstramos el mensaje de error
                        Toast.makeText(Principal.this, volleyError.getMessage().toString(), Toast.LENGTH_LONG).show();
                    }
                }) {


            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                // Convertimos un Bitmap a un string de datos
                String imagen = obtieneNombreImagen(bitmap);

                // Obtenemos el nombre de la imagen
                String nombre = editarNombre.getText().toString().trim();

                // Creamos un mapa para los parametros
                Map<String, String> params = new Hashtable<String, String>();

                // Le enexamos los parametros
                params.put(LLAVE_IMAGEN, imagen);
                params.put(LLAVE_NOMBRE, nombre);

                // regresamos los parametros
                return params;
            }
        };

        // Usamos Volley para crear la cola de peticiones
        RequestQueue requestQueue = Volley.newRequestQueue(this);

        // Anexamos el request a la cola
        requestQueue.add(stringRequest);
    }

    // mÃ©todo para mostrar la imagen
    private void mostrarImagen() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent, "Selecione la imagen"), SOLICITAR_REQUEST);
    }

    @Override
    protected void onActivityResult(int codigoDeSolicitud, int codigoDeResultado, Intent datos) {
        super.onActivityResult(codigoDeSolicitud, codigoDeResultado, datos);

        if (codigoDeSolicitud == SOLICITAR_REQUEST && codigoDeResultado == RESULT_OK && datos != null && datos.getData() != null) {
            Uri filePath = datos.getData();
            try {
                //Getting the Bitmap from Gallery
                bitmap = MediaStore.Images.Media.getBitmap(getContentResolver(), filePath);
                //Setting the Bitmap to ImageView
                imageView.setImageBitmap(bitmap);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void onClick(View v) {

        if (v == botonEscoger) {
            mostrarImagen();
        }

        if (v == botonSubir) {
            subirImagen();
        }
    }
}