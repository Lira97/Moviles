package mx.itesm.csf.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;


public class Login extends AppCompatActivity implements View.OnClickListener {

    private static final String SERVICIO_REGISTRO = "http://ubiquitous.csf.itesm.mx/~raulms/content/TC2024/Modulo_II/Servicios/Minisistema/servicio.registro.php";

    public static final String USUARIO = "usuario";
    public static final String PASSWORD = "password";
    public static final String EMAIL = "email";

    private EditText editTextUsuario;
    private EditText editTextPassword;
    private EditText editTextEmail;

    private Button botonRegistro;
    private Button botonAcceder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_login);

        editTextUsuario = (EditText) findViewById(R.id.editTextUsuario);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);
        editTextEmail= (EditText) findViewById(R.id.editTextEmail);

        botonRegistro = (Button) findViewById(R.id.botonRegistro);
        botonAcceder = (Button) findViewById(R.id.botonAcceder);


        botonRegistro.setOnClickListener(this);
        botonAcceder.setOnClickListener(this);
    }


    private void registrarUsuario() {

        final String usuario = editTextUsuario.getText().toString().trim();
        final String password = editTextPassword.getText().toString().trim();
        final String email = editTextEmail.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, SERVICIO_REGISTRO,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Toast.makeText(Login.this,response,Toast.LENGTH_LONG).show();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Login.this,error.toString(),Toast.LENGTH_LONG).show();
                    }
                }){
            @Override
            protected Map<String,String> getParams(){
                Map<String,String> params = new HashMap<String, String>();
                params.put(USUARIO,usuario);
                params.put(PASSWORD,password);
                params.put(EMAIL, email);
                return params;
            }

        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }


    @Override
    public void onClick(View v) {
        if(v == botonRegistro) {
            registrarUsuario();
        }
        if(v == botonAcceder){
            startActivity(new Intent(this,Principal.class));
        }
    }
}