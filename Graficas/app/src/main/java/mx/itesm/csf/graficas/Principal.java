package mx.itesm.csf.graficas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.github.mikephil.charting.charts.LineChart;

public class Principal extends AppCompatActivity {
    LineChart chart = (LineChart) findViewById(R.id.chart);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_principal);
    }
}
