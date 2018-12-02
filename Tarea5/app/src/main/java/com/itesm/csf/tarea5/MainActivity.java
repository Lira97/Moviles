package com.itesm.csf.tarea5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    int bueno;
    int Malo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_main);

        final ToggleButton toggleButton2 = (ToggleButton)findViewById(R.id.toggleButton2);

        toggleButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
                if(toggleButton2.isChecked()) {
                    bueno++;

                }
                else {
                    Malo++;

                }
            }
        });
        final ToggleButton toggleButton3 = (ToggleButton)findViewById(R.id.toggleButton3);

        toggleButton3.setOnClickListener(new View.OnClickListener() {
            public void onClick(View arg0)
            {
                if(toggleButton3.isChecked()) {
                    bueno++;

                }
                else {
                    Malo++;

                }
            }
        });
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton:
                if (checked) {
                    bueno++;

                } else {
                    bueno--;

                }

                break;
            case R.id.radioButton2:
                if (checked) {
                    bueno++;
                } else {
                    bueno--;

                }
                break;
            case R.id.radioButton4:
                if (checked)
                    Malo++;
                else
                    Malo--;
                break;
        }
    }
    public void onRadioButtonClicked2(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.radioButton5:
                if (checked) {
                    bueno++;

                } else {
                    bueno--;

                }

                break;
            case R.id.radioButton6:
                if (checked) {
                    bueno++;
                } else {
                    bueno--;

                }
                break;
            case R.id.radioButton8:
                if (checked)
                    Malo++;
                else
                    Malo--;
                break;
        }
    }

    public void onCheckboxClicked(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox5:
                if (checked) {
                    bueno++;

                } else {
                    bueno--;

                }
                break;
        }
    }

    public void onCheckboxClicked2(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox:
                if (checked) {
                    Malo++;

                } else {
                    Malo--;

                }
                break;
        }
    }

    public void onCheckboxClicked3(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox6:
                if (checked) {
                    bueno++;

                } else {
                    bueno--;

                }
                break;
        }
    }

    public void onCheckboxClicked4(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox16:
                if (checked) {
                    Malo++;

                } else {
                    Malo--;

                }
                break;
        }
    }

    public void onCheckboxClicked5(View view) {
        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox20:
                if (checked) {
                    bueno++;

                } else {
                    bueno--;

                }
                break;
        }
    }

    public void onCheckboxClicked6(View view) {

        // Is the view now checked?
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId()) {
            case R.id.checkBox21:
                if (checked) {
                    Malo++;

                } else {
                    Malo--;

                }
                break;
        }
    }

    public void resultdo(View view) {

        // Is the view now checked?

        if (bueno >= 6) {
            Intent actividad = new Intent(MainActivity.this,Imagen.class);
            startActivity(actividad);

        } else if (Malo >= 6) {

            Intent actividad = new Intent(MainActivity.this,formulario.class);
            startActivity(actividad);

        }


    }
}

