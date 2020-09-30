package com.example.mydemo.fragemt;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mydemo.R;

public class SecondFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });
        String arg=getArguments().getString("name");
        String arg2=getArguments().getString("name2");
        String arg3=getArguments().getString("name3");
        ((TextView) (view.findViewById(R.id.textview_second))).setText(getString(R.string.hello_second_fragment, arg));
        ((TextView) (view.findViewById(R.id.textView2))).setText(getString(R.string.hello_second_fragment, arg2));
        ((TextView) (view.findViewById(R.id.textView3))).setText(getString(R.string.hello_second_fragment, arg3));
    }
}