package com.example.hw1;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CityAdapter extends RecyclerView.Adapter<CityViewHolder> {
    private List<String> list;
    private OnCityClickListener onCityClickListener;


    public void setOnCityClickListener(OnCityClickListener onCityClickListener) {
        this.onCityClickListener = onCityClickListener;
    }

    public void setList(List<String> list) {
        this.list = list;
        notifyDataSetChanged();
    }




    @NonNull
    @Override
    public CityViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return  new CityViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_city, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull CityViewHolder holder, int position) {
        holder.bind(list.get(position), onCityClickListener);
    }


    @Override
    public int getItemCount() {
        if (list == null) {
            return 0;
        }
        return this.list.size();

    }

}
