package com.juaracoding.ujianketigaelva;

import android.os.Parcel;
import android.os.Parcelable;



public class ModelUJIAN implements Parcelable{

    private String soal;
    private String gambar;
    private String rgjawaban;
    private String rbA;
    private String rbB;
    private String rbC;
    private String rbD;
    private int tipe;
    private String jawaban;
    private String point;

    public ModelUJIAN(String soal, String rbA, String rbB, String rbC, String rbD, String gambar) {
        this.soal = soal;
        this.rbA = rbA;
        this.rbB = rbB;
        this.rbC = rbC;
        this.rbD = rbD;
    }


    public String getSoal() {
        return soal;
    }

    public void setSoal(String soal) {
        this.soal = soal;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }

    public String getRgjawaban() {
        return rgjawaban;
    }

    public void setRgjawaban(String rgjawaban) {
        this.rgjawaban = rgjawaban;
    }

    public String getRbA() {
        return rbA;
    }

    public void setRbA(String rbA) {
        this.rbA = rbA;
    }

    public String getRbB() {
        return rbB;
    }

    public void setRbB(String rbB) {
        this.rbB = rbB;
    }

    public String getRbC() {
        return rbC;
    }

    public void setRbC(String rbC) {
        this.rbC = rbC;
    }

    public String getRbD() {
        return rbD;
    }

    public void setRbD(String rbD) {
        this.rbD = rbD;
    }

    public int getTipe() {
        return tipe;
    }

    public void setTipe(int tipe) {
        this.tipe = tipe;
    }

    public String getJawaban() {
        return jawaban;
    }

    public void setJawaban(String jawaban) {
        this.jawaban = jawaban;
    }

    public String getPoint() {
        return point;
    }

    public void setPoint(String point) {
        this.point = point;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.soal);
        dest.writeString(this.rbA);
        dest.writeString(this.rbB);
        dest.writeString(this.rbC);
        dest.writeString(this.rbD);
        dest.writeString(this.gambar);
    }

    public ModelUJIAN(){}
    protected ModelUJIAN(Parcel in) {
        this.soal = in.readString();
        this.rbA = in.readString();
        this.rbB = in.readString();
        this.rbC = in.readString();
        this.rbD = in.readString();
        this.gambar = in.readString();
    }

    public static final Parcelable.Creator<ModelUJIAN> CREATOR = new Parcelable.Creator<ModelUJIAN>() {
        @Override
        public ModelUJIAN createFromParcel(Parcel source) {
            return new ModelUJIAN(source);
        }

        @Override
        public ModelUJIAN[] newArray(int size) {
            return new ModelUJIAN[size];
        }

    };

}