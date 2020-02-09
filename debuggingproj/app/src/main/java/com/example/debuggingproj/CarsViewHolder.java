package com.example.debuggingproj;

import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.TextView;

public class CarsViewHolder extends RecyclerView.ViewHolder {

    public TextView tvType, tvName, tvcompany, tvyear;

    public CarsViewHolder(View itemView) {
        super(itemView);
        tvType = itemView.findViewById(R.id.tvType);
        tvName = itemView.findViewById(R.id.tvName);
        tvcompany = itemView.findViewById(R.id.tvcompany);
        tvyear = itemView.findViewById(R.id.tvyear);
    }

}
