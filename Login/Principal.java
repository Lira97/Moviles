package mx.itesm.csf.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class Principal extends AppCompatActivity implements View.OnClickListener {

    public static final String SERVICIO_LOGIN = "http://ubiquitous.csf.itesm.mx/~raulms/content/TC2024/Modulo1/Servicios/Login1/servicio.login.php";

    public static final String USUARIO  = "usuario";
    public static final String PASSWORD = "password";

    private EditText editTextUsuario;
    private EditText editTextPassword;

    private Button botonAcceder;

    private String usuario;
    private String password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);

        editTextUsuario = (EditText) findViewById(R.id.editTextUsuario);
        editTextPassword = (EditText) findViewById(R.id.editTextPassword);

        botonAcceder = (Button) findViewById(R.id.botonAcceder);

        botonAcceder.setOnClickListener(this);
    }


    private void usuarioLogin() {

        usuario = editTextUsuario.getText().toString().trim();
        password = editTextPassword.getText().toString().trim();

        StringRequest stringRequest = new StringRequest(Request.Method.POST, SERVICIO_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        if(response.trim().equals("Acceso")){
                            Profile();
                        }else{
                            Toast.makeText(Principal.this,response,Toast.LENGTH_LONG).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(Principal.this,error.toString(),Toast.LENGTH_LONG ).show();
                    }
                }){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String,String> map = new HashMap<String,String>();
                map.put(USUARIO,usuario);
                map.put(PASSWORD,password);
                return map;
            }
        };

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        requestQueue.add(stringRequest);
    }

    private void Profile(){
        Intent intent = new Intent(Principal.this, Profile.class);
        intent.putExtra(USUARIO, usuario);
        startActivity(intent);
    }

    public void onClick(View v) {
        usuarioLogin();
    }

}


