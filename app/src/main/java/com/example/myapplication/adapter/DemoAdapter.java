package com.example.myapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.R;
import com.example.myapplication.entity.ShopEntity;
import com.example.myapplication.entity.ShopEntity;

import java.util.List;

public class DemoAdapter extends RecyclerView.Adapter<DemoAdapter.ViewHolder>
{
    private List<ShopEntity> data;

    private Context context;

    public DemoAdapter(Context context)
    {
        this.context = context;
    }

    public void setData(List<ShopEntity> data)
    {
        this.data = data;
        // 刷新数据
        notifyDataSetChanged();
    }


    @Nullable
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i)
    {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_shop, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int index)
    {
        ShopEntity entity = data.get(index);
        Glide.with(context).load(entity.getImgUrl()).into(viewHolder.imgUrl);
        viewHolder.tvDesc.setText(entity.getDesc());
        viewHolder.tvSale.setText("领券    满"+entity.getSale()+"元");
        viewHolder.tvPrice.setText(entity.getPrice()+"");
        viewHolder.tvPerson.setText(entity.getPerson() + "");
    }

    /**
     * 返回Item的总数量
     */
    @Override
    public int getItemCount()
    {
        return data == null ? 0 : data.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder
    {
        ImageView imgUrl;
        TextView tvDesc;
        TextView tvSale;
        TextView tvPrice;
        TextView tvPerson;

        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            imgUrl = itemView.findViewById(R.id.img_url);
            tvDesc = itemView.findViewById(R.id.tv_desc);
            tvSale = itemView.findViewById(R.id.tv_sale);
            tvPrice = itemView.findViewById(R.id.tv_price);
            tvPerson = itemView.findViewById(R.id.tv_person);
        }
    }
}
