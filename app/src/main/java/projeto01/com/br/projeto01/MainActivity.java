package projeto01.com.br.projeto01;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.DecimalFormat;

import static android.support.v7.app.AlertDialog.*;

public class MainActivity extends AppCompatActivity {


    //declarar os atributos da Classe
    EditText edtNome, edtIdade;
    Button btnCalcular, btnLimpar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        /**
         * Atribuir os componentes visuais da activity_main
         * nos atributos da classe
         */

        edtNome = (EditText) findViewById(R.id.edtNome);
        edtIdade = (EditText) findViewById(R.id.edtIdade);


        btnCalcular = (Button) findViewById(R.id.btnCalcular);
        btnLimpar = (Button) findViewById(R.id.btnLimpar);



        //ação do método do botão Calcular

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
                 public void onClick(View view) {
                if (edtNome.getText().length() <= 0
                        || edtIdade.getText().length() <= 0) {
                    Toast.makeText(getBaseContext(), "Informe TODOS os campos!!!",
                            Toast.LENGTH_SHORT).show();
                    view.requestFocus();
                } else{
                    Double idade = Double.parseDouble(edtIdade.getText().toString());

                    Double idadeDias = idade * 365;

                    Builder alerta = new
                            Builder(MainActivity.this);

                    alerta.setTitle("IDADE EM DIAS");
                    alerta.setMessage("Sua idade em dias é : "
                            + new DecimalFormat("0.00").format(idadeDias));
                    alerta.setNeutralButton("Fechar", null);
                    alerta.show();
                }
            }
            });



            btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edtNome.setText("");
                edtIdade.setText("");
                edtNome.requestFocus();
            }
        });
    }
}
