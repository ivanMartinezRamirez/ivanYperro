package com.example.xareni.proyectobasedatos;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.xareni.proyectobasedatos.com.example.xareni.modelo.BaseDatos;

public class ConsultarUsuario extends AppCompatActivity {

    private EditText clave;
    private TextView salida;
    private BaseDatos baseDatos;
    private SQLiteDatabase bd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_usuario);

        clave=(EditText)findViewById(R.id.clave);
        salida=(TextView)findViewById(R.id.salida);
        baseDatos=new BaseDatos(this,"control",null,1);
        bd=baseDatos.getReadableDatabase();

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


    public void consultar(View v){
        int clave=Integer.parseInt(this.clave.getText().toString());
        Cursor fila=bd.rawQuery("select * from persona where clave="+clave,null);
        if(fila.moveToFirst()){
            String datos="Los datos del usuario son "+fila.getString(0)+" "+ fila.getString(1)+" "+fila.getString(2)+" "+fila.getString(3);
            salida.setText(datos);
        }
        else{
            Toast.makeText(getApplicationContext(),"Este usuario no se encuentra registrado",Toast.LENGTH_LONG).show();
        }


    }
}
