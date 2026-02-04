package com.example.parcial_numero_2;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;
import com.google.android.material.carousel.CarouselLayoutManager;
import java.util.Arrays;
import java.util.List;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class HomeFragment extends Fragment {

    private Button move;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        if (move == null) {
            Log.e("HomeFragment", "Botón crear_relojes NO encontrado en fragment_home.xml");
        } else {
            move.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // Cambiar a otro fragment con FragmentManager (no Intent)
                    Fragment shopcartFragment = new ShopcartFragment();

                    requireActivity().getSupportFragmentManager()
                            .beginTransaction()
                            .replace(R.id.fragment_container, shopcartFragment)
                            .addToBackStack(null)
                            .commit();
                }
            });
        }

        return view;
    }


}