package com.cth.test;

import java.util.*;

/**
 * Created by SherlockTHao on 2017/3/23.
 */

public class slution {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        Set<String> set = new HashSet<String>();
        for (int i = 0; i < count; i++) {
            String str = in.nextLine();
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            set.add(chars.toString());
        }
        System.out.println(set.size());
    }
//    public static Map judgeStr(String a){
//        char[] chars=a.toCharArray();
//        Map<Character,Integer> result=new HashMap<>();
//        for(char c : chars){
//            if(result.containsKey(c)){
//                result.put(c,result.get(c)+1);
//            }
//            else {
//                result.put(c,1);
//            }
//        }
//        return result;
//    }
//    public static void addList(List<Map<Character,Integer>> result,Map<Character,Integer> map){
//        boolean res=true;
//        for(Map<Character,Integer>  temp :result){
//            boolean flag=true;
//            if(temp.equals(map)){
//                Iterator<Character> iter1 = temp.keySet().iterator();
//                while (iter1.hasNext()) {
//                    Character m1Key = iter1.next();
//                    if (!temp.get(m1Key).equals(map.get(m1Key))) {//若两个map中相同key对应的value不相等
//                        flag=false;
//                    }
//                }
//            }
//            else {
//                flag=true;
//            }
//
//            if(flag){
//                res=false;
//                break;
//            }
//        }
//        if(res){
//            result.add(map);
//        }
//    }
}
