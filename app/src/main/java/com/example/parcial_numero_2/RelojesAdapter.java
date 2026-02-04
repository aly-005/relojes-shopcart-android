package com.example.parcial_numero_2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RelojesAdapter extends RecyclerView.Adapter<RelojesAdapter.VH> {

    List<ClaseReloj> list;

    DatabaseHelper myDB;


    public interface OnAddToCartListener {
        void onAddToCart(CartItem item);
    }

    private OnAddToCartListener addListener;

    public RelojesAdapter(List<ClaseReloj> list,
                          DatabaseHelper myDB,
                          OnAddToCartListener addListener) {
        this.list = list;
        this.myDB = myDB;
        this.addListener = addListener;
    }



    public static class VH extends RecyclerView.ViewHolder {
        TextView modelo, marca, descripcion, precio;
        Button btnBorrar, btnAgregar;

        public VH(View v) {
            super(v);
            modelo = v.findViewById(R.id.wt_modelo);
            marca = v.findViewById(R.id.wt_marca);
            descripcion = v.findViewById(R.id.wt_descripcion);
            precio = v.findViewById(R.id.wt_precio);

            btnBorrar = v.findViewById(R.id.btnBorrar);
            btnAgregar = v.findViewById(R.id.btnAgregarReloj);
        }
    }



    @Override
    public VH onCreateViewHolder(ViewGroup p, int viewType) {
        View v = LayoutInflater.from(p.getContext())
                .inflate(R.layout.item_reloj, p, false);
        return new VH(v);
    }



    @Override
    public void onBindViewHolder(VH h, int position) {
        ClaseReloj w = list.get(position);
        h.modelo.setText(w.getModelo());
        h.marca.setText(w.getMarca());
        h.descripcion.setText(w.getDescripcion());
        h.precio.setText(String.valueOf(w.getPrecio()));

        h.btnBorrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int pos = h.getBindingAdapterPosition();
                if (pos != RecyclerView.NO_POSITION) {
                    ClaseReloj reloj = list.get(pos);
                    boolean borrado = myDB.deleteById(reloj.getId());
                    if (borrado) {
                        list.remove(pos);
                        notifyItemRemoved(pos);

                    } else {

                    }
                }
            }
        });

        h.btnAgregar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean ok = myDB.addToShoppingList(
                        w.getModelo(),
                        w.getMarca(),
                        w.getDescripcion(),
                        w.getPrecio()
                );
            }
        });


    }


    public void updateData(List<ClaseReloj> nuevos) {
        this.list = nuevos;
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

}
