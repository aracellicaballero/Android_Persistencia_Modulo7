package com.nextu.sacc.evaluacionfinal_modulo7;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import constantes.Constantes;

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

        // Verifica si se seleccionó el check "Recordarme".
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        if (preferences.getBoolean(Constantes.PREFERENCIA_RECORDARME, false)) {
            // Pasa a la siguiente activity
            startActivity(new Intent(this, MainActivity.class));
        }
    }

    public void onClickInicioSesion(View view) {
        Log.i("MENSAJE", usuario.getText().toString());
        // Valida que los campos estén completos
        if (usuario.getText().toString().equals("") || clave.getText().toString().equals("")) {
            Toast.makeText(this, R.string.completar_login, Toast.LENGTH_SHORT).show();

        } else {// Los datos están completos.
            // Guarda en preferencias el usuario, clave y check recordarme.
            // El nombre de usuario lo guarda para mostrarlo en el cajón de navegación.
            SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putBoolean(Constantes.PREFERENCIA_RECORDARME, recordarme.isChecked());
            editor.putString(Constantes.PREFERENCIA_NOMBRE, usuario.getText().toString());
            editor.putString(Constantes.PREFERENCIA_CLAVE, clave.getText().toString());
            editor.apply();

            // Ingresa al sistema. Muestra el ActivityMain.
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
