package com.example.houshuai.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.houshuai.qianfengfirstapp.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by HouShuai on 2016/6/17.
 */

public class Myfragment extends Fragment {

    private ListView listview;
    private List<String> datas;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String name = arguments.getString("tabName", "meiyou");
        datas = new LinkedList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(name + i
            );
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.listview, container, false);
        listview = (ListView) inflate.findViewById(R.id.lv_showListView);
        listview.setBackgroundColor(Color.rgb((int) (Math.random() * 254), (int) (Math.random() * 254), (int) (Math.random() * 254)));
        return inflate;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        listview.setAdapter(new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, datas));

    }

}
