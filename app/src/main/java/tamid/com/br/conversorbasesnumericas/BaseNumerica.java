package tamid.com.br.conversorbasesnumericas;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.TextView;

public class BaseNumerica {

    public static long binarioParaDecimal( String binarioParaDecimal) {

        double soma = 0;
        int potencia = 0;
        long somaInteira = 0;
        for (int i = binarioParaDecimal.length() - 1; i >= 0; i--) {
            int numBinario = Integer.parseInt(String.valueOf(binarioParaDecimal.charAt(i)));
            double numPotencia = numBinario * (Math.pow(2, potencia));
            potencia++;
            soma = soma + numPotencia;
            somaInteira = (long) Math.round(soma);
        }
        return somaInteira;
    }

    // hexadecimal para decimal

    public static long hexaParaDecimal(String hexaParaDecimal) {

        double somaHexa = 0;
        int potenciaHexa = hexaParaDecimal.length() - 1;
        long somaInteiraHexa;
        int numHexa;

        //variaveis com valores fixos
        final String hexA = "A";
        final String hexB = "B";
        final String hexC = "C";
        final String hexD = "D";
        final String hexE = "E";
        final String hexF = "F";

        System.out.println(potenciaHexa);
        for (int i = 0; i < hexaParaDecimal.length(); i++) {

            if (hexA.equalsIgnoreCase(String.valueOf(hexaParaDecimal.charAt(i))))
                numHexa = 10;

            else if (hexB.equalsIgnoreCase(String.valueOf(hexaParaDecimal.charAt(i))))
                numHexa = 11;

            else if (hexC.equalsIgnoreCase(String.valueOf(hexaParaDecimal.charAt(i))))
                numHexa = 12;

            else if (hexD.equalsIgnoreCase(String.valueOf(hexaParaDecimal.charAt(i))))
                numHexa = 13;

            else if (hexE.equalsIgnoreCase(String.valueOf(hexaParaDecimal.charAt(i))))
                numHexa = 14;
            else if (hexF.equalsIgnoreCase(String.valueOf(hexaParaDecimal.charAt(i))))
                numHexa = 15;

            else {
                numHexa = Integer.parseInt(String.valueOf(hexaParaDecimal.charAt(i)));
            }

            double numPotenciaHexa = numHexa * (Math.pow(16, potenciaHexa));

            somaHexa = somaHexa + numPotenciaHexa;
            potenciaHexa--;
        }
        somaInteiraHexa = (long) Math.round(somaHexa);
        return somaInteiraHexa;
    }

    // octal para decimal
    public static long octaParaDecimal(String stringOctal) {

        int indicePotencia = stringOctal.length() - 1;
        double somaTotalOctal = 0;

        for (int i = 0; i < stringOctal.length(); i++) {
            int numOctal = Integer.parseInt(String.valueOf(stringOctal.charAt(i)));
            double somaNumeroOctal = numOctal * (Math.pow(8, indicePotencia));
            somaTotalOctal += somaNumeroOctal;
            indicePotencia--;
        }
        return (long) Math.round(somaTotalOctal);

    }
    //seta o TextView que informa a versao do app
    public static void setText(Activity act, int id, String idTexto){
        TextView versao = (TextView) act.findViewById(id);
        if (versao != null){
            versao.setText(idTexto);
        }

    }
    // obtém a versão do arquivo de manifesto
    public static String getAppVersion(Activity act){
        String versao = "?";
        try {
            PackageManager packageManager = act.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(act.getPackageName(),0);
            versao = packageInfo.versionName;
        }
        catch (Exception ignored){

        }
        return versao;
    }

}
