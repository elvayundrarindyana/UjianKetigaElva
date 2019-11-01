package com.juaracoding.ujianketigaelva;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Skornya extends Activity {
    TextView mtvHasilAkhir;
    TextView mtvSoal;
    TextView mtvBenar;
    TextView mtvSalah;
    Button mbtnMenu;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_skornya);

        mtvHasilAkhir = (TextView) findViewById(R.id.tvSkorAkhir);
        mtvSoal = (TextView) findViewById(R.id.mtvSoal);
        mtvBenar = (TextView) findViewById(R.id.mtvBenar);
        mtvSalah = (TextView) findViewById(R.id.mtvSalah);
        mbtnMenu = (Button) findViewById(R.id.btnMenu);

        setSkor();

        mbtnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(Skornya.this, MulaiUjian.class);
                startActivity(i);
            }
        });
    }

    public void setSkor() {

        String activity = getIntent().getStringExtra("activity");
        String skorPilGan = getIntent().getStringExtra("skorAkhir");
        String skorPilGan1 = getIntent().getStringExtra("skorSoal");

        if (activity.equals("PilihanGanda")) {
            mtvHasilAkhir.setText("SKOR : " + skorPilGan);
        } else {
            mtvSoal.setText("SKOR : " + skorPilGan1);
        }
    }
}

