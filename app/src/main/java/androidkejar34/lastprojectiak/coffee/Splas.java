package androidkejar34.lastprojectiak.coffee;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import androidkejar34.lastprojectiak.MainActivity;
import androidkejar34.lastprojectiak.R;

public class Splas extends AppCompatActivity {
    private static final int splashTime = 2000;
    private Handler handler;
    private Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splas);

        handler = new Handler();

        runnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(Splas.this, MainActivity.class));
            }
        };

        handler.postDelayed(runnable,splashTime);
    }
}
