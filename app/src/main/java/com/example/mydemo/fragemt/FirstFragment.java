package com.example.mydemo.fragemt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;

import com.example.mydemo.R;

public class FirstFragment extends Fragment {

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false);
    }

    public void onViewCreated(@NonNull final View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


//        view.findViewById(R.id.button_first).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View sview) {
//                String arg = ((EditText)(view.findViewById(R.id.inputEdit))).getText().toString();
//                if (arg == null) {
//                    Toast.makeText(getActivity(), "请输入", Toast.LENGTH_LONG).show();
//                    return;
//                }
//                Bundle bundle = new Bundle();
//                bundle.putString("name2", arg);
//                NavHostFragment.findNavController(FirstFragment.this)
//                        .navigate(R.id.action_FirstFragment_to_SecondFragment, bundle);
//            }
//        });


        String arg = ((EditText) (view.findViewById(R.id.inputEdit))).getText().toString();
        Bundle bundle = new Bundle();
        bundle.putString("name3", arg.isEmpty() ? "我是默认的" : arg);
        view.findViewById(R.id.button_first).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_FirstFragment_to_SecondFragment, bundle));
    }
}