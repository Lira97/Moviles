package mx.itesm.csf.almacenamientosqlite;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Principal extends AppCompatActivity {

    AdaptadorDB adaptador = new AdaptadorDB(this);
    EditText name,paterno,materno,email,phone;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);
        name = findViewById(R.id.editText3);
        paterno = findViewById(R.id.editText4);
        materno = findViewById(R.id.editText7);
        email = findViewById(R.id.editText5);
        phone = findViewById(R.id.editText6);

        // #################### INSERT ########################################

        //--- Angregamos clientes ---
        //adaptador.open();
        //String nombre, String email,String apellidoPaterno,String apellidoMaterno,String telefono
        //long id = adaptador.insertaClientes("Raúl", "raulms@itesm.mx","Morales","Salcedo","123376543");
        //id = adaptador.insertaClientes("Felipe Calderón Hinojosa", "calderon@presidencia.com");
        //adaptador.close();



        // ##################### SELECT #######################################
        /*
        //-- Obtenemos todos los clientes ---
        adaptador.open();
        Cursor c = adaptador.obtenTodosLosClientes();
        if (c.moveToFirst())
        {
            do {
                DespliegaCliente(c);
            } while (c.moveToNext());
        }
        adaptador.close();
        */

        /*
        // #################### SELECT ########################################
        //--- Obtenemos un cliente ---
        adaptador.open();
        Cursor c = adaptador.obtieneUnCliente(2);
        if (c.moveToFirst())
            DespliegaCliente(c);
        else
            Toast.makeText(this, "No se ha encontrado al cliente", Toast.LENGTH_LONG).show();
        adaptador.close();

*/
        // ##################### UPDATE #######################################
        /*
        //--- Actualiza un cliente ---
        adaptador.open();
        if (adaptador.actualizaCliente(2, "Andrés Manuelovich", "elpeje@presidencia.com"))
            Toast.makeText(this, "Actualización exitosa!.", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Falló la actualización del registro.", Toast.LENGTH_LONG).show();
        adaptador.close();
        */

        // ###################### DELETE ######################################

        //--- Borra un cliente ---
        /*
        adaptador.open();
        if (adaptador.borraCliente(2))
            Toast.makeText(this, "Registro eliminado exitosamente.", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Falló al eliminar registro.", Toast.LENGTH_LONG).show();
        adaptador.close();


        try {
            String destPath = "/data/data/" + getPackageName() +
                    "/basesdedatos";
            File f = new File(destPath);
            if (!f.exists()) {
                f.mkdirs();
                f.createNewFile();

                //--- copiamos la db del directorio assets al directorio
                // final de ls db ---
                CopyDB(getBaseContext().getAssets().open("CRM"),
                        new FileOutputStream(destPath + "/CRM"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }


*/
        // ####################### SELECT *  #####################################
        //--- Obtenemos todos los clientes ---
       /* adaptador.open();
        Cursor c = adaptador.obtenTodosLosClientes();
        if (c.moveToFirst())
        {
            do {
                DespliegaCliente(c);
            } while (c.moveToNext());
        }
        adaptador.close();*/
    }
    public void Insertar(View view)
    {
        adaptador.open();
        //String nombre, String email,String apellidoPaterno,String apellidoMaterno,String telefono
        long id = adaptador.insertaClientes(name.getText().toString(),email.getText().toString(),paterno.getText().toString(),materno.getText().toString(),phone.getText().toString());
        //id = adaptador.insertaClientes("Felipe Calderón Hinojosa", "calderon@presidencia.com");
        adaptador.close();
    }
    public void actualizar(View view)
    {
        adaptador.open();
        if (adaptador.actualizaCliente('"' + name.getText().toString()+'"','"' +email.getText().toString()+'"','"' +paterno.getText().toString()+'"','"' +materno.getText().toString()+'"','"' +phone.getText().toString()+'"'))
            Toast.makeText(this, "Actualización exitosa!.", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Falló la actualización del registro.", Toast.LENGTH_LONG).show();
        adaptador.close();

    }

    public void Delete(View view)
    {
        adaptador.open();
        if (adaptador.borraCliente('"' + name.getText().toString() +'"' ))
            Toast.makeText(this, "Registro eliminado exitosamente.", Toast.LENGTH_LONG).show();
        else
            Toast.makeText(this, "Falló al eliminar registro.", Toast.LENGTH_LONG).show();
        adaptador.close();


        try {
            String destPath = "/data/data/" + getPackageName() +
                    "/basesdedatos";
            File f = new File(destPath);
            if (!f.exists()) {
                f.mkdirs();
                f.createNewFile();

                //--- copiamos la db del directorio assets al directorio
                // final de ls db ---
                CopyDB(getBaseContext().getAssets().open("CRM"),
                        new FileOutputStream(destPath + "/CRM"));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void ver(View view)
    {
        adaptador.open();
        Cursor c = adaptador.obtieneUnCliente('"' + name.getText().toString() +'"');
        if (c.moveToFirst())
            DespliegaCliente(c);
        else
            //Toast.makeText(this, "No se ha encontrado al cliente", Toast.LENGTH_LONG).show();
            adaptador.close();
    }

    public void CopyDB(InputStream inputStream,
                       OutputStream outputStream) throws IOException {
        //--- Copiamos 1K bytes poco a poco ---
        byte[] buffer = new byte[1024];
        int length;
        while ((length = inputStream.read(buffer)) > 0) {
            outputStream.write(buffer, 0, length);
        }
        inputStream.close();
        outputStream.close();
    }

    // ########################### TOAST #################################
    public void DespliegaCliente(Cursor c)
    {
        Toast.makeText(this,
                "id: " + c.getString(0) + "\n" +
                        "Nombre: " + c.getString(1) + "\n" +
                        "Email:  " + c.getString(2)+ "\n" +
                        "apellidoPaterno:  " + c.getString(3)+ "\n" +
                        "apellidoMaterno:  " + c.getString(4)+ "\n" +
                        "telefono:  " + c.getString(5),
                Toast.LENGTH_LONG).show();

    }
}
