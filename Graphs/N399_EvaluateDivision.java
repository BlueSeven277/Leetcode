package Graphs;

import java.util.*;

/**
 * Created by srx on 2018/11/28.
 * <p>
 * Example:
 * Given a / b = 2.0, b / c = 3.0.
 * queries are: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? .
 * return [6.0, 0.5, -1.0, 1.0, -1.0 ].
 */
public class N399_EvaluateDivision {
    public static double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, ArrayList<String>> tableEq = new HashMap<String, ArrayList<String>>();
        Map<String, ArrayList<Double>> tableVal = new HashMap<String, ArrayList<Double>>();
        for (int i = 0; i < equations.length; i++) {
            String[] strs = equations[i];
            if (!tableEq.containsKey(strs[0])) {
                tableEq.put(strs[0], new ArrayList<String>());
                tableVal.put(strs[0], new ArrayList<Double>());
            }
            if (!tableEq.containsKey(strs[1])) {
                tableEq.put(strs[1], new ArrayList<String>());
                tableVal.put(strs[1], new ArrayList<Double>());
            }
            tableEq.get(strs[0]).add(strs[1]);
            tableEq.get(strs[1]).add(strs[0]);
            tableVal.get(strs[0]).add(values[i]);
            tableVal.get(strs[1]).add(1 / values[i]);
        }
        double[] result = new double[queries.length];
        for (int j = 0; j < queries.length; j++) {
//            HashSet s = new HashSet();
//            s.add(queries[j][0]);
            result[j] = dfs(queries[j][0], queries[j][1], tableEq, tableVal, 1, new HashSet());
            if (result[j] ==0)
                result[j]= -1.0;
        }
        return result;

    }

    public static double dfs(String st, String ed, Map<String, ArrayList<String>> tEq, Map<String, ArrayList<Double>> tVal, double value, Set<String> set) {
        if (set.contains(st)) return 0.0;
        if (!tEq.containsKey(st)||!tEq.containsKey(ed)) return -1.0;
        if (st.equals(ed)) return value;
        set.add(st);
        ArrayList<String> strList = tEq.get(st);
        ArrayList<Double> valueList = tVal.get(st);
        double tmp = 0.0;
        for (int i =0;i<strList.size();i++){
            tmp = dfs(strList.get(i),ed,tEq,tVal,value*valueList.get(i),set);
            if (tmp!=0.0){
                //if == 0, means might have visited all child and this path is not correct
                //there may have many 0.0 paths and we want the non-zero one
                return tmp;
            }
        }
        return tmp;



    }

    public static void main(String[] args) {
        String[][] q = {{"a1", "a2"}, {"a2", "a3"}, {"a3", "a4"}, {"a4", "a5"}};
        double[] values = {3.0, 4.0,5.0,6.0};
        String[][] queries ={ {"a2", "a4"}} ;
        double[] result=calcEquation(q,values,queries);
        for (double i: result
             ) {
            System.out.print(i+" ");
        }
    }





}
