
//************************************
// Nadav Voikovitch , ID: 308526508
// Or Kravitz, ID: 308248293
//************************************


package PropperTower;
import java.util.List;
import java.util.Random;

class ProperTower {

    public ProperTower() {}

    public static class Cube{
        int max = 0;
        String index="";
    }

    static void properT(int[] length, int[] width, int[] height) {
        // in order to print the cubes that we get from random
        System.out.println("The Cubes of the Tower");
        System.out.println("Cube: \t    Length  \t Width\t     Height " );
        for (int i=1; i< height.length; i++){
            System.out.println(i + "\t\t\t" +length[i] + "\t\t\t" + width[i] + "\t\t\t" + height[i]);
        }

        int max;
        Cube cube[] = new Cube[height.length+1];
        for (int i=0;i< height.length; i++){ // O(n)
            cube[i] = new Cube();
        }

        /** The Algorithm */

        cube[1].max = height[1];
        cube[1].index = "1";
        for (int i = 2; i < height.length; i++){ // O(n^2)
            max = 0;
            for (int j = 1; j<i; j++){
                if (length[j] > length[i] && width[j] > width[i] && cube[j].max > max){
                    max = cube[j].max;
                    cube[i].index = cube[j].index;
                }
            }
            cube[i].max = max + height[i];
            String tmp = Integer.toString(i);
            cube[i].index = cube[i].index +" "+ tmp;

        }
        /** *** */
        max = cube[0].max;
        int index=0;
        for (int i = 0; i < height.length; i++){ // O(n) - in order to print the maximum corrected Tower
            if (cube[i].max > max) {
                max = cube[i].max;
                index=i;
            }
        }
        System.out.println("The Cubes int the corrected Tower are :" + cube[index].index);
        System.out.println("The maximum value of a proper tower is :" + max);

            /** T.T.C = O(n+n^2+n) = O(n^2)*/
    }
}

public class mainTrain {
    public static void main(String[] args) {

        Random rand = new Random();
        ProperTower properTower = new ProperTower();

        int[] length1 = new int[21];
        int[] width1 = new int[21];
        int[] height1 = new int[21];
        length1[0]=0;
        width1[0]=0;
        height1[0]=0;
        System.out.println();
        System.out.println("** The First Tower With 20 Cubes: **");
        for (int i=1; i<height1.length; i++){
            length1[i] = 1+rand.nextInt(200);
            width1[i] = 1+rand.nextInt(200);
            height1[i] = 1+rand.nextInt(200);
        }

        ProperTower.properT(length1,width1,height1);
        System.out.println();
        System.out.println("*******************************************");
        System.out.println();
        System.out.println("** The Second Tower With 30 Cubes: **");

        int[] length2 = new int[31];
        int[] width2 = new int[31];
        int[] height2 = new int[31];
        length2[0]=0;
        width2[0]=0;
        height2[0]=0;
        for (int i=1; i< height2.length; i++){
            length2[i] = 1+rand.nextInt(200);
            width2[i] = 1+rand.nextInt(200);
            height2[i] = 1+rand.nextInt(200);
        }
        ProperTower.properT(length2,width2,height2);
    }
}

