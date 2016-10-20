package prova.dam.pmdm.exercicipasparametrespmdm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    protected void onSaveInstanceState(Bundle bund){
        final EditText nom = (EditText) findViewById(R.id.nom);
        RadioGroup sex = (RadioGroup) findViewById(R.id.sex);
        switch(sex.getCheckedRadioButtonId()){
            case R.id.fem:
                bund.putString("Gender","Male");
                break;
            case R.id.masc:
                bund.putString("Gender", "Female");
                break;
        }
        final Button bEnviar = (Button) findViewById(R.id.bEnviar);
        final TextView inv = (TextView) findViewById(R.id.inv);
        bund.putString("nom", nom.getText().toString());

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nom = (EditText) findViewById(R.id.nom);
        final RadioButton masc = (RadioButton) findViewById(R.id.masc);
        final RadioButton fem = (RadioButton) findViewById(R.id.fem);
        final Button bEnviar = (Button) findViewById(R.id.bEnviar);
        final TextView inv = (TextView) findViewById(R.id.inv);
        bEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Sactivity.class);
                Bundle b = new Bundle();
                b.putString("nom", nom.getText().toString());
                b.putString("masc", masc.getText().toString());
                b.putString("fem", fem.getText().toString());
                i.putExtras(b);
                startActivityForResult(i,1);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        final EditText nom = (EditText) findViewById(R.id.nom);
        final RadioButton masc = (RadioButton) findViewById(R.id.masc);
        final RadioButton fem = (RadioButton) findViewById(R.id.fem);
        final Button bEnviar = (Button) findViewById(R.id.bEnviar);
        final TextView inv = (TextView) findViewById(R.id.inv);
        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {

                Bundle b = data.getExtras();
                int edad = b.getInt("edad");
                nom.setEnabled(false);
                masc.setEnabled(false);
                fem.setEnabled(false);
                bEnviar.setEnabled(false);
                String res="error";
                if(edad>18 && edad<25){
                    res="ja eres major de edad";
                }else if (edad>=25 && edad<35){
                    res="estàs en la flor de la vida";
                }else if(edad>=35){
                    res = "ai, ai,...";
                }else{
                    res="k ase";
                }
                inv.setText(res);


            }
        }
    }
    }

