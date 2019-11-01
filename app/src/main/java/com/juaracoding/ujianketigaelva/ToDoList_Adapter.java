package com.juaracoding.ujianketigaelva;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class SoalAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    public static int SOAL_TXT1 = 0;
    public static int SOAL_GMBR2 = 1;
    public static int SOAL_TXT3 = 2;
    public static int SOAL_GMBR4 = 3;

    private ArrayList<ModelUJIAN> dataItemList;

    public SoalAdapter(ArrayList<ModelUJIAN> dataItemList){
        this.dataItemList = dataItemList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        if (viewType == SOAL_TXT1) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_soal_txt, parent, false);
            Penampung penampung = new Penampung(view);
            return penampung;
        } else if (viewType == SOAL_GMBR2) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_soal_gmbr, parent, false);
            Penampung2 penampung2 = new Penampung2(view);
            return penampung2;
        } else if (viewType == SOAL_TXT3) {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_soal_txt, parent, false);
            Penampung penampung = new Penampung(view);
            return penampung;
        } else {
            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_soal_gmbr, parent, false);
            Penampung2 penampung2 = new Penampung2(view);
            return penampung2;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof Penampung) {
            TextView soal = ((Penampung) holder).textsoal;
            RadioGroup rgjawab = ((Penampung) holder).rgjawaban;
            RadioButton rbA = ((Penampung) holder).rbA;
            RadioButton rbB = ((Penampung) holder).rbB;
            RadioButton rbC = ((Penampung) holder).rbC;
            RadioButton rbD = ((Penampung) holder).rbD;

            soal.setText(dataItemList.get(position).getSoal());
//            rgjawab.setText(dataItemList.get(position).getRgjawaban());
            rbA.setText(dataItemList.get(position).getRbA());
            rbB.setText(dataItemList.get(position).getRbB());
            rbC.setText(dataItemList.get(position).getRbC());
            rbD.setText(dataItemList.get(position).getRbD());


        } else if (holder instanceof Penampung2) {
            TextView soal = ((Penampung2) holder).textsoal;
            RadioGroup rgjawab = ((Penampung2) holder).rgjawaban;
            RadioButton rbA = ((Penampung2) holder).rbA;
            RadioButton rbB = ((Penampung2) holder).rbB;
            RadioButton rbC = ((Penampung2) holder).rbC;
            RadioButton rbD = ((Penampung2) holder).rbD;
            ImageView img = ((Penampung2) holder).img;

            soal.setText(dataItemList.get(position).getSoal());
//            rgjawab.setText(dataItemList.get(position).getRgjawaban());
            rbA.setText(dataItemList.get(position).getRbA());
            rbB.setText(dataItemList.get(position).getRbB());
            rbC.setText(dataItemList.get(position).getRbC());
            rbD.setText(dataItemList.get(position).getRbD());
//            img.setImageURI().;
            Picasso.get().load(dataItemList.get(position).getGambar()).into(img);


        }
    }

    @Override
    public int getItemCount() {
        return dataItemList == null ? 0 : dataItemList.size();

    }

    @Override
    public int getItemViewType(int position) {
        if (dataItemList.get(position).getTipe() == 0) {
            return SOAL_TXT1;
        }  else if (dataItemList.get(position).getTipe() == 1) {
            return SOAL_GMBR2;
        } else if (dataItemList.get(position).getTipe() == 2) {
            return SOAL_TXT3;
        }else {
            return SOAL_GMBR4;
        }
    }
    static class Penampung extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textsoal;
        public RadioGroup rgjawaban;
        public RadioButton rbA, rbB, rbC, rbD;

        public Penampung(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textsoal = (TextView) itemView.findViewById(R.id.txtSoal);
            rgjawaban = (RadioGroup) itemView.findViewById(R.id.rg_jawaban);
            rbA = (RadioButton) itemView.findViewById(R.id.rb_A);
            rbB = (RadioButton) itemView.findViewById(R.id.rb_B);
            rbC = (RadioButton) itemView.findViewById(R.id.rb_C);
            rbD = (RadioButton) itemView.findViewById(R.id.rb_D);
        }

        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " ");
        }
    }
    static class Penampung2 extends RecyclerView.ViewHolder implements View.OnClickListener {
        public TextView textsoal;
        public RadioGroup rgjawaban;
        public RadioButton rbA, rbB, rbC, rbD;
        public ImageView img;

        public Penampung2(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            textsoal = (TextView) itemView.findViewById(R.id.txtSoal);
            rgjawaban = (RadioGroup) itemView.findViewById(R.id.rg_jawaban);
            rbA = (RadioButton) itemView.findViewById(R.id.rb_A);
            rbB = (RadioButton) itemView.findViewById(R.id.rb_B);
            rbC = (RadioButton) itemView.findViewById(R.id.rb_C);
            rbD = (RadioButton) itemView.findViewById(R.id.rb_D);
            img = (ImageView) itemView.findViewById(R.id.img_soal);
        }

        @Override
        public void onClick(View view) {
            Log.d("onclick", "onClick " + getLayoutPosition() + " ");
        }
    }
}
