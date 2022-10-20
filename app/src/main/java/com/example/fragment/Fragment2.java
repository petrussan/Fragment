package com.example.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Fragment2 extends Fragment {
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_layout,container,false);
        TextView tv = v.findViewById(R.id.tv1);
        ImageView iv = v.findViewById(R.id.iv1);
        Button bt = v.findViewById(R.id.bt1);

        tv.setText("Ini Fragment no 2");
        iv.setImageResource(R.drawable.ic_launcher_foreground);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(requireActivity(), "Anda berada di Fragment no 2", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }
}
