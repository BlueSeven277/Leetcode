package Scotiabank;

import java.util.ArrayList;

/**
 * Created by srx on 2019/1/29.
 */
public class city_distance {
    public static int[] getdistance(int[] T){
        boolean[] visited = new boolean[T.length];
        int[] rt = new int[T.length-1];
        int head = -1;
        int distance = 0;
        for (int i =0;i<T.length;i++){
            if (T[i]==i){
                head = i;
                break;
            }
        }
        ArrayList<Integer> current = new ArrayList();
        current.add(head);
        while (!current.isEmpty()){
            ArrayList toAdd = new ArrayList();
            for (Integer node : current ){
                visited[node] = true;
                for (int j = 0;j<T.length;j++){
                    if (!visited[j]&&T[j]==node){
                        toAdd.add(j);
                        rt[distance]++;
                    }
                }
            }
            if (toAdd.isEmpty()){
                return rt;
            }
            current = toAdd;
            distance++;
        }
        return rt;

    }

    public static void main(String[] args) {
        int[] T = new int[]{9, 1, 4, 9, 0, 4, 8, 9, 0, 1 };
        int[] rt = getdistance(T);
        for (int i : rt){
            System.out.print(i);
            System.out.print(" ");
        }

    }
}
