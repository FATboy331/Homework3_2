package com.geektech.homework3_2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;


public class SecondFragment extends Fragment {

    public static String KEY_FOR_BUNDLE_TWO = "key";
    private Button btnNext;
    private EditText editText;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        btnNext = view.findViewById(R.id.buttonSecondFragment);
        editText = view.findViewById(R.id.editSecondFragment);
        if (getArguments() != null) {
            String value = getArguments().getString(FirstFragment.KEY_FOR_BUNDLE);
            editText.setText(value);
        }
        getArguments();
        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nextFragment();
            }
        });


    }
    private void nextFragment(){
        Bundle bundle = new Bundle();
        bundle.putString(KEY_FOR_BUNDLE_TWO,editText.getText().toString());
        ThreeFragment fragment = new ThreeFragment();
        fragment.setArguments(bundle);
        requireActivity().getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, fragment).addToBackStack(null).commit();
    }
}