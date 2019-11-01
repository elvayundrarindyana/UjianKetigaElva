package com.juaracoding.ujianketigaelva;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MulaiUjian_1 extends AppCompatActivity {

    RecyclerView lstdata;
    Button selesai;
    public ArrayList<ModelUJIAN> data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soal);

        lstdata = findViewById(R.id.rv);
        data = getIntent().getParcelableArrayListExtra("data");
        setList();

        selesai = findViewById(R.id.btSelesai);

    }
    public void setList() {
        SoalAdapter soalAdapterAdapter = new SoalAdapter(data);

        lstdata.setLayoutManager(new LinearLayoutManager(this));
        lstdata.setItemAnimator(new DefaultItemAnimator());
        lstdata.setAdapter(soalAdapterAdapter);
    }
}
