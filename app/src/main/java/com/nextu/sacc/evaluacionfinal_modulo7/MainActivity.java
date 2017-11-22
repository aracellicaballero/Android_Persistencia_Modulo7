package com.nextu.sacc.evaluacionfinal_modulo7;

import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.io.ObjectOutputStream;

import constantes.Constantes;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    int idItem;
    DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);

        NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_view);
        //con esto generamos el usuario en el header del menu-------------------------------
        View hView = navigationView.getHeaderView(0);
        TextView correo = (TextView) hView.findViewById(R.id.text_email);
        TextView nombre = (TextView) hView.findViewById(R.id.text_nombre);

        // Busca el nombre del usuario que ingresó
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String nombre_preferencias = preferences.getString(Constantes.PREFERENCIA_NOMBRE, "");
        correo.setText(nombre_preferencias + "@parkingcontrol.com");
        nombre.setText(nombre_preferencias);
        //----------------------------------------------------------------------------------

        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        // Identificador del elemento seleccionado
        idItem = item.getItemId();
        View view = findViewById(R.id.nav_encabezado);

        // Fragmento que se muestra según la opción seleccionada
        Fragment fragment = null;

        // Acción según el elemento seleccionado
        switch (idItem){
            case R.id.nav_parqueos:
                fragment = new ParqueoFragment();
                break;

            case R.id.nav_micuenta:
                fragment = null;
                break;

        }

        // Muestra el fragmento según la selección
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.contenedor, fragment)
                .commit();

        // Cierra el drawer cuando se selecciona una de las opciones
        drawerLayout.closeDrawer(GravityCompat.START);

        return true;
    }

    public void capturarInfoVehiculoParqueo(VehiculoParqueo vehiculoParqueo){
        // Guardar
        try{
            ObjectOutputStream objOutput = new ObjectOutputStream(openFileOutput(Constantes.NOMBRE_ARCHIVO, MODE_PRIVATE));
            objOutput.writeObject(vehiculoParqueo);
            objOutput.close();
        }catch (IOException e){
            Toast.makeText(this, "Error al guardar el archivo", Toast.LENGTH_SHORT).show();
        }

    }
}
