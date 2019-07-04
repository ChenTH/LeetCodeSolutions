package com.cth.interview.alibaba;

import java.util.*;

/**
 * Created by SherlockTHao on 2017/8/25.
 */
public class problem2 {
    //    public static HashMap<String,List<UnilateralLine>> lineMap=new HashMap<>();
//    publci static Set<String> used=new HashSet<>();
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<UnilateralLine> lineList = new ArrayList<UnilateralLine>();
        while (scanner.hasNextLine()) {
            String[] options = scanner.nextLine().split(";");
            if (options.length < 5) {
                break;
            }
            lineList.add(new UnilateralLine(options[0], options[1], options[2], options[3], options[4], options[5]));
        }
        scanner.close();

        // wirte your code here
        List<String> result = calculateUnilateral(lineList);

        for (String str : result) {
            System.out.println(str);
        }
    }

    public static List<String> calculateUnilateral(List<UnilateralLine> lineList) {
        List<String> result = new ArrayList<String>();
        Set<String> used = new HashSet<>();
        role1Calculate(lineList, result, used);
        return result;
    }

    public static void role1Calculate(List<UnilateralLine> lineList, List<String> result, Set<String> used) {//�ҳ���һ�ֽ���취�����
        HashMap<String, List<UnilateralLine>> map = new HashMap<>();
        for (UnilateralLine u : lineList) {
            List<UnilateralLine> list = map.getOrDefault(u.getSCen() + ',' + u.getECen(), new LinkedList<>());
            list.add(u);
            map.put(u.getSCen() + ',' + u.getECen(), list);
        }
        for (String line : map.keySet()) {
            for (UnilateralLine u : map.get(line)) {
                if (!used.contains(u.getId())) {
                    List<UnilateralLine> list = map.get(u.getECen() + ',' + u.getSCen());//�ҵ����ص���·�б�
                    if (list != null) {
                        if (u.getTType().equals("9.6m")) {
                            for (UnilateralLine ret : list) {
                                if (!used.contains(ret.getId())) {
                                    if (ret.getTType().equals("9.6m")) {//����ҵ���9.6�ķ���
                                        used.add(u.getId());
                                        used.add(ret.getId());
                                        result.add("rule1��" + u.getId() + "+" + ret.getId());
                                        break;
                                    }
                                }
                            }
                        } else {
                            int smallCount = 0;
                            String[] smallId = new String[2];
                            for (UnilateralLine ret : list) {
                                if (used.contains(ret.getId())) {
                                    if (ret.getTType().equals("9.6m")) {//����ҵ�������9.6����
                                        smallId[smallCount] = ret.getId();
                                        smallCount++;
                                    } else {//����ҵ���17.5����
                                        used.add(u.getId());
                                        used.add(ret.getId());
                                        result.add("rule1��" + u.getId() + "+" + ret.getId());
                                        break;
                                    }
                                }
                                if (smallCount == 2) {
                                    used.add(u.getId());
                                    used.add(smallId[0]);
                                    used.add(smallId[1]);
                                    result.add("rule1��" + u.getId() + "+" + smallId[0] + "+" + smallId[1]);
                                    break;
                                }
                            }
                        }

                    }
                }
            }
        }
    }

    public static void role3Calculate(List<UnilateralLine> lineList, List<String> result, Set<String> used) {//�ҳ��ڶ��ֽ���취�����
        //todo δ���
        HashMap<String, List<UnilateralLine>> map = new HashMap<>();
        for (UnilateralLine u : lineList) {
            List<UnilateralLine> list = map.getOrDefault(u.getSCen() + ',' + u.getECen(), new LinkedList<>());
            list.add(u);
            map.put(u.getSCen() + ',' + u.getECen(), list);
        }
    }

    //    public static int[] getTargetLine(List<UnilateralLine> lineList,List<String> result,Set<String> used){
//        HashMap<String,List<UnilateralLine>> map=new HashMap<>();
//
//    }
//    public static void initLineMap(List<UnilateralLine> lineList){
//        for(UnilateralLine u:lineList){
//            List<UnilateralLine> list=lineMap.getOrDefault(u.getSCen()+','+u.getECen(),new LinkedList<>());
//            list.add(u);
//            lineMap.put(u.getSCen()+','+u.getECen(),list);
//        }
//    }
    public static class UnilateralLine {
        private String id;
        private String sCen;//�����ֲ�
        private String sPro;//����ʡ
        private String eCen;//����ֲ�
        private String ePro;//����ʡ
        //9.6m/17.5m
        private String tType;//����


        public UnilateralLine(String id, String sCen, String sPro, String eCen, String ePro, String tType) {
            this.id = id;
            this.sCen = sCen;
            this.sPro = sPro;
            this.eCen = eCen;
            this.ePro = ePro;
            this.tType = tType;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getSCen() {
            return sCen;
        }

        public void setSCen(String ePro) {
            this.ePro = ePro;
        }

        public String getSPro() {
            return sPro;
        }

        public void setSPro(String sPro) {
            this.sPro = sPro;
        }

        public String getECen() {
            return eCen;
        }

        public void setECen(String eCen) {
            this.eCen = eCen;
        }

        public String getEPro() {
            return ePro;
        }

        public void setEPro(String ePro) {
            this.ePro = ePro;
        }

        public String getTType() {
            return tType;
        }

        public void setTType(String tType) {
            this.tType = tType;
        }
    }
}