package com.example.parcial_numero_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ShopcartFragment extends Fragment {
    private RecyclerView recyclerView;
    private TextView emptyView, totalView;
    private CartAdapter adapter;
    private DatabaseHelper dbHelper;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopcart, container, false);

        recyclerView = view.findViewById(R.id.rv_cart);
        emptyView = view.findViewById(R.id.tv_empty);
        totalView = view.findViewById(R.id.tv_total);

        dbHelper = new DatabaseHelper(getContext());

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        loadCartData();

        return view;
    }

    private void loadCartData() {
        List<ClaseReloj> cartItems = dbHelper.getAll();

        if (cartItems.isEmpty()) {
            emptyView.setVisibility(View.VISIBLE);
            recyclerView.setVisibility(View.GONE);
            totalView.setVisibility(View.GONE);
        } else {
            emptyView.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            totalView.setVisibility(View.VISIBLE);

            adapter = new CartAdapter(cartItems, new CartAdapter.CartListener() {
                @Override
                public void onCartUpdated() {
                    updateCartTotal();
                }
            });
            recyclerView.setAdapter(adapter);

            updateCartTotal();
        }
    }

    private void updateCartTotal() {
        double total = dbHelper.calcularTotalCarrito();
        totalView.setText(String.format("Total: $%.2f", total));
    }

    @Override
    public void onResume() {
        super.onResume();
        loadCartData(); // Refrescar datos al volver al fragmento----------------
    }
}