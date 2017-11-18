package com.nextu.sacc.evaluacionfinal_modulo7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import constantes.ConstantesPreferencias;

public class LoginActivity extends AppCompatActivity {
    // Referencias a los controles.
    private EditText usuario;
    private EditText clave;
    private CheckBox recordarme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        // Inicializa las referencias a los controles
        usuario = (EditText) findViewById(R.id.txt_nombre_usuario);
        clave = (EditText) findViewById(R.id.txt_password);
        recordarme = (CheckBox) findViewById(R.id.chk_recordarme);
    }

    public void onClickInicioSesion(View view) {
        // Valida que los campos estén completos
        if (usuario.getText().equals("") || clave.getText().equals("")) {
            Toast.makeText(this, R.string.completar_login, Toast.LENGTH_SHORT).show();

        } else {// Los datos están completos.
            // Guarda en preferencias el usuario, clave y check recordarme
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(ConstantesPreferencias.PREFERENCIA_NOMBRE, usuario.getText().toString());
            editor.putString(ConstantesPreferencias.PREFERENCIA_CLAVE, clave.getText().toString());
            editor.putBoolean(ConstantesPreferencias.PREFERENCIA_RECORDARME, recordarme.isChecked());
            editor.apply();

            // Ingresa al sistema. Muestra el ActivityMain.
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
