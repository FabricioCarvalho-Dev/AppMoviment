package com.example.AppMoviment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lllbmaps.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Date;

public class PerfilActivity extends AppCompatActivity {

    Button button_salvar_dados,bt_SHOW;
    EditText editText_NOME,Date_edit,text_KG,text_MTS;
    TextView tv_info;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        button_salvar_dados = findViewById(R.id.button_salvar_dados);
        bt_SHOW = findViewById(R.id.bt_SHOW);
        editText_NOME = findViewById(R.id.editText_NOME);
        text_KG = findViewById(R.id.text_KG);
        text_MTS = findViewById(R.id.text_MTS);
        Date_edit = findViewById(R.id.Date_edit);
        tv_info = findViewById(R.id.tv_info);


        button_salvar_dados.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences prefs = getSharedPreferences("cheveTester",MODE_PRIVATE);
                SharedPreferences.Editor editor = prefs.edit();
                editor.putString("ChaveNome",editText_NOME.getText().toString());
                editor.putString("ChaveData",Date_edit.getText().toString());
                editor.putString("ChaveKG",text_KG.getText().toString());
                editor.putString("ChaveMTS",text_MTS.getText().toString());

                editor.commit();

            }
        });

        bt_SHOW.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Nome,Data_nascimento,kilos,altura;
                SharedPreferences Prefs = getSharedPreferences("cheveTester",MODE_PRIVATE);

                Nome=Prefs.getString("ChaveNome","");
                Data_nascimento=Prefs.getString("ChaveData","");
                kilos=Prefs.getString("ChaveKG","");
                altura=Prefs.getString("ChaveMTS","");


                tv_info.setText(Nome+" \n"+Data_nascimento+" \n"+kilos+" \n"+altura);


            }
        });


    }
}
