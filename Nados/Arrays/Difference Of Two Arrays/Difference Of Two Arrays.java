import java.io.*;
import java.util.*;

public class Main{

public static void main(String[] args) throws Exception {
    // write your code here

    Scanner scn = new Scanner(System.in);
    int n1 = scn.nextInt();
    int a1[] = new int[n1];
    for(int i = 0; i < a1.length; i++){
        a1[i] = scn.nextInt();
    }

    int n2 = scn.nextInt();
    int a2[] = new int[n2];
    for(int i = 0; i < a2.length; i++){
        a2[i] = scn.nextInt();
    }

    int dif[] = new int[n2];

    int borrow = 0;
    int i = a1.length - 1;
    int j = a2.length - 1;
    int k = dif.length - 1;

    while(k >= 0){
        int digit = 0;
        int a1v = i>=0? a1[i]: 0;

        if(a2[j] + borrow >= a1v){
            digit = a2[j] + borrow - a1v;
            borrow = 0;
        } else {
            digit = a2[j] + borrow + 10 - a1v;
            borrow = -1;
        }

        dif[k] = digit;

        i--;
        j--;
        k--;
    }

    int idx = 0;
    while(idx < dif.length){
        if(dif[idx] == 0){
            idx++;
        } else {
            break;
        }
    }

    while(idx < dif.length){
        System.out.println(dif[idx]);
        idx++;
    }
 }

}
