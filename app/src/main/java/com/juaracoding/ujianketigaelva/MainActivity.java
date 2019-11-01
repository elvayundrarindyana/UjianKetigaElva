package com.juaracoding.ujianketigaelva;


import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.developer.filepicker.controller.DialogSelectionListener;
import com.developer.filepicker.model.DialogConfigs;
import com.developer.filepicker.model.DialogProperties;
import com.developer.filepicker.view.FilePickerDialog;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class MainActivity extends AppCompatActivity {



    Button btnBuka;
    Button btnMulai;
    RecyclerView lstData;
    public ArrayList<ModelUJIAN> itemList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnBuka = findViewById(R.id.btnBuka);
        btnMulai = findViewById(R.id.btnMulai);
        lstData = findViewById(R.id.lstData);


        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {

            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE}, 1);
        }

        DialogProperties properties = new DialogProperties();
        properties.selection_mode = DialogConfigs.SINGLE_MODE;
        properties.selection_type = DialogConfigs.FILE_SELECT;
        properties.root = new File(DialogConfigs.DEFAULT_DIR);
        properties.error_dir = new File(DialogConfigs.DEFAULT_DIR);
        properties.offset = new File(DialogConfigs.DEFAULT_DIR);
        properties.extensions = null;

        final FilePickerDialog dialog = new FilePickerDialog(MainActivity.this, properties);
        dialog.setTitle("Pilih file csv");

        dialog.setDialogSelectionListener(new DialogSelectionListener() {
            @Override
            public void onSelectedFilePaths(String[] files) {
                //files is the array of the paths of files selected by the Application User.
                itemList = baca(files[0]);
            }
        });





        btnMulai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MulaiUjian.class);
                intent.putParcelableArrayListExtra("data",itemList);
                startActivity(intent);
            }
        });
        btnBuka.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
           dialog.show();
        });
    }


    public ArrayList<ModelUJIAN> baca(String fileName) {
        ArrayList<ModelUJIAN> todoList = new ArrayList<>();

        try {

            Scanner scanner = new Scanner(new File(fileName));
            Scanner valueScanner = null;
            int index = 0;


            while (scanner.hasNextLine()) {
                valueScanner = new Scanner(scanner.nextLine());
                valueScanner.useDelimiter(";");
                ModelUJIAN todo = new ModelUJIAN();

                while (valueScanner.hasNext()) {
                    String data = valueScanner.next();
                    if (index == 0) {
                        todo.setSkor(data);
                    } else if (index == 1) {
                        todo.setRb1(data);
                    } else if (index == 2) {
                        todo.setJumlahbenar(data);
                    } else if (index == 3) {
                        todo.setJumlahsalah(data);
                    } else if (index == 4) {
                        soal.setRbD(data);
                    } else if (index == 5) {
                        soal.setJawaban(data);
                    } else if (index == 6) {
                        soal.setPoint(data);
                    } else if (index == 7) {
                        soal.setGambar(data);
                    }
                    }
                    index++;
                }
                index = 0;
                todoList.add(todo);
            }

            scanner.close();
        } catch (IOException e) {

        }

        return todoList;
    }

}
//    public void setList(String fileName) {
//        ToDoList_Adapter itemArrayAdapter = new ToDoList_Adapter(baca(fileName));
//
//        lstData.setLayoutManager(new LinearLayoutManager(this));
//        lstData.setItemAnimator(new DefaultItemAnimator());
//        lstData.setAdapter(itemArrayAdapter);
//    }
//
//
//}
