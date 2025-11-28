import java.util.Arrays;
import java.util.Random;
public class LoteriaPrimitiva {
    public static void main(String[] args) {
        /**
         * Creo 2 array con un tamaño de 6
         */
        int[] combinacionNumeros = new int[6];
        int[] numerosApuestas = new int[6];

        Random aleatorio = new Random(); //para crear combinacionNumeros aleatorios, creo un objeto

        System.out.println("----Combinación de números------");
        for(int inicio = 0 ; inicio < 6 ; inicio++){
            /**
             * Genero un números aleatorios del 1 al 49
             * y los almaceno en el array
             */
            combinacionNumeros[inicio] = aleatorio.nextInt(48)+1;
            System.out.print(combinacionNumeros[inicio] + ", ");
        }
        System.out.println();

        /**
         * Ordena el arrayde menor a mayor
         */
        Arrays.sort(combinacionNumeros);
        for(int inicio = 0 ; inicio < 6; inicio++){
            System.out.print(combinacionNumeros[inicio] + ", ");
        }
        System.out.println();

        System.out.println("-----Números de la apuesta-------");
        for(int inicio = 0 ; inicio < 6 ; inicio++){
            /**
             * Genero un números aleatorios del 1 al 49
             * y los almaceno en el array
             */
            numerosApuestas[inicio] = aleatorio.nextInt(48)+1; //guardo los valores aleatorios
            System.out.print(numerosApuestas[inicio] + ", ");
        }
        System.out.println();

        /**
         * Ordena el arrayde menor a mayor
         */
        Arrays.sort(numerosApuestas);
        for(int inicio = 0 ; inicio < 6; inicio++){
            System.out.print(numerosApuestas[inicio] + ", ");
        }
        System.out.println();
        System.out.println("------------------------");

        System.out.print("La combinación ganadora es: ");
        for( int n : combinacionNumeros){
            System.out.print(n + ", ");
        }
        System.out.println();
        System.out.print("Los números de la apuesta son:");
        for( int n : numerosApuestas){
            System.out.print(n + ", ");
        }
        System.out.println();
        /**
         * invoco al metodo acertos pasando por parametro los array
         */
        System.out.println("Ha habido " + Aciertos(numerosApuestas,combinacionNumeros) + " aciertos.");

        System.out.println("Ha habido " + otraAciertos(numerosApuestas,combinacionNumeros) + " aciertos.");
    }

    /**
     * Creo un metodo al que paso los array por parametro
     * @param numerosApuestas
     * @param combinacionNumeros
     * @return
     */
    public static int Aciertos(int[] numerosApuestas, int[] combinacionNumeros){
        int aciertos = 0;
        /**
         * comparo ambos array, y aumento el acumulador cuando coinciden
         */
        for (int i = 0; i < combinacionNumeros.length; i++) {
            for (int j = 0; j < numerosApuestas.length; j++) {
                if (combinacionNumeros[i] == numerosApuestas[j]) {
                    aciertos++;
                }
            }
        }
        /**
         * devuelvo el valor de aciertos
         */
        return aciertos;
    }

    public static int otraAciertos(int[] numerosApuestas, int[] combinacionNumeros){
        int aciertos = 0;
        for (int i : numerosApuestas){
            if(Arrays.binarySearch(combinacionNumeros, i) >= 0){ //Array.binarySearch devuelve la posicion en la que se encuentra si esta
                aciertos ++;
            }
        }
        return aciertos;
    }

}
