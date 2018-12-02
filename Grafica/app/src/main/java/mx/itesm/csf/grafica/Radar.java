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
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.data.RadarDataSet;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Radar extends AppCompatActivity {

    ArrayList<Entry> entries;
    private ProgressDialog pd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_radar);

        pd = new ProgressDialog(Radar.this);
        pd.setMessage("loading");

        entries = new ArrayList<>();
        cargar_datos();
    }

    public void cargar_datos() {
        pd.show();
        String url = "http://ubiquitous.csf.itesm.mx/~raulms/content/TC2024/Modulo_II/Servicios/Graficas/servicio.grafica2.php";


        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("string", response);

                        try {

                            JSONArray jsonarray = new JSONArray(response);

                            for (int i = 0; i < jsonarray.length(); i++) {

                                JSONObject jsonobject = jsonarray.getJSONObject(i);


                                String Modelos = jsonobject.getString("Modelos").trim();
                                String Conduccion = jsonobject.getString("Conduccion").trim();
                                String Confort = jsonobject.getString("Confort").trim();
                                String Seguridad = jsonobject.getString("Seguridad").trim();
                                String Prestigio = jsonobject.getString("Prestigio").trim();
                                entries.add(new Entry(Float.valueOf(Modelos), 0));
                                entries.add(new Entry(Float.valueOf(Conduccion), 1));
                                entries.add(new Entry(Float.valueOf(Confort), 2));
                                entries.add(new Entry(Float.valueOf(Seguridad), 3));
                                entries.add(new Entry(Float.valueOf(Prestigio), 4));


                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                        RadarChart chart = (RadarChart) findViewById(R.id.radar1);

                        RadarDataSet dataset_comp1 = new RadarDataSet(entries, "EvaluaciÃ³n de la Marca Honda");

                        dataset_comp1.setColor(Color.BLUE);
                        dataset_comp1.setDrawFilled(true);

                        ArrayList<RadarDataSet> dataSets = new ArrayList<RadarDataSet>();
                        dataSets.add(dataset_comp1);

                        ArrayList<String> labels = new ArrayList<String>();
                        labels.add("Modelos");
                        labels.add("Conduccin");
                        labels.add("Confort");
                        labels.add("Seguridad");
                        labels.add("Prestigio");


                        RadarData data = new RadarData(labels, dataSets);
                        chart.setData(data);
                        String description = "Muestra el anÃ¡lisis de mercado de la marca Honda (escala 10-100)";
                        chart.setDescription(description);
                        //chart.setWebLineWidthInner(0.5f);


                        chart.invalidate();
                        chart.animate();
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