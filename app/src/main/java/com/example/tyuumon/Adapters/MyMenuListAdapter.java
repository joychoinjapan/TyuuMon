package com.example.tyuumon.Adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tyuumon.MainActivity;
import com.example.tyuumon.R;
import com.example.tyuumon.beans.MenuItem;
import com.example.tyuumon.fragment.DetailsFragment;

import java.util.List;

public class MyMenuListAdapter extends RecyclerView.Adapter<MyMenuListAdapter.ViewHolder> {
    private List<MenuItem> menuItemList;
    private Context context;
    private View.OnClickListener listener;

    public MyMenuListAdapter(List<MenuItem> list, Context context){
        this.menuItemList = list;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.menu_item_list,null,false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final MenuItem menuItem =  menuItemList.get(position);
        holder.tv_menu_title.setText(menuItem.getName());
        holder.tv_menu_des.setText(menuItem.getDescription());
        holder.tv_menu_price.setText("¥"+menuItem.getPrice());
        holder.tv_menu_coupon.setText(menuItem.getAction());
        holder.tv_menu_sailed.setText(""+menuItem.getCount());
        holder.iv_menu_item_image.setImageBitmap(menuItem.getBitmap());
        holder.ll_list_item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listener.onClick(v);
            }
        });

    }

    @Override
    public int getItemCount() {
        return menuItemList.size();
    }

    public void setOnItemClickListener(View.OnClickListener listener){
        this.listener = listener;
    }


    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView iv_menu_item_image;
        TextView tv_menu_title,tv_menu_des,tv_menu_price,tv_menu_coupon,tv_menu_sailed;
        LinearLayout ll_list_item;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_menu_title = itemView.findViewById(R.id.tv_menu_title);
            tv_menu_des = itemView.findViewById(R.id.tv_menu_des);
            tv_menu_price = itemView.findViewById(R.id.tv_menu_price);
            tv_menu_coupon = itemView.findViewById(R.id.tv_menu_coupon);
            tv_menu_sailed = itemView.findViewById(R.id.tv_menu_sailed);
            iv_menu_item_image = itemView.findViewById(R.id.iv_menu_item_image);
            ll_list_item = itemView.findViewById(R.id.ll_list_item);

        }
    }
}
