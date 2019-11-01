package com.juaracoding.ujianketigaelva;

public class Soal_1 {


    public String pertanyaan[] = {
            "Siapakah presiden pertama Indonesia?",
            "Siapa nama pahlawan dibawah ini?",
            "Siapakah penemu benua amerika?",
            "Apa nama alat dibawah ini?",
    };

    private String pilihanJawaban[][] = {
            {"Sukarno","Suharto","Suparjo","Suharti"},
            {"Diponegoro","Sultan","Imam","Fatahillah"},
            {"Pattimura","Christoper","David","rowan"},
            {"Raspberry","Jetson","Orange","Arduino"},
    };


    private String jawabanBenar[] = {
            "Sukarno",
            "Diponegoro",
            "Christoper",
            "Arduino",
    };

    public String getPertanyaan(int x){
        String soal = pertanyaan[x];
        return soal;
    }


    public String getPilihanJawaban1(int x){
        String jawaban1 = pilihanJawaban[x][0];
        return jawaban1;
    }

    public String getPilihanJawaban2(int x){
        String jawaban2 = pilihanJawaban[x][1];
        return jawaban2;
    }

    public String getPilihanJawaban3(int x){
        String jawaban3 = pilihanJawaban[x][2];
        return jawaban3;
    }
    public String getPilihanJawaban4(int x){
        String jawaban3 = pilihanJawaban[x][2];
        return jawaban3;
    }

    public String getJawabanBenar(int x){
        String jawaban = jawabanBenar[x];
        return jawaban;
    }
}
