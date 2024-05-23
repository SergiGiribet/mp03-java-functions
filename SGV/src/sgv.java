import javax.swing.*;
import java.io.IOException;
import java.util.Date;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.stream.IntStream;

public static class sgv {


    // Nom: netejaPantalla
// Descripció: Funció per netejar la pantalla,
    //      segons el sistema operatiu, necessita importar os
// @author: Sergi Giribet
// @param: Res
// @return: Res
    public static void netejaPantalla() {

        String os = System.getProperty("os.name").toLowerCase();

        try {
            //Si el sistema és Windows
            if (os.contains("win")) {
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();

            } else {
                // Si el sistema operatiu es Linux o Mac
                Runtime.getRuntime().exec("clear");
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }


    // Nom: tornaAleatori
// Descripció: Funció per tornar un valor aleatori en un interval
// @author: Sergi Giribet
// @param: valorMinim
//       Valor mínim per generar el nombre aleatori
// @param: valorMaxim
//       Valor màxim per generar el nombre aleatori
// @return: enter
//       Valor aleatori entre el valorMinim i el valorMaxim
//
    // NOTA: Fa servir la llibreria random
//

    public static int tornaAleatori(int minim, int maxim){
        return (int)(Math.random() * (maxim - minim)) + minim;
    }


// Nom: centrarText
// Descripció: Funció per centrar un cadena de text en una mateixa línia
// @author: Sergi Giribet
// @param: cadenaText
//       La cadena de text que imprimirà centrada
// @param: midaColumna
//       La mida de la columna a on cal que sigui centrada la cadena de text
// @return: Res

    public static String centrarText(String cadenaText, int midaColumna) {
        // Calcula la quantitat d'espais en blanc necessaris a cada costat de la cadena
        int espaisAAfegir = Math.max(0, midaColumna - cadenaText.length());
        int espaisAbans = espaisAAfegir / 2;
        int espaisDespres = espaisAAfegir - espaisAbans;

        // Crear la cadena d'espais abans i després
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < espaisAbans; i++) {
            sb.append(' ');
        }
        sb.append(cadenaText);
        for (int i = 0; i < espaisDespres; i++) {
            sb.append(' ');
        }

        // Torna la cadena modificada
        return sb.toString();
    }

    // Nom: pintaLineaCaracter
// Descripció: Funció per pintar un caracters
//      una determinada vegada, en una mateixa línia.
    // @author: Sergi Giribet
// @param: caracterAImprimir
//      Caracter a imprimir
// @param: vegades
//      Quantitat de vegades a imprimir el caracter
// @return: Res
    public static String pintaLineaCaracter(char caracterAImprimir, int vegades) {
        String cadenaImpresa = "";
        for (int i = 0; i < vegades; i++) {
            System.out.print(caracterAImprimir);
            cadenaImpresa += caracterAImprimir;
        }
        System.out.println();
        return cadenaImpresa;
    }


    // Nom: llegirEnterInterval
// Descripció: Funció per llegir un enter, mostrant el
//       text rebut (cadenaDemanarNombre) per demanar a l'usuari
    //       que entri un enter, comprès en un interval de nombres rebut.
    //       I mostrant un text d'Error, també rebut (cadenaError),
    //       pel cas que l'usuari entri alguna cosa que no sigui un decimal.
    //
    // @author: Sergi Giribet
// @param: cadenaDemanarNombre
//       Text a mostrar per demanar el nombre a l'usuari!
    // @param: cadenaError
//       Text a mostrar per a quan l'usuari entra un valor erroni.
    // @param: limitInferior
//       Límit inferior de l'interval de nombres a acceptar.
    // @param: limitSuperior
//       Límit superior de l'interval de nombres a acceptar.
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
                System.out.format("\tERROR!! %s \n\t¡Intenta-ho un altre cop!", cadenaError);
                teclat.next();
                continue;
            }
            if (enterPositiu >= limitInferior && enterPositiu <= limitSuperior) {
                break;
            } else {
                System.out.format("ERROR!! El número está fora del interval! ¡El número ha d'estar entre %d y %d !\n\t¡Intenta-ho un altre cop!", limitInferior, limitSuperior);
            }
        }
        return enterPositiu;
    }


    //  Nom: esDeTraspas
