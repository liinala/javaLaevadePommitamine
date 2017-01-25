import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        System.out.println("Alusta Pommitamist");
        System.out.println("Autor Liina");
        System.out.println("Aasta 2017 ");

        int[][] lauaAlgseis = new int[9][9];
        int [][] lauaSeis = new int[9][9];//see on sisi laua praegune seis

        //0 - meri
        //1 - laev
        //2 - pihta saanud laev


        for (int i = 0; i < 9; i++) { //ühe reaga teeb sama asja ja on ; eraldatud ja asendatud i-ga count 1 asemel
            for (int j = 0; j < 9; j++) {//count2 asendatud j-ga
                lauaAlgseis[i][j] = (int) (Math.random() * 1.3);

            }
        }
        prindiLaud(lauaSeis);


        Scanner sc = new Scanner(System.in);//muutuja tüüp on scanner, sest teen uues scanneri.
        // Suunab andmed mis tulevad System.in-st otse scanner objekti.
        while (true) {
            System.out.println("Kuhu tahad pommitada? Formaat x-y");
            String input = sc.nextLine(); //eraldab kaks numbrit üksteisest
            String[] xy = input.split("-");
            int x = Integer.parseInt(xy[0]) - 1;//nullid saavad üheks. 8-->9 ehk Kasutaja saab 1-st alustada
            int y = Integer.parseInt(xy[1]) - 1;

            int tabamus = lauaAlgseis[y][x];

            if (tabamus == 1) {
                lauaAlgseis[y][x] = 2;//kui laev on pihta saanud siis kuvatakse ka 2
                lauaSeis[y][x] = 2;
                System.out.println("Pihtas!");
            } else if (tabamus == 0) {//ehk meri
                lauaSeis[y][x] = 3;// kui mööda läheb, prindib 3
                System.out.println("Mööda");
            } else if (tabamus == 2) {
                System.out.println("Siia sa juba lasid");
            } else {
                System.out.println("ERROR: kuidas sa üldse siia sai?");
                break;
            }

            prindiLaud(lauaSeis);

            boolean labi = kasOnMangLabi(lauaAlgseis);
            if (labi == true){
                break;
            }
            }
            System.out.println("Mäng on läbi");

    }

    private static boolean kasOnMangLabi(int[][] laud) {
        for (int i=0; i<9; i++){          //mäng on läbi sisi kui mitte ühtegegi 1 alles ei ole
            for (int j=0; j <9; j++) {
                if (laud[j][i] == 1) {
                    return false;
                }
            }
            }

        return true;

    }

    public static void prindiLaud(int[][] prinditavLaud) {
        for (int i = 0; i < 9; i++) {
            System.out.println(Arrays.toString(prinditavLaud[i]));//see for tsükkel prindib lauda
        }

    }
}