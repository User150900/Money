package com.data;

import java.util.List;

public interface DeptsDataStorage {
    public void saveData(Dept.dept);

    public Dept getData(int id);

    public List<Dept> getAllData();
}
