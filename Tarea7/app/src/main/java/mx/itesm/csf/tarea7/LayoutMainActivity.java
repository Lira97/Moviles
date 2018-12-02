package mx.itesm.csf.tarea7;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

public class LayoutMainActivity extends AppCompatActivity {
    private EditText texto1, texto2, texto3, texto4, texto5, texto6, texto7, texto8, texto9, texto10, texto11, texto12, texto13, texto14, texto15, texto16, texto17, texto18, texto19, texto20, texto21, texto22, texto23, texto24, texto25, texto26, texto27, texto28, texto29, texto30;
    String Message;
    private TextView txtView;


    private static final String LOG_TAG_EXTERNAL_STORAGE = "EXTERNAL_STORAGE";

    private static final int REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        txtView = (TextView) findViewById(R.id.textView3);

        texto1 = (EditText) findViewById(R.id.editText);
        texto2 = (EditText) findViewById(R.id.editText3);
        texto3 = (EditText) findViewById(R.id.editText4);
        texto4 = (EditText) findViewById(R.id.editText5);
        texto5 = (EditText) findViewById(R.id.editText6);
        texto6 = (EditText) findViewById(R.id.editText7);
        texto7 = (EditText) findViewById(R.id.editText8);
        texto8 = (EditText) findViewById(R.id.editText9);
        texto9 = (EditText) findViewById(R.id.editText10);
        texto10 = (EditText) findViewById(R.id.editText11);
        texto11 = (EditText) findViewById(R.id.editText12);
        texto12 = (EditText) findViewById(R.id.editText13);
        texto13 = (EditText) findViewById(R.id.editText14);
        texto14 = (EditText) findViewById(R.id.editText15);
        texto15 = (EditText) findViewById(R.id.editText16);
        texto16 = (EditText) findViewById(R.id.editText17);
        texto17 = (EditText) findViewById(R.id.editText18);
        texto18 = (EditText) findViewById(R.id.editText19);
        texto19 = (EditText) findViewById(R.id.editText20);
        texto20 = (EditText) findViewById(R.id.editText21);
        texto21 = (EditText) findViewById(R.id.editText22);
        texto22 = (EditText) findViewById(R.id.editText23);
        texto23 = (EditText) findViewById(R.id.editText24);
        texto24 = (EditText) findViewById(R.id.editText25);
        texto25 = (EditText) findViewById(R.id.editText26);
        texto26 = (EditText) findViewById(R.id.editText27);
        texto27 = (EditText) findViewById(R.id.editText28);
        texto28 = (EditText) findViewById(R.id.editText29);
        texto29 = (EditText) findViewById(R.id.editText30);
        texto30 = (EditText) findViewById(R.id.editText31);


    }


    public void write(View view) {
        try {
            if (ExternalStorageUtil.isExternalStorageMounted()) {

                // Check whether this app has write external storage permission or not.
                int writeExternalStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                // If do not grant write external storage permission.
                if (writeExternalStoragePermission != PackageManager.PERMISSION_GRANTED) {
                    // Request user to grant write external storage permission.
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION);
                } else {

                    // Save email_public.txt file to /storage/emulated/0/DCIM folder
                    String publicDcimDirPath = ExternalStorageUtil.getPublicExternalStorageBaseDir(Environment.DIRECTORY_DCIM);

                    File newFile = new File(publicDcimDirPath, "data.txt");

                    FileWriter fw = new FileWriter(newFile);

                    fw.write(texto1.getText().toString()+"\n");
                    fw.write(texto2.getText().toString()+"\n");
                    fw.write(texto3.getText().toString()+"\n");
                    fw.write(texto4.getText().toString()+"\n");
                    fw.write(texto5.getText().toString()+"\n");
                    fw.write(texto6.getText().toString()+"\n");
                    fw.write(texto7.getText().toString()+"\n");
                    fw.write(texto8.getText().toString()+"\n");
                    fw.write(texto9.getText().toString()+"\n");
                    fw.write(texto10.getText().toString()+"\n");
                    fw.write(texto11.getText().toString()+"\n");
                    fw.write(texto12.getText().toString()+"\n");
                    fw.write(texto13.getText().toString()+"\n");
                    fw.write(texto14.getText().toString()+"\n");
                    fw.write(texto15.getText().toString()+"\n");
                    fw.write(texto16.getText().toString()+"\n");
                    fw.write(texto17.getText().toString()+"\n");
                    fw.write(texto18.getText().toString()+"\n");
                    fw.write(texto19.getText().toString()+"\n");
                    fw.write(texto20.getText().toString()+"\n");
                    fw.write(texto21.getText().toString()+"\n");
                    fw.write(texto22.getText().toString()+"\n");
                    fw.write(texto23.getText().toString()+"\n");
                    fw.write(texto24.getText().toString()+"\n");
                    fw.write(texto25.getText().toString()+"\n");
                    fw.write(texto26.getText().toString()+"\n");
                    fw.write(texto27.getText().toString()+"\n");
                    fw.write(texto28.getText().toString()+"\n");
                    fw.write(texto29.getText().toString()+"\n");
                    fw.write(texto30.getText().toString()+"\n");

                    fw.flush();

                    fw.close();

                    Toast.makeText(getApplicationContext(), "Save to public external storage success. File Path " + newFile.getAbsolutePath(), Toast.LENGTH_LONG).show();
                }
            }

        } catch (Exception ex) {
            Log.e(LOG_TAG_EXTERNAL_STORAGE, ex.getMessage(), ex);

            Toast.makeText(getApplicationContext(), "Save to public external storage failed. Error message is " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    public void read(View view) {
        try {
            if (ExternalStorageUtil.isExternalStorageMounted()) {

                // Check whether this app has write external storage permission or not.
                int writeExternalStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);
                // If do not grant write external storage permission.
                if (writeExternalStoragePermission != PackageManager.PERMISSION_GRANTED) {
                    // Request user to grant write external storage permission.
                    ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION);
                }
                else
                    {

                    String publicDcimDirPath = ExternalStorageUtil.getPublicExternalStorageBaseDir(Environment.DIRECTORY_DCIM);

                    File newFile = new File(publicDcimDirPath, "data.txt");
                    FileInputStream fIn = new FileInputStream(newFile);
                    BufferedReader myReader = new BufferedReader(new InputStreamReader(fIn));
                    String aDataRow = "";
                    String aBuffer = "";
                    while ((aDataRow = myReader.readLine()) != null) {
                        aBuffer += aDataRow + "\n";
                    }
                   // texto1.setText(aBuffer);
                    txtView.setText(aBuffer);
                    myReader.close();
                    Toast.makeText(getBaseContext(),
                                "Se leyo de la tarajeta SD",
                                Toast.LENGTH_SHORT).show();

                }
            }

        } catch (Exception ex) {
            Log.e(LOG_TAG_EXTERNAL_STORAGE, ex.getMessage(), ex);

            Toast.makeText(getApplicationContext(), "Save to public external storage failed. Error message is " + ex.getMessage(), Toast.LENGTH_LONG).show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);

        if (requestCode == REQUEST_CODE_WRITE_EXTERNAL_STORAGE_PERMISSION) {
            int grantResultsLength = grantResults.length;
            if (grantResultsLength > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getApplicationContext(), "You grant write external storage permission. Please click original button again to continue.", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(getApplicationContext(), "You denied write external storage permission.", Toast.LENGTH_LONG).show();
            }
        }
    }
}