// Descripció: Funció per mostrar a saber si és un any de traspàs
// @author: Sergi Giribet
// @param: anyEntrat
//       any a revisar
// @return: true/false
//       Es mostraran per pantalla si és cert o fals.
    public static boolean esDeTraspas(int anyEntrat) {
        if ((anyEntrat % 400 == 0) || ((anyEntrat % 4 == 0) && (anyEntrat % 100 != 0))) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean esDeTraspasV2(int anyEntrat) {
        return (anyEntrat % 400 == 0) || ((anyEntrat % 4 == 0) && (anyEntrat % 100 != 0));
    }

    //  Nom: mostraVector
// Descripció: Funció per mostrar per pantalla el vector rebut
// @author: Sergi Giribet
// @param: vectorAMostrar
//       Vector a mostrar per pantalla
// @return: Res.
//       Es mostraran per pantalla els valors del vector.
    public static void mostraVector(String[] vectorAMostrar) {
// És un foreach
//  La sintaxi for (String s: vectorAMostrar) significa “per a cada element s en vectorAMostrar”.
//  En cada iteració del bucle, s se li assigna al següent element en vectorAMostrar.
        for (String s : vectorAMostrar)
            System.out.print(s);
        }


// Nom: llegirEnterPositiu
// Descripció: Funció per llegir un enter positiu, mostrant el
//       text rebut (cadenaDemanarNombre) per demanar a l'usuari
//       que entri un enter. I mostrant un text d'Error, també
//       rebut (cadenaError), pel cas que l'usuari entri alguna
//       cosa que no sigui un enter positiu.
// @author: Sergi Giribet
// @param: cadenaDemanarNombre
//       Text a mostrar per demanar el nombre a l'usuari!
//         @param: cadenaError
//       Text a mostrar per a quan l'usuari entra un valor erroni.
//         @return: enterPositiu
//       Enter positiu entrat per l'usuari.
    public static int llegirEnterPositiu(String cadenaDemanarNombre, String cadenaError){
        int enterPositiu = 0;
        Scanner teclat = new Scanner(System.in);
        while(true) {
            System.out.println(cadenaDemanarNombre);
            try{
                enterPositiu = teclat.nextInt();
                if (enterPositiu < 0) {
                    System.out.format("ERROR!! %s \nTorna a intentar-ho", cadenaError);
                } else {
                    break;
                }
            } catch (InputMismatchException e){
                System.out.format("ERROR!! %s \nTorna a intentar-ho", cadenaError);
                teclat.next(); // Aixó es necessari para netejar l'entrada incorrecta.
            }
        }
        return enterPositiu;
    }

// Nom: llegirDecimalPositiu
// Descripció: Funció per llegir un decimal positiu, mostrant el
//       text rebut (cadenaDemanarNombre) per demanar a l'usuari
//       que entri un decimal. I mostrant un text d'Error, també
//       rebut (cadenaError), pel cas que l'usuari entri alguna
//       cosa que no sigui un decimal positiu.
// @author: Sergi Giribet
// @param: cadenaDemanarNombre
//       Text a mostrar per demanar el nombre a l'usuari!
// @param: cadenaError
//       Text a mostrar per a quan l'usuari entra un valor erroni.
// @return: decimalPositiu
//       Decimal positiu entrat per l'usuari.

    public static float llegirDecimalPositiu(String cadenaDemanarNombre, String cadenaError){
        float decimalPositiu = 0;
        Scanner teclat = new Scanner(System.in);
            while(true) {
                System.out.println(cadenaDemanarNombre);
                try {
                    decimalPositiu = teclat.nextFloat();
                    if (decimalPositiu < 0) {
                        System.out.format("ERROR!! %s,\nTorna a intentar-ho!", cadenaError);
                    } else {
                        break;
                    }
                    } catch (InputMismatchException e) {
                    System.out.format("ERROR!! %s,\nTorna a intentar-ho!", cadenaError);
                    teclat.next();
                }
            }
            return decimalPositiu;
    }


//    Nom: llegirDecimalInterval
//Descripció: Funció per llegir un decimal, mostrant el
// text rebut (cadenaDemanarNombre) per demanar a l'usuari
//        que entri un decimal, comprès en un interval de nombres rebut.
//        I mostrant un text d'Error, també rebut (cadenaError),
//        pel cas que l'usuari entri alguna cosa que no sigui un decimal.
//
//        @author: Sergi Giribet
//@param: cadenaDemanarNombre
//Text a mostrar per demanar el nombre a l'usuari!
//        @param: cadenaError
//Text a mostrar per a quan l'usuari entra un valor erroni.
//        @param: limitInferior
//Límit inferior de l'interval de nombres a acceptar.
//        @param: limitSuperior
//Límit superior de l'interval de nombres a acceptar.
//        @return: decimalPositiu
//Decimal positiu entrat per l'usuari i que està comprès
//        En l'interval de nombres també rebut.

    public static float llegirDecimalInterval(String cadenaDemanarNombre, String cadenaError,
                                              int limitInferior, int limitSuperior) {
        float decimalPositiu = 0;
        Scanner teclat = new Scanner(System.in);
        while (true) {
            System.out.println(cadenaDemanarNombre);
            try {
                decimalPositiu = teclat.nextFloat();

                if ((decimalPositiu >= limitInferior) & (decimalPositiu <= limitSuperior)) {
                    break;
                } else {
                    System.out.format("\tERROR!! el nombre està fora de l'interval!\n\tEl nombre ha d'estar entre %d i %d !\n\tTorna a intentar-ho!", limitInferior, limitSuperior);
                }
            } catch (InputMismatchException e) {
                System.out.format("\tERROR!! %s \n\tTorna a intentar-ho!", cadenaError);
                teclat.next();
            }
        }
        return decimalPositiu;
    }

// Nom: esParell
// Descripció: Funció per esbrinar si el número rebut és parell o no
// @author: Sergi Giribet
// @param: numeroAAnalitzar
//       número rebut per esbrinar si és parell o no
// @return: booleà
//       True veritat si el número rebut és parell.
//       False falç si el número rebut NO és parell.
    public static boolean esParell(float numeroAAnalitzar) {
        return (numeroAAnalitzar % 2 == 0);
    }


// Nom: hipotenusa
// Descripció: Funció per esbrinar la hipotenusa d'un triangle rectangle
//       a partir dels dos catets del triangle rectangle
// @author: Sergi Giribet
// @param: catetRebut1
//       número que representa el 1r dels catets del triangle rectangle
// @param: catetRebut2
//       número que representa el 2n dels catets del triangle rectangle
// @return: el valor de la hipotenusa d'un triangle rectangle
//       a partir dels dos catets del triangle rectangle rebuts.
//       Fent servir el teorema de Pitàgores.

    public static float hipotenusa(float catetRebut1, float catetRebut2){
            return (float) Math.sqrt(catetRebut1*2 + catetRebut2*2);
    }



// Nom: entraUnCaracter
// Descripció: 
// @author: Sergi Giribet
// @param: cadenaDemanarCaracter
//       caracter a llegir
// @param: cadena error
//       cadena a mostrar quan hi hagi algun error
// @return: El caracter llegit
    public static String entraUnCaracter(String cadenaDemanarCaracter, String cadenaError) {
        Scanner teclat = new Scanner(System.in);
        String caracterLlegit;

        while (true) {
            System.out.println(cadenaDemanarCaracter);
            caracterLlegit = teclat.nextLine();
            if ((caracterLlegit).length() != 1) {
                System.out.println(cadenaError);

            } else {
                break;
            }
        }
        return (caracterLlegit);
    }



// Nom: substituirCaracter
// Descripció:
// @author: Sergi Giribet
// @param: cadena.
//       Cadena entrada per l'usuari
// @param: caracterASubstituir
//       caracter que volem canviar
// @param: caracterNou
//       caracter que volem posar
// @return: El caracter llegit
public static String substituirCaracter(String cadena, char caracterASubstituir, char caracterNou){
    // Definició de variables
    StringBuilder cadenaNova = new StringBuilder();

    int posicio = 0;
    int finalCadena = cadena.length();

    // Inicialització de variables
    while(posicio < finalCadena){
        if (cadena.charAt(posicio) == caracterASubstituir){
            cadenaNova.append(caracterNou);
        } else {
            cadenaNova.append(cadena.charAt(posicio));
        }

        posicio++;
    }
    return cadenaNova.toString();
}

// Nom: eliminaAccents
// Descripció:
// @author: Sergi Giribet
// @param: cadenaRebuda
//       cadena entrada per l'usuari
// @param: caracterASubstituir
//       caracter que volem canviar
// @param: caracterNou
//       caracter que volem posar
// @return: El caracter llegit
public static String eliminaAccents(String cadenaRebuda){
String cadenaNeta = "";


cadenaNeta = substituirCaracter(cadenaRebuda,'à','a');
cadenaNeta = substituirCaracter(cadenaNeta,'á','a');
cadenaNeta = substituirCaracter(cadenaNeta,'è','e');
cadenaNeta = substituirCaracter(cadenaNeta,'é','e');
cadenaNeta = substituirCaracter(cadenaNeta,'ì','i');
cadenaNeta = substituirCaracter(cadenaNeta,'í','i');
cadenaNeta = substituirCaracter(cadenaNeta,'ò','o');
cadenaNeta = substituirCaracter(cadenaNeta,'ó','o');
cadenaNeta = substituirCaracter(cadenaNeta,'ù','u');
cadenaNeta = substituirCaracter(cadenaNeta,'ú','u');
cadenaNeta = substituirCaracter(cadenaNeta,'ä','a');
cadenaNeta = substituirCaracter(cadenaNeta,'ë','e');
cadenaNeta = substituirCaracter(cadenaNeta,'ï','i');
cadenaNeta = substituirCaracter(cadenaNeta,'ö','o');
cadenaNeta = substituirCaracter(cadenaNeta,'ü','u');


    return cadenaNeta;
}



    static Scanner teclat = new Scanner(System.in);

    public static int[][] crearMatriuSuperior(int midaMatriu){
        int[][] matriuIdentitat = new int[midaMatriu][midaMatriu];
        // for per recorre les files
        for (int fila = 0; fila < midaMatriu; fila++) {
            // for per recorre les columnes
            for (int columna = 0; columna < matriuIdentitat[fila].length; columna++) {
                if ((fila == columna) || (fila<columna)){
                    matriuIdentitat[fila][columna] = 1;
                } else
                    matriuIdentitat[fila][columna] = 0;
            }
        }
        return matriuIdentitat;
    }


    public static int[][] ompleMatriuQuadradaEntersAleatori(int midaMatriu) {
        int[][] matriuPlena = new int[midaMatriu][midaMatriu];

        // for per recorre les files
        for (int fila = 0; fila < midaMatriu; fila++) {
            //for per a recorre les columnes
            for (int columna = 0; columna < matriuPlena[fila].length; columna++) {
                matriuPlena[fila][columna] = tornaAleatori(1,100);
            }
        }
        return matriuPlena;
    }

    public static int[][] ompleMatriuQuadradaEnters(int midaMatriu){
        int[][] matriuPlena = new int[midaMatriu][midaMatriu];

        // for i per recórrer les files
        for (int fila = 0; fila < midaMatriu; fila++) {
            // for i per recórrer les columnes
            for (int columna = 0; columna < matriuPlena[fila].length; columna++) {
                matriuPlena[fila][columna] = demanaEnter(
                        "Entra un enter per la posició " + (fila + 1)
                                + "," + (columna + 1) + " : ");
            }
        }
        return matriuPlena;
    }


    public static void mostraMatriuEnters(int[][] matriuEntersAMostrar){
        int elementActual;
        // for i per recórrer les files
        for (int fila = 0; fila < matriuEntersAMostrar.length; fila++) {
            // for i per recórrer les columnes
            for (int columna = 0; columna < matriuEntersAMostrar[fila].length; columna++) {
                elementActual = matriuEntersAMostrar[fila][columna];
                if(elementActual<10){
                    System.out.print("  ");
                } else {
                    System.out.print(" ");
                }
                System.out.print(String.valueOf(elementActual));
            }
            System.out.println("");
        }
    }


    /**
     78 14 6 47 70          78 14 #6 47 70
     16 30 52 14 78         16 30 52 14 78
     45 63 38 94 23         45 63 38 94 23
     7 43 7 43 76           #7 43 #7 43 76
     85 11 25 51 11         85 11 25 51 11

     */

    public static void mostraVectorEnters(int[] vectorAMostrar){
        // for per recórrer i mostrar el contingut del vector
        for (int i = 0; i < vectorAMostrar.length; i++) {
            System.out.printf(String.valueOf(vectorAMostrar[i]));
            if(i != vectorAMostrar.length -1 ){
                System.out.printf("-");
            }
        }
    }

    public static String demanaCadena(String cadenaDemanaCadena){
        String cadenaLlegida = "";
        System.out.print(cadenaDemanaCadena);
        try {
            cadenaLlegida = teclat.nextLine();
        } catch (InputMismatchException e) {
            System.out.println("ERROR!\nTorna-hi!");
        } finally {
            teclat = new Scanner(System.in);
        }
        return cadenaLlegida;
    }


    public static int demanaEnter(String cadenaDemanaEnter){
        int enterLlegit = 0;
        boolean correcte = false;

        // do while per controlar que l'usuari no entri
        // un valor que no sigui un enter positiu
        do{
            System.out.print(cadenaDemanaEnter);
            try {
                enterLlegit = teclat.nextInt();
                if(enterLlegit > 0){
                    correcte = true;
                } else {
                    System.out.println("ERROR!\nTorna-hi!");
                }
            } catch (InputMismatchException e) {
                System.out.println("ERROR!\nTorna-hi!");
            } finally {
                teclat = new Scanner(System.in);
            }
        }while(!correcte);
        //while(correcte != true);

        return enterLlegit;
    }

}




public void main() {
}
