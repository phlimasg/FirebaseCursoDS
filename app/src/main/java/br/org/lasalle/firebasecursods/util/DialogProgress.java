package br.org.lasalle.firebasecursods.util;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.DialogFragment;

import org.jetbrains.annotations.Nullable;

import br.org.lasalle.firebasecursods.R;


public class DialogProgress extends DialogFragment {


    public DialogProgress(){
    }




    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }



    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);


        View view = inflater.inflate(R.layout.dialog_progress,container);
       
        setRetainInstance(true);



        return view;
    }


    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        setCancelable(false);
    }




}
