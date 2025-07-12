
package com.meuapp.amorinfinito;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.TextView;
import java.util.Calendar;

public class MainActivity extends Activity {
    MediaPlayer mp;
    TextView contador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        contador = findViewById(R.id.contador);

        Calendar inicio = Calendar.getInstance();
        inicio.set(2024, Calendar.SEPTEMBER, 6);
        long dias = (Calendar.getInstance().getTimeInMillis() - inicio.getTimeInMillis()) / (1000 * 60 * 60 * 24);
        contador.setText("Juntos há " + dias + " dias 💛💜");

        mp = MediaPlayer.create(this, R.raw.musica);
        mp.setLooping(true);
        mp.start();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mp != null) {
            mp.stop();
            mp.release();
        }
    }
}
