package com.example.mydemo.fragemt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.model.FIndexModel;
import com.example.mydemo.R;
import com.example.mydemo.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {
    FIndexModel fIndexModel;
    FragmentSecondBinding mainBinding;
    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        fIndexModel = new ViewModelProvider(getActivity(), new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(FIndexModel.class);
        mainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_second, container, false);
        mainBinding.setModel(fIndexModel);
        mainBinding.setLifecycleOwner(getActivity());
        return mainBinding.getRoot();

        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_second, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.button_second).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                fIndexModel.save();
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