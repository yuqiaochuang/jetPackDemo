package com.example.mydemo.fragemt;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.SavedStateViewModelFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.fragment.NavHostFragment;

import com.example.model.FIndexModel;
import com.example.mydemo.R;
import com.example.mydemo.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {
    FIndexModel fIndexModel;
    FragmentFirstBinding mainBinding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        fIndexModel = new ViewModelProvider(getActivity(), new ViewModelProvider.AndroidViewModelFactory(getActivity().getApplication())).get(FIndexModel.class);
        mainBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_first, container, false);
        mainBinding.setModel(fIndexModel);
        mainBinding.setLifecycleOwner(getActivity());
        return mainBinding.getRoot();
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_first, container, false);
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

//
//        String arg = ((EditText) (view.findViewById(R.id.inputEdit))).getText().toString();
//        Bundle bundle = new Bundle();
//        bundle.putString("name3", arg.isEmpty() ? "我是默认的" : arg);
//        view.findViewById(R.id.button_first).setOnClickListener(Navigation.createNavigateOnClickListener(R.id.action_FirstFragment_to_SecondFragment, bundle));

        mainBinding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View sview) {

//                if (mainBinding.scoreEdit.getText().toString().isEmpty()) {
//                    Toast.makeText(getActivity(), "请输入", Toast.LENGTH_LONG).show();
//                    return;
//                }
//                fIndexModel.getAScore().setValue(Integer.parseInt(mainBinding.scoreEdit.getText().toString()));

                NavHostFragment.findNavController(FirstFragment.this)
                        .navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

    }
}