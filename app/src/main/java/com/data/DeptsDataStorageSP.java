package com.data;

import android.content.Context;
import android.content.SharedPreferences;

import java.util.ArrayList;
import java.util.List;

public class DeptsDataStorageSP implements DeptsDataStorage{
    SharedPreferences storage;

    public DeptsDataStorageSP(Context context){
        this.storage = context.getSharedPreferences("DEPTS STORAGE", Context.MODE_PRIVATE);
    }
    @Override
    public void saveData() {
        int size = storage.getInt("size", 0);
        SharedPreferences.Editor editor = storage.edit();
        editor.putString("name" + size, dept.name);
        editor.putString("money" + size, dept.money);
        editor.putInt("Size", size + 1);
        editor.apply();

    }

    @Override
    public Dept getData(int id) {
        int size = storage.getInt("size", 0);
        ArrayList<Dept> arrayList = new ArrayList<>();
        for (int i = 0; i < size; i++){
            arrayList.add(getData(i));
        }
        return new Dept(storage.getString("name" + id, ""), storage.getFloat("money" + id, ""));
    }

    @Override
    public List<Dept> getAllData() {
        return null;
    }
}
