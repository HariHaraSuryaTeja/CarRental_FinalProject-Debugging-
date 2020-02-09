package com.example.debuggingproj;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CarAdapter extends RecyclerView.Adapter<CarsViewHolder> {
    private LayoutInflater mInflater;
    private List<Cars> mData = new ArrayList<>();

    public CarAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
        this.mData.addAll(CarRepository.getInstance().getCars());

    }

    @NonNull
    @Override
    public CarsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.activity_cars_view_holder, parent, false);
        return new CarsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CarsViewHolder holder, int position) {
        // get the cars
        List<Cars> cars = CarRepository.getInstance().getCars();

        // set attributes to the item
        holder.tvType.setText(cars.get(position).type);
        holder.tvName.setText(cars.get(position).name);
        holder.tvcompany.setText(cars.get(position).company);
        holder.tvyear.setText(String.valueOf(cars.get(position).year));
    }

    @Override
    public int getItemCount() {
        return CarRepository.getInstance().getCars().size();
    }

    public void update() {
        mData.clear();
        mData.addAll(CarRepository.getInstance().getCars());
        notifyDataSetChanged();
    }
}

