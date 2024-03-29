package mx.itesm.csf.video_splash;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Actividad2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_actividad2);
        Button btnActividad_1 = (Button) findViewById(R.id.buttonweb);
        final WebView webView = (WebView)findViewById(R.id.webView);
        btnActividad_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Bundle bundle = getIntent().getExtras();
                webView.loadUrl("https://"+bundle.getString("url")+ ".com");
            }
        });
    }
}
