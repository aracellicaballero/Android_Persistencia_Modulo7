import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.view.View;
import android.widget.Button;

import com.nextu.sacc.evaluacionfinal_modulo7.R;
import com.nextu.sacc.evaluacionfinal_modulo7.VehiculoParqueo;

import java.io.IOException;
import java.io.ObjectOutputStream;

import static android.content.Context.MODE_PRIVATE;

/**
 * Created by Sara Caballero C on 2017/11/21.
 */

public class Dialogo extends DialogFragment {

    private String nombre_archivo = "vehiculo.obj";

    public interface OnNuevoVehiculoListener {
        void onAgregarVehiculoListener();
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        // Asigna la vista al builder
        View view = getActivity().getLayoutInflater().inflate(R.layout.dialog_info_vehiculo, null);
        builder.setView(view);

        // Botones
        Button registrar = (Button) view.findViewById(R.id.btn_registrar);
        Button cancelar = (Button) view.findViewById(R.id.btn_cancelar);

        registrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Guarda la información del vehiculo.

            }
        });

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();  // Cierra
            }
        });

        return builder.create();
    }
}
