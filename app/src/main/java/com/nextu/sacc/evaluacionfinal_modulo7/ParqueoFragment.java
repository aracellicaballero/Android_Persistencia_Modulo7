package com.nextu.sacc.evaluacionfinal_modulo7;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ParqueoFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Infla
        return inflater.inflate(R.layout.fragment_parqueo, container, false);

        // Botón
        //FloatingActionButton button;
        //button = (FloatingActionButton) container.findViewById(R.id.fab_agregar);


    }

    public void onClickNuevoParqueo(View view){
        ((MainActivity)getActivity()).capturarInfoVehiculoParqueo(new VehiculoParqueo("id_cliente", "placa"));


    }
}
