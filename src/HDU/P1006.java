package HDU;

import java.util.Scanner;

public class P1006 {

    public static double Update(double D, double min, double max, double angle, double speed, boolean flag){

        double t = (D - angle) /speed;

        if (t >= min && t <= max)
            return t;
        else {
            if (!flag)
                return min;
            else  return max;
        }
    }

    public static void main(String[] args){

        Scanner cin = new Scanner(System.in);

        int D,total = 43200,i,j,k;
        double SpeedOfHM = (0.1 - 1.0/240);
        double SpeedOfHS = (6 - 1.0/240);
        double SpeedOfMS = (6 - 0.1);
        double angleHM,angleHS,angleMS,temp1,temp2,amount,min,max;

        while ((D = cin.nextInt()) != -1){

            amount = 0;
//            if (D == 0)
//                amount = total;
//            else if (D == 120);
            for (i = 0;i<24;i++){
                temp1 = i*15;
                for (j = 0;j<60;j++){
                    temp2 = j*6;
                    angleHM = temp2 - temp1;
                    angleHS = 0 - temp1;
                    angleMS = 0 - temp2;

                    min = 0;
                    max = 60;

                    min = Update(D,min,max,angleHM,SpeedOfHM,false);
                    max = Update(360-D,min,max,angleHM,SpeedOfHM,true);
                    min = Update(D,min,max,angleHS,SpeedOfHS,false);
                    max = Update(360-D,min,max,angleHS,SpeedOfHS,true);
                    min = Update(D,min,max,angleMS,SpeedOfMS,false);
                    max = Update(360-D,min,max,angleMS,SpeedOfMS,true);

                    amount += (max - min);
                }
            }

            System.out.println(String.format("%.3f",amount/total *100));
        }
        cin.close();
    }
}
