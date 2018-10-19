package com.example.asus.tugasmovielist;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class InputMovie extends AppCompatActivity {
    ArrayList<String> lnama;
    ArrayList<String> lrating;
    ArrayList<String> lstatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_movie);
        addItemsOnSpinner2();
    }

    public void addItemsOnSpinner2() {

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);
        List<String> list = new ArrayList<String>();
        list.add("PLAYING");
        list.add("COMING SOON");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_spinner_item, list);
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(dataAdapter);
    }

    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(api = Build.VERSION_CODES.O)
    public void TambahClick(View view) {
        Double temp;
        String rating, nama, status;
        EditText edt;
        lnama = getIntent().getStringArrayListExtra("nama");
        lrating = getIntent().getStringArrayListExtra("rating");
        lstatus = getIntent().getStringArrayListExtra("status");
        try{
            edt = findViewById(R.id.nama_movie);
            nama = edt.getText().toString();
            edt = findViewById(R.id.rating_movie);
            rating = edt.getText().toString();
            Spinner spn = findViewById(R.id.spinner2);
            status = String.valueOf(spn.getSelectedItem());
        }
        catch(Error e){
            nama = "";
            rating = "0";
            status = "";
        }
        if(nama != "" && status != "") {
            lnama.add(nama);
            lrating.add(rating);
            lstatus.add(status);
        }
        Intent intent = new Intent(this, MainActivity.class);
        intent.putStringArrayListExtra("nama",lnama);
        intent.putStringArrayListExtra("rating",lrating);
        intent.putStringArrayListExtra("status",lstatus);
        view.getContext().startActivity(intent);
    }
}

