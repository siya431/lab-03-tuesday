package com.example.listycitylab3;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class EditFragment extends Fragment {

    private City city;  // store city as instance variable

    // Constructor with city parameter
    public EditFragment(City city) {
        this.city = city;
    }

    // Empty constructor required for fragment manager (for new additions)
    public EditFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_edit, container, false);

        EditText nameInput = view.findViewById(R.id.edit_city_name);
        EditText provinceInput = view.findViewById(R.id.edit_city_province);
        Button saveButton = view.findViewById(R.id.button_save);

        if (city != null) {
            nameInput.setText(city.getName());
            provinceInput.setText(city.getProvince());
        }

        saveButton.setOnClickListener(v -> {
            if (city != null) {
                city.setName(nameInput.getText().toString());
                city.setProvince(provinceInput.getText().toString());
            }
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        return view;
    }
}

