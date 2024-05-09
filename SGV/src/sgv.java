import java.io.IOException;
import java.util.Date;
import java.util.Scanner;

public class sgv {


// Nom:      netejaPantalla
// Descripció: Funció per netejar la pantalla,
        //      segons el sistema operatiu, necessita importar os
// @author:  Sergi Giribet
// @param:   Res
// @return:  Res
    public static void netejaPantalla(){

        String os = System.getProperty("os.name").toLowerCase();

        try {
            //Si el sistema es windows
            if (os.contains("win")){
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            } else {
                // Si el sistema operativo es Linux o Mac
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    // Nom:      aleatori
// Descripció: Funció per tornar un valor aleatori en un interval
// @author:  Sergi Giribet
// @param:   valorMinim
//       Valor mínim per generar el nombre aleatori
// @param:   valorMaxim
//       Valor màxim per generar el nombre aleatori
// @return: enter
//       Valor aleatori entre el valorMinim i el valorMaxim
//
        // NOTA: Fa servir la llibreria random
//
    public static int aleatori(int valorMinim, int valorMaxim){
        return (int)(Math.random() * (valorMaxim - valorMaxim)) + valorMinim;
    }


// Nom:      centrarText
// Descripció: Funció per centrar un cadena de text en un mateixa línia
// @author:  Sergi Giribet
// @param:   cadenaText
//       La cadena de text que imprimirà centrada
// @param:   midaColumna
//       La mida de la columna a on cal centrada la cadena de text
// @return:  Res

    public static String centrarText(String cadenaText, int midaColumna){
        // Calcula la quantitat d'espais en blanc necessaris a cada costat de la cadena
        int espaisAAfegir = Math.max(0, midaColumna - cadenaText.length());
        int espaisAbans = espaisAAfegir / 2;
        int espaisDespres = espaisAAfegir - espaisAbans;

        // Crear la cadena d'espais abans y despres
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < espaisAbans; i++) {
            sb.append(' ');
        }
        sb.append(cadenaText);
        for(int i = 0; i < espaisDespres; i++) {
            sb.append(' ');
        }

        // Torna la cadena modificada
        return sb.toString();
    }

// Nom:      pintaLiniaCaracter
// Descripció: Funció per pintar un caracters
//      un determinada vegada, en una mateixa línia.
            // @author:  Sergi Giribet
// @param:   caracterAImprimir
//      Caracter a imprimir
// @param:   vegades
//      Quantitat de vegades a imprimir el caracter
// @return:  Res
    public static String pintaLiniaCaracter(char caracterAImprimir, int vegades) {
        String cadenaImpresa = "";
        for(int i = 0; i < vegades; i++ ) {
            System.out.print(caracterAImprimir);
            cadenaImpresa += caracterAImprimir;
        }
        System.out.println();
        return cadenaImpresa;
    }


    // Nom:      llegirEnterInterval
// Descripció: Funció per llegir un enter, mostrant el
//       text rebut (cadenaDemanarNombre) per demanar a l'usuari
            //       que entri un enter, comprès en un interval de nombres rebut.
            //       I mostrant un text d'Error, també rebut (cadenaError),
            //       pel cas que l'usuari entri alguna cosa que no sigui un decimal.
            //
            // @author:  Sergi Giribet
// @param:   cadenaDemanarNombre
//       Text a mostrar per demanar el nombre a l'usuari!
            // @param:   cadenaError
//       Text a mostrar per quan l'usuari entra un valor erroni.
            // @param:   limitInferior
//       Limit inferior de l'interval de nombres a acceptar.
            // @param:   limitSuperior
//       Limit superior de l'interval de nombres a acceptar.
            // @return: decimalPositiu
//       Decimal positiu entrat per l'usuari i que està comprès
            //       en l'interval de nombres també rebut.
    public static int llegirEnterInterval(String cadenaDemanarNombre, String cadenaError, int limitInferior, int limitSuperior) {

        Scanner teclat = new Scanner(System.in);
        int enterPositiu = 0;

        while (true) {
            System.out.print(cadenaDemanarNombre);
            try {
                enterPositiu = teclat.nextInt();

            } catch (Exception e) {
                System.out.format("\tERROR!! %s \n\t¡Inténtalo de nuevo!", cadenaError);
                teclat.next();
                continue;
            }
            if (enterPositiu >= limitInferior && enterPositiu <= limitSuperior) {
                break;
            } else {
                System.out.format("ERROR!! El número está fuera del intervalo! ¡El número debe estar entre %d y %d !\n\t¡Inténtalo de nuevo!", limitInferior, limitSuperior);
            }
        }
        return enterPositiu;
    }


    // Es any de traspas
    public static boolean esDeTraspas(int anyEntrat){
            if ( (anyEntrat%400 == 0) || ( (anyEntrat%4 == 0) && (anyEntrat%100 != 0) )){
                return true;
            } else {
                return false;
            }
    }





}



