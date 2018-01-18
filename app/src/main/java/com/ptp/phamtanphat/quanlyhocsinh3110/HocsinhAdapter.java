package com.ptp.phamtanphat.quanlyhocsinh3110;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by KhoaPhamPC on 16/1/2018.
 */

public class HocsinhAdapter extends BaseAdapter {
    Context context;
    int layout;
    ArrayList<Hocsinh> hocsinhArrayList;

    public HocsinhAdapter(Context context, int layout, ArrayList<Hocsinh> hocsinhArrayList) {
        this.context = context;
        this.layout = layout;
        this.hocsinhArrayList = hocsinhArrayList;
    }

    @Override
    public int getCount() {
        return hocsinhArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return hocsinhArrayList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater inflater = LayoutInflater.from(context);
        view = inflater.inflate(layout,null);

        TextView txtten = view.findViewById(R.id.textviewten);
        TextView txtnamsinh = view.findViewById(R.id.textviewnamsinh);
        TextView txtdiachi = view.findViewById(R.id.textviewdiachi);

        Hocsinh hocsinh = (Hocsinh) getItem(i);
        txtten.setText(hocsinh.getTen());
        txtnamsinh.setText(hocsinh.getNamsinh());
        txtdiachi.setText(hocsinh.getDiachi());
        return view;
    }
}
