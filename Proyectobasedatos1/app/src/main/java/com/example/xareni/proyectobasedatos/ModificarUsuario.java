package com.example.xareni.proyectobasedatos;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.xareni.proyectobasedatos.com.example.xareni.modelo.BaseDatos;



public class ModificarUsuario extends AppCompatActivity {

    private Button boton;
    private EditText clave;
    private EditText nombre;
    private EditText paterno;
    private EditText materno;
    private BaseDatos baseDatos;
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_modificar_usuario);



        clave=(EditText)findViewById(R.id.clave2);
        nombre=(EditText)findViewById(R.id.nombre2);
        materno=(EditText)findViewById(R.id.paterno2);
        paterno=(EditText)findViewById(R.id.materno2);

        baseDatos=new BaseDatos(this,"control",null,1);
        bd=baseDatos.getWritableDatabase();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }


    public void modificar(View v){

        int clave=Integer.parseInt(this.clave.getText().toString());
        String nombre=this.nombre.getText().toString();
        String paterno=this.paterno.getText().toString();
        String materno=this.materno.getText().toString();
        ContentValues registro=new ContentValues();
        registro.put("clave",clave);
        registro.put("nombre",nombre);
        registro.put("paterno",paterno);
        registro.put("materno",materno);
        //table,
        bd.update("persona", registro, "clave=" + clave, null);
        Toast.makeText(getApplicationContext(), "El usuario ha sido modificado correctamente.", Toast.LENGTH_LONG).show();



    }
    @Override
    public void onDestroy(){
        super.onDestroy();
        if(bd!=null){
            bd.close();
        }

    }
}
