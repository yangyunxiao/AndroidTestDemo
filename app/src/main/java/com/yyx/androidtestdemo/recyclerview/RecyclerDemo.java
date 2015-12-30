package com.yyx.androidtestdemo.recyclerview;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Loading on 15/12/28.
 */
public class RecyclerDemo {

    public static List<DataModel> getData(int count){

        List<DataModel> dataList = new ArrayList();

        for(int x = 0; x < count; x++){

            dataList.add(x,new DataModel("Sample Data < "+x+" >"));

        }

       return dataList;
    }
}
