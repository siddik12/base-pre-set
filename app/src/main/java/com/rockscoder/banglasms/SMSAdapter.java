package com.rockscoder.banglasms;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView.Adapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SMSAdapter extends Adapter<SMSAdapter.ViewHolder> {
    private Context context;
    private List<TextSMS> listItems;

    public class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        TextView desc;
        ImageView shareImg;

        ViewHolder(View itemView) {
            super(itemView);
            this.desc = (TextView) itemView.findViewById(R.id.statusTextView);
            this.shareImg = (ImageView) itemView.findViewById(R.id.shareImageView);

            this.shareImg.setOnClickListener(new OnClickListener() {
                public void onClick(View v) {
                    String position = ViewHolder.this.desc.getText().toString();
                    Intent share = new Intent("android.intent.action.SEND");
                    share.setType("text/plain");
                    share.putExtra("android.intent.extra.TEXT", position);
                    v.getContext().startActivity(Intent.createChooser(share, "শেয়ার করুন"));
                }
            });
        }
    }

    SMSAdapter(List<TextSMS> listItems, Context context) {
        this.listItems = listItems;
        this.context = context;
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sms, parent, false));
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        TextSMS listItem = (TextSMS) this.listItems.get(position);
        holder.desc.setText(listItem.getDesc());
    }

    public int getItemCount() {
        return this.listItems.size();
    }
}
