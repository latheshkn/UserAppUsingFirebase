package com.example.cabuserapp.Model;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

import com.example.cabuserapp.R;

public class View_Recycler_Adapter extends RecyclerView.ViewHolder {

      public View mview;
    public TextView txtviewcarname, txtviewcarmodel;
    public ImageView Carviewimages;
   public  Toolbar toolcarviewpage;


    public View_Recycler_Adapter(@NonNull View itemView) {
        super(itemView);

        txtviewcarname=itemView.findViewById(R.id.txtviewcarname);
        txtviewcarmodel=itemView.findViewById(R.id.txtviewcarmodel);
        Carviewimages=itemView.findViewById(R.id.Carviewimages);
        toolcarviewpage=itemView.findViewById(R.id.toolcarviewpage);

        mview=itemView;
    }
}
