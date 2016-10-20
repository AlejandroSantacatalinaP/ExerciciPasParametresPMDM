package prova.dam.pmdm.exercicipasparametrespmdm;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

/**
 * Created by Alejandro on 13/10/16.
 */
public class Sactivity extends AppCompatActivity {
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.edad);

        final EditText edad = (EditText) findViewById(R.id.edad);
        final Button bContinuar = (Button) findViewById(R.id.bContinuar);
        final TextView inv = (TextView) findViewById(R.id.invi);
        String tInv, nom;
        Bundle b;
        b=getIntent().getExtras();
        nom= b.getString("nom");
        tInv= ("Hola en "+nom+", indica'ns les següents dades...");
        inv.setText(tInv);

        bContinuar.setOnClickListener(new View.OnClickListener(){




            @Override
            public void onClick(View v) {

                    Intent i = new Intent();
                    Bundle b = new Bundle();
                    String e=edad.getText().toString();
                    int edadd=Integer.parseInt(e);
                    b.putInt("edad", edadd);
                    i.putExtras(b);
                    setResult(RESULT_OK, i);
                    finish();

            }
        });
    }
}
