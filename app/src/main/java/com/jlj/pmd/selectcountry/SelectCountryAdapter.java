package com.jlj.pmd.selectcountry;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


import com.jlj.pmd.R;
import com.jlj.pmd.azlist.AZBaseAdapter;
import com.jlj.pmd.azlist.AZItemEntity;

import java.util.List;


public class SelectCountryAdapter extends AZBaseAdapter<Country, SelectCountryAdapter.ItemHolder> {

    private OnItemClickListener onItemClickListener;

    public SelectCountryAdapter(List<AZItemEntity<Country>> dataList) {
        super(dataList);
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ItemHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_country, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        final Country item = getDataList().get(position).getValue();
        String countryTitle = item.getEnName();
        countryTitle = countryTitle +" " + item.getDialingCode();
        holder.tvCountry.setText(countryTitle);
        holder.tvCountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (onItemClickListener!=null){
                    onItemClickListener.onItemClickListener(item);
                }
            }
        });
    }

    static class ItemHolder extends RecyclerView.ViewHolder {

        TextView tvCountry;

        ItemHolder(View itemView) {
            super(itemView);
            tvCountry = itemView.findViewById(R.id.tv_country);
        }
    }
    public interface OnItemClickListener{
        void onItemClickListener(Country country);
    }
}
