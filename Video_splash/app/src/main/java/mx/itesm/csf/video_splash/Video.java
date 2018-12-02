package mx.itesm.csf.video_splash;

import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.VideoView;

public class Video extends AppCompatActivity {

    //VideoView muestraVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        try{
            VideoView muestraVideo = new VideoView(this);
            setContentView(muestraVideo);
            Uri video = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.ad8);
            muestraVideo.setVideoURI(video);

            muestraVideo.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                @Override
                public void onCompletion(MediaPlayer mp) {
                    otraActividad();
                }
            });
            muestraVideo.start();
        }catch (Exception ex){
            otraActividad();
        }

    }

    private void otraActividad(){
        if(isFinishing())
            return;
        startActivity(new Intent(this,Menu.class));
        finish();
    }
}
