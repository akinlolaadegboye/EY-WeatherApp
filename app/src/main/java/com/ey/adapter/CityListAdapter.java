package com.ey.adapter;

import androidx.appcompat.widget.AppCompatTextView;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.ey.models.CityModel;
import java.util.List;
import com.ey.R;
import com.ey.views.CityWeatherDetails;


public class CityListAdapter extends RecyclerView.Adapter<CityListAdapter.MyViewHolder> {
    private List<CityModel> cityList;
    private Context context;


    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView name, country;
        public MyViewHolder(View view) {
            super(view);
            name = (AppCompatTextView) view.findViewById(R.id.nameTextView);
            country = (AppCompatTextView) view.findViewById(R.id.countryTextView);
        }
    }

    public CityListAdapter(Context context, List<CityModel> cityList) {
        this.cityList = cityList;
        this.context = context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.city_items, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        CityModel cityModel = cityList.get(position);
        holder.name.setText(cityModel.getName());
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, CityWeatherDetails.class);
                intent.putExtra("city", cityModel.getName());
                context.startActivity(intent);
                ((Activity) context).overridePendingTransition(R.anim.moving_in_side,
                        R.anim.hold_animmation);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cityList.size();
    }
}
