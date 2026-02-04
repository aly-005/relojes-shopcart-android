package com.example.parcial_numero_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.VH> {
    private List<ClaseReloj> list;
    private CartListener listener;

    public interface CartListener {
        void onCartUpdated();
    }

    public CartAdapter(List<ClaseReloj> list, CartListener listener) {
        this.list = list;
        this.listener = listener;
    }

    public static class VH extends RecyclerView.ViewHolder {
        ImageView img;
        TextView name, price;
        Button btnRemove;

        public VH(View v) {
            super(v);
            img = v.findViewById(R.id.cart_img);
            name = v.findViewById(R.id.cart_name);
            price = v.findViewById(R.id.cart_price);
            btnRemove = v.findViewById(R.id.cart_btnRemove);
        }
    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cart, parent, false);
        return new VH(v);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
        ClaseReloj item = list.get(position);
        holder.img.setImageResource(R.drawable.imagen1); //Imagen por defecto para identificar cada reloj ------------------------
        holder.name.setText(item.getModelo());
        holder.price.setText(String.format("$%s", item.getPrecio()));

        holder.btnRemove.setOnClickListener(v -> {
            DatabaseHelper dbHelper = new DatabaseHelper(v.getContext());
            if (dbHelper.deleteById(item.getId())) {
                list.remove(position);
                notifyItemRemoved(position);
                notifyItemRangeChanged(position, list.size());
                listener.onCartUpdated();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}