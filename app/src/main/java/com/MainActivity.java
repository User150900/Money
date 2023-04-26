package com;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.media.audiofx.PresetReverb;
import android.os.Bundle;
import android.view.View;

import com.data.Dept;
import com.data.DeptsDataStorage;
import com.data.DeptsDataStorageSP;
import com.example.money.databinding.ActivityMainBinding;

import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    ActivityMainBinding binding;
    DeptsDataStorageSP dataStorage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        dataStorage = new DeptsDataStorageSP(this);
        resetAdapter();
        binding.floatingBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dataStorage.saveData(new Dept()new Random().nextFloat(), ("Random guy"))
                resetAdapter();
            }
        });
    }

    private void resetAdapter(){
        List<Dept> depts = dataStorage.getAllData();
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerView.setAdapter(new MyAdapter(depts));
    }

}