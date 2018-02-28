package androidkejar34.lastprojectiak;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidkejar34.lastprojectiak.coffee.Amerikano;
import androidkejar34.lastprojectiak.coffee.CappucinoAct;
import androidkejar34.lastprojectiak.coffee.EspressoAcr;
import androidkejar34.lastprojectiak.coffee.LatteAct;

public class MainActivity extends AppCompatActivity {
    private Button ltebutton;
    private Button espbtn;
    private Button cpcino;
    private Button america;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ltebutton = (Button) findViewById(R.id.late_btn);
        espbtn = (Button) findViewById(R.id.esp_btn);
        cpcino = (Button) findViewById(R.id.cap_btn);
        america = (Button) findViewById(R.id.amrik);

        america.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, Amerikano.class));
            }
        });
        ltebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, LatteAct.class));
            }
        });


        espbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, EspressoAcr.class));
            }
        });

        cpcino.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this, CappucinoAct.class));
            }
        });
    }
}
