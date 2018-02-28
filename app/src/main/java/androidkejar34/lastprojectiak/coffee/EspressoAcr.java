package androidkejar34.lastprojectiak.coffee;

        import android.content.Intent;
        import android.support.v7.app.AppCompatActivity;
        import android.os.Bundle;
        import android.view.View;
        import android.widget.Button;
        import android.widget.EditText;
        import android.widget.TextView;
        import android.widget.Toast;

        import java.util.regex.Matcher;
        import java.util.regex.Pattern;

        import androidkejar34.lastprojectiak.MainActivity;
        import androidkejar34.lastprojectiak.R;

public class EspressoAcr extends AppCompatActivity {
    private TextView quant_txt;
    private TextView gt_txt;
    public Button tmbh;
    public Button krg;
    public Button ordered;
    public int qtt_txt;
    public int gtot_txt;
    public EditText namedt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_espresso_acr);

        gt_txt = (TextView) findViewById(R.id.gttext);
        TextView quant_txt = (TextView) findViewById(R.id.quanttitis);
        tmbh =(Button) findViewById(R.id.tmbhbtn);
        krg = (Button) findViewById(R.id.krgbtn);
        ordered = (Button) findViewById(R.id.orderbtn_esp);
        namedt = (EditText) findViewById(R.id.namedt);
        tmbh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qtt_txt = qtt_txt + 1;
                gtot_txt = gtot_txt + 15000;
                displayQuant(qtt_txt);
                displayPrice(gtot_txt);
            }
        });

        krg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                qtt_txt = qtt_txt - 1;
                gtot_txt = gtot_txt - 15000;
                if (qtt_txt<=0){
                    if(gtot_txt<=0){
                        gtot_txt = 0;
                    }
                    qtt_txt=0;
                }
                displayQuant(qtt_txt);
                displayPrice(gtot_txt);
            }
        });

        ordered.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (qtt_txt <= 0 || isEmpty(namedt)) {
                    Toast.makeText(EspressoAcr.this, "Input nama dan masukan jumlah pesanan ", Toast.LENGTH_SHORT).show();
                } else if (isChar(namedt)== false) {
                    Toast.makeText(EspressoAcr.this, "Masukan Huruf saja pada kolom nama", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(EspressoAcr.this, "Pesanan anda telah kami terima,Terima kasih "+namedt.getText().toString(),Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(EspressoAcr.this, MainActivity.class));
                    qtt_txt = 0;
                    gtot_txt = 0;
                    namedt.setText("");
                    displayPrice(0);
                    displayQuant(0);
                }
            }
        });
    }


    public void displayQuant(int view){
        TextView Quantxt = (TextView) findViewById(R.id.quanttitis);
        Quantxt.setText(String.valueOf(view));
    }

    public void displayPrice (int price){
        TextView priceview = (TextView) findViewById(R.id.gttext);
        priceview.setText(String.valueOf("Rp"+ price));
    }
    public boolean isEmpty (EditText namedt){
        return namedt.getText().toString().length() == 0;
    }
    public boolean isChar(EditText namedt){
        return  namedt.getText().toString().matches("^[a-zA-Z ]+$");
    }
}
