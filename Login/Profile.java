package mx.itesm.csf.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Profile extends AppCompatActivity {

    private TextView Usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_profile);

        Usuario  = (TextView) findViewById(R.id.textViewUsuario);

        Intent intent = getIntent();

        Usuario.setText("Vista principal para el usuario " + intent.getStringExtra(Principal.USUARIO));
    }

}
