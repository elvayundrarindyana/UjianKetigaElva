package com.juaracoding.ujianketigaelva;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MulaiUjian extends AppCompatActivity {


    AlertDialog.Builder builder;
    RadioGroup rgPilihanJawaban1;
    RadioGroup rgPilihanJawaban2;
    RadioGroup rgPilihanJawaban3;
    RadioGroup rgPilihanJawaban4;
    TextView txtSoal1,txtSoal2,txtSoal3,txtSoal4;
    TextView mtvSkor;
    RadioButton rbPJ1,rbPJ2,rbPJ3,rbPJ4;
    RadioButton rbPJ11,rbPJ22,rbPJ33,rbPJ44;
    RadioButton rbPJ111,rbPJ222,rbPJ333,rbPJ444;
    RadioButton rbPJ1111,rbPJ2222,rbPJ3333,rbPJ4444;
    Button btnSelesai;

    int skor = 0;
    int arr;
    int x;
    String jawaban;

    Soal_1 soalPG = new Soal_1();

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.item_mulai_ujian);
//
//        rgPilihanJawaban1 = (RadioGroup) findViewById(R.id.rgPilihanJawaban1);
//        rgPilihanJawaban2 = (RadioGroup) findViewById(R.id.rgPilihanJawaban2);
//        rgPilihanJawaban3 = (RadioGroup) findViewById(R.id.rgPilihanJawaban3);
//        rgPilihanJawaban4 = (RadioGroup) findViewById(R.id.rgPilihanJawaban4);
//
//        txtSoal1 = (TextView) findViewById(R.id.txtsoal1);
//        txtSoal2 = (TextView) findViewById(R.id.txtsoal2);
//        txtSoal3 = (TextView) findViewById(R.id.txtsoal3);
//        txtSoal4 = (TextView) findViewById(R.id.txtsoal4);
//
//
//        rbPJ1 = (RadioButton) findViewById(R.id.rbPJ1);
//        rbPJ2 = (RadioButton) findViewById(R.id.rbPJ2);
//        rbPJ3 = (RadioButton) findViewById(R.id.rbPJ3);
//        rbPJ4 = (RadioButton) findViewById(R.id.rbPJ4);
//
//        rbPJ11 = (RadioButton) findViewById(R.id.rbPJ11);
//        rbPJ22 = (RadioButton) findViewById(R.id.rbPJ22);
//        rbPJ33 = (RadioButton) findViewById(R.id.rbPJ33);
//        rbPJ44 = (RadioButton) findViewById(R.id.rbPJ44);
//
//        rbPJ111 = (RadioButton) findViewById(R.id.rbPJ111);
//        rbPJ222 = (RadioButton) findViewById(R.id.rbPJ222);
//        rbPJ333 = (RadioButton) findViewById(R.id.rbPJ333);
//        rbPJ444 = (RadioButton) findViewById(R.id.rbPJ444);
//
//        rbPJ1111 = (RadioButton) findViewById(R.id.rbPJ1111);
//        rbPJ2222 = (RadioButton) findViewById(R.id.rbPJ2222);
//        rbPJ3333 = (RadioButton) findViewById(R.id.rbPJ3333);
//        rbPJ4444 = (RadioButton) findViewById(R.id.rbPJ4444);
//
//        btnSelesai=(Button)findViewById(R.id.btnSelesai);
//        mtvSkor=(TextView)findViewById(R.id.mtvSkor);

//
//        mtvSkor.setText("" + skor);
//        setKonten();
//
//        btnSelesai.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                cekJawaban();
//            }
//        });
//    }


    public void setKonten() {
        txtSoal1.clearAnimation();
        arr = soalPG.pertanyaan.length;
        if (x >= arr) {
            String jumlahSkor = String.valueOf(skor);
            Intent i = new Intent(MulaiUjian.this, Skornya.class);
            i.putExtra("skorAkhir", jumlahSkor);
            i.putExtra("activity", "PilihanGanda");
            startActivity(i);
        } else {
            txtSoal1.setText(soalPG.getPertanyaan(x));
            rbPJ1.setText(soalPG.getPilihanJawaban1(x));
            rbPJ2.setText(soalPG.getPilihanJawaban2(x));
            rbPJ3.setText(soalPG.getPilihanJawaban3(x));
            rbPJ4.setText(soalPG.getPilihanJawaban4(x));
            jawaban = soalPG.getJawabanBenar(x);

        }
        x++;
    }

    public void cekJawaban() {
        if (rbPJ1.isChecked()) {

            if (rbPJ1.getText().toString().equals(jawaban)) {
                skor = skor + 25;

                mtvSkor.setText("" + skor);

                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                setKonten();

            } else {
                mtvSkor.setText("" + skor);

                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        } else if (rbPJ2.isChecked()) {
            if (rbPJ2.getText().toString().equals(jawaban)) {
                skor = skor + 25;
                mtvSkor.setText("" + skor);

                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();
                setKonten();
            } else {
                mtvSkor.setText("" + skor);

                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        } else if (rbPJ3.isChecked()) {

            if (rbPJ3.getText().toString().equals(jawaban)) {
                skor = skor + 25;
                mtvSkor.setText("" + skor);

                Toast.makeText(this, "Jawaban Benar", Toast.LENGTH_SHORT).show();

                setKonten();
            } else {
                mtvSkor.setText("" + skor);

                Toast.makeText(this, "Jawaban Salah", Toast.LENGTH_SHORT).show();
                setKonten();
            }
        }

        }
    }

