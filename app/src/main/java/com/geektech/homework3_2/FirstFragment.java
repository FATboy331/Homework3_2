package com.geektech.homework3_2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class FirstFragment extends Fragment {

    private Button btnNext;
    public static String KEY_FOR_BUNDLE = "key";
    private EditText editText1;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnNext = view.findViewById(R.id.buttonFirstFragment);
        editText1 = view.findViewById(R.id.editFirstFragment);
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextFragment();
            }
        });


    }
    private void nextFragment(){
        Bundle bundle = new Bundle();
        bundle.putString(KEY_FOR_BUNDLE, editText1.getText().toString());
        SecondFragment fragment = new SecondFragment();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment).addToBackStack(null).commit();
    }
}