package androidkejar34.lastprojectiak.coffee;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import androidkejar34.lastprojectiak.MainActivity;
import androidkejar34.lastprojectiak.R;

public class CappucinoAct extends AppCompatActivity {
    public TextView grandtot;
    public  TextView quantext;
    public int grandTot;
    public int quantitext;
    public Button plus;
    public Button mines;
    public Button order;
    public TextView cap;
    public EditText nama;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cappucino);
        final TextView grandtot = (TextView) findViewById(R.id.gttext);
        final TextView quantext = (TextView) findViewById(R.id.quant_txt);
        plus = (Button) findViewById(R.id.plusbtn);
        mines = (Button) findViewById(R.id.minesbtn);
        order = (Button) findViewById(R.id.orderbtn);
        final TextView capt = (TextView) findViewById(R.id.cappu);
        final EditText nama = (EditText) findViewById(R.id.name_edt);

        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantitext = quantitext + 1;
                grandTot = grandTot + 20000;
                displayquantiti(quantitext);
                displaygrandtota(grandTot);
            }
        });

        mines.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                quantitext = quantitext-1;
                grandTot = grandTot-20000;
                if (quantitext<=0){
                    if(grandTot<=0){
                        grandTot = 0;
                    }
                    quantitext=0;
                }
                displayquantiti(quantitext);
                displaygrandtota(grandTot);
            }
        });

        order.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (quantitext <= 0 || isEmpty(nama) ) {
                    Toast.makeText(CappucinoAct.this, "Anda Harus Memesan dan masukan nama dahulu", Toast.LENGTH_LONG).show();
                } else if (isChar(nama)==false) {
                    Toast.makeText(CappucinoAct.this, "Masukan Huruf saja pada kolom nama", Toast.LENGTH_LONG).show();
                }else{
                        Toast.makeText(CappucinoAct.this, "Pesanan Anda sudah Kami Terima , Terima kasih " + nama.getText().toString(), Toast.LENGTH_LONG).show();
                        startActivity(new Intent(CappucinoAct.this, MainActivity.class));
                        nama.setText("");
                        quantitext = 0;
                        grandTot = 0;
                        displayquantiti(0);
                        displaygrandtota(0);
                    }
            }
            });
    }

    public void displayquantiti(int view) {
        TextView quantview = (TextView) findViewById(R.id.quant_txt);
        quantview.setText(String.valueOf(view));
    }

    public void displaygrandtota(int grand) {
        TextView grandview = (TextView) findViewById(R.id.gttext);
        grandview.setText(String.valueOf("Rp" + grand));
    }

    private boolean isEmpty(EditText nama){
        return nama.getText().toString().length() == 0;
    }
    private  boolean isChar(EditText nama){
        return  nama.getText().toString().matches("^[a-zA-Z ]+$");
    }
}

