package tamid.com.br.conversorbasesnumericas;

import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText editTextDecimal;
    private EditText editTextBinario;
    private EditText editTextHexaDecimal;
    private EditText editTextOctal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextDecimal = findViewById(R.id.editTextDecimal);
        editTextBinario = findViewById(R.id.editTextBinario);
        editTextHexaDecimal = findViewById(R.id.editTextHexa);
        editTextOctal = findViewById(R.id.editTextOctal);
        Button botaoConverter = findViewById(R.id.buttonConverter);
        Button botaoLimpar = findViewById(R.id.buttonLimpar);

        botaoConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String sDecimal = editTextDecimal.getText().toString();
                String sBinario = editTextBinario.getText().toString();
                String sHexaDecimal = editTextHexaDecimal.getText().toString();
                String sOctal = editTextOctal.getText().toString();

                long decimal;
                String binario;
                String hexaDecimal;
                String octal;

                //verifica se existe nenhum campo preenchido
                if(sDecimal.isEmpty() && sBinario.isEmpty() && sHexaDecimal.isEmpty() &&
                        sOctal.isEmpty()) btOnClickDigitarNome();

                //verifica se o campo esta preenchido
                else if(!sDecimal.isEmpty()){
                    //pega a string digitada no campo e a transforma num inteiro
                    decimal = Long.parseLong(editTextDecimal.getText().toString());
                    //converte o numero decimal em um binário, do tipo string
                    binario = Long.toBinaryString(decimal);
                    //seta a string no campo de binario
                    editTextBinario.setText(binario);
                    //converte o numero decimal em um hexadecimal, do tipo string
                    hexaDecimal = Long.toHexString(decimal);
                    hexaDecimal = hexaDecimal.toUpperCase();
                    //seta a string no campo de hexadecimal
                    editTextHexaDecimal.setText(hexaDecimal);
                    //converte o numero decimal em um octal, do tipo string
                    octal = Long.toOctalString(decimal);
                    //seta a string no campo de octal
                    editTextOctal.setText(octal);

                }
                else if(!sBinario.isEmpty()){
                    //converte o binário do tipo string para um decimal inteiro
                    decimal = BaseNumerica.binarioParaDecimal(sBinario);
                    //seta o valor para o campo
                    editTextDecimal.setText(String.valueOf(decimal));
                    //converte o numero decimal em um hexadecimal, do tipo string
                    hexaDecimal = Long.toHexString(decimal);
                    hexaDecimal = hexaDecimal.toUpperCase();
                    //seta a string no campo de hexadecimal
                    editTextHexaDecimal.setText(hexaDecimal);
                    //converte o numero decimal em um octal, do tipo string
                    octal = Long.toOctalString(decimal);
                    //seta a string no campo de octal
                    editTextOctal.setText(octal);

                }
                else if(!sHexaDecimal.isEmpty()){
                    //converte o hexadecimal do tipo string para um decimal inteiro
                    decimal = BaseNumerica.hexaParaDecimal(sHexaDecimal);
                    //seta o valor para o campo
                    editTextDecimal.setText(String.valueOf(decimal));
                    //converte o numero decimal em um binário, do tipo string
                    binario = Long.toBinaryString(decimal);
                    //seta a string no campo de binario
                    editTextBinario.setText(binario);
                    //converte o numero decimal em um octal, do tipo string
                    octal = Long.toOctalString(decimal);
                    //seta a string no campo de octal
                    editTextOctal.setText(octal);

                }
                else {
                    //converte o octal do tipo string para um decimal inteiro
                    decimal = BaseNumerica.octaParaDecimal(sOctal);
                    //seta o valor para o campo
                    editTextDecimal.setText(String.valueOf(decimal));
                    //converte o numero decimal em um binário, do tipo string
                    binario = Long.toBinaryString(decimal);
                    //seta a string no campo de binario
                    editTextBinario.setText(binario);
                    //converte o numero decimal em um hexadecimal, do tipo string
                    hexaDecimal = Long.toHexString(decimal);
                    hexaDecimal = hexaDecimal.toUpperCase();
                    //seta a string no campo de hexadecimal
                    editTextHexaDecimal.setText(hexaDecimal);


                }


            }
        });

        botaoLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editTextDecimal.setText("");
                editTextBinario.setText("");
                editTextHexaDecimal.setText("");
                editTextOctal.setText("");
            }
        });
        BaseNumerica.setText(this, R.id.textVersao,
                getString(R.string.textViewVersao)+" "+BaseNumerica.getAppVersion(this));

    }
    public void btOnClickDigitarNome() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);
        alert.setTitle("Atenção");
        alert.setMessage("Preencha algum campo!");
        alert.setNeutralButton("Ok", null);
        alert.show();
    }

}
