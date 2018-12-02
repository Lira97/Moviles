package mx.itesm.csf.ejercicio4a;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class Principal extends AppCompatActivity {
    private final String MSG = "CicloDeVida";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);
        Log.d(MSG, "estoy dentro del metodo onCreate");

    }
    public void onStart()
    {
        super.onStart();
        Log.d(MSG,"Dentro del metodo OnStart");
    }
    public void onRestart()
    {
        super.onRestart();
        Log.d(MSG,"Dentro del metodo onRestart");
    }
    public void onResume()
    {
        super.onResume();
        new AlertDialog.Builder(this)
                .setTitle("Resume")
                .setMessage("Dentro del metodo OnResume")
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                })
                .show();
    }
    public void onPause()
    {
        super.onPause();
        Toast.makeText(this, "Dentro del metodo onPause", Toast.LENGTH_SHORT).show();
    }
    public void onStop()
    {
        super.onStop();
        Log.d(MSG,"Dentro del metodo onStop");
    }
    public void onDestroy()
    {
        super.onDestroy();
        Log.d(MSG,"Dentro del metodo onDestroy");
    }
}
