package mx.itesm.csf.grafica;

import android.app.ProgressDialog;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.github.mikephil.charting.charts.BarChart;
import com.github.mikephil.charting.data.BarData;
import com.github.mikephil.charting.data.BarDataSet;
import com.github.mikephil.charting.data.BarEntry;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.util.ArrayList;

public class Barra extends AppCompatActivity {

    ArrayList<BarDataSet> yAxis;
    ArrayList<BarEntry> yValues;
    ArrayList<String> xAxis1;
    BarEntry values;
    BarChart chart;
    BarData data;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barra);

        pd = new ProgressDialog(Barra.this);
        pd.setMessage("Cargando...");

        // Log.d("array",Arrays.toString(fullData));
        chart = (BarChart) findViewById(R.id.grafico);
        cargar_datos();
    }

    public void cargar_datos() {
        pd.show();
        String url = "https://api.bitso.com/v3/available_books";
        xAxis1 = new ArrayList<>();
        yAxis = null;
        yValues = new ArrayList<>();

        StringRequest stringRequest = new StringRequest(Request.Method.GET,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("string", response);

                        try {
                            JSONObject json= new JSONObject(response);
                            JSONArray json2 = json.getJSONArray("payload");


                            for (int i = 0; i < json2.length(); i++) {

                                JSONObject jsonobject = json2.getJSONObject(i);


                                String califiacion = jsonobject.getString("maximum_price").trim();
                                String nombre = jsonobject.getString("book").trim();

                                xAxis1.add(nombre);

                                values = new BarEntry(Float.valueOf(califiacion), i);
                                yValues.add(values);

                            }
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }

                        BarDataSet barDataSet1 = new BarDataSet(yValues, "SatisfacciÃ³n del cliente");
                        barDataSet1.setColor(Color.rgb(0, 82, 159));


                        yAxis = new ArrayList<>();
                        yAxis.add(barDataSet1);
                        String names[] = xAxis1.toArray(new String[xAxis1.size()]);
                        data = new BarData(names, yAxis);
                        chart.setData(data);
                        chart.animateXY(2000, 2000);
                        chart.invalidate();
                        pd.hide();
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        if (error != null) {

                            Toast.makeText(getApplicationContext(), "Algo pasÃ³ con la obtenciÃ³n del JSON.", Toast.LENGTH_LONG).show();
                            pd.hide();
                        }
                    }
                }

        );

        Singleton.getInstance(getApplicationContext()).addToRequestQueue(stringRequest);

    }

}