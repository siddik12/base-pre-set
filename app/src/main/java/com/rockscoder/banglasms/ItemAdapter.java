package com.rockscoder.banglasms;

import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends Adapter<ItemAdapter.ViewHolder> {

    private List<TextSMS> listItems;
    private final OnItemClickListener listener;


    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        TextView desc;
        CardView cardView;
        ViewHolder(View itemView) {
            super(itemView);
            this.desc = itemView.findViewById(R.id.statusTextView);
            this.cardView = itemView.findViewById(R.id.card_view);
        }

    }


    ItemAdapter(List<TextSMS> listItems, OnItemClickListener listener) {
        this.listItems = listItems;
        this.listener = listener;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final TextSMS listItem = this.listItems.get(position);



        holder.desc.setText(listItem.getDesc());
        holder.itemView.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemClick(listItem);
            }
        });
    }

    public int getItemCount() {
        return this.listItems.size();
    }


    public interface OnItemClickListener {
        void onItemClick(TextSMS listItem);
    }


}
