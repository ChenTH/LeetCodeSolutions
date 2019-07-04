package com.cth.startover;

public class LongestPalindrome {

    public static void main(String[] args) {
        System.out.println(longestPalindrome("ac"));
        System.out.println(solution("cbbd"));

    }

    //马拉车算法
    public static String longestPalindrome(String s) {
        if (s.length() == 0) {
            return "";
        }
        //我们原有的字符串可能存在两种回文子串，一种是具有基数个元素例如aba 一种是具有偶数个元素例如abba 这样的话分情况判断比较复杂
        //所以我们对原字符串进行扩充 在相邻元素中插入特殊值 插入后的原基数回文子串变成了a#b#a 原偶数回文子串变成了a#b#b#a 都变成了基数回文子串 便于后续的运算
        char[] chars = new char[s.length() * 2 - 1];
        for (int i = 0; i < s.length() - 1; i++) {
            chars[2 * i] = s.charAt(i);
            chars[2 * i + 1] = '#';
        }
        chars[chars.length - 1] = s.charAt(s.length() - 1);
        //初始化标识数组，此数组用来表示chars中某个元素的回文子串半径值
        int[] l = new int[chars.length];
        l[0] = 1;
        //其中max为已探明的回文子串中能扩展到最右的边界位置 id为前述回文子串的中心位置 resid为最终解的中心值
        int max = 1, id = 0, resid = 0;
        //循环获取最长回文子串
        for (int i = 1; i < l.length; i++) {
            // 当max>i时当前数组为如下结构：
            //  beg-------min----j-----id-----i----max-----end
            //其中beg和end分别为数组的边界位置 j=2*id-i 是i对于id的对称值 （当max>i时此对称值肯定会有并且肯定大于min，当max<i时此对称值可能已经越界） min是以id为中心的回文子串的最小值，所以min～max为一个对称的回文序列
            //l[j]记录了以j为中心的回文序列半径 因为min～max本来就是一个回文串 所以i存在如下几种情况
            // 1、所以如果以j为中心的回文序列在min～max之间的话 对称的以i为中心的回文序列也在min～max之间
            // 2、如果以j为中心的回文序列超出了min～max的范围的话，假设为jmin~jmax.可以保证min~jmax-(min-jmin)之间的回文串对称到i周围也是回文串
            //根据如上的方法 我们得到了以i为中心的一个回文子串，但这个回文子串不是最终的值 需要继续迭代扩充
            //当max<i时数组为如下结构
            //  beg------min-----id-----max----i-----end
            //此时无法根据min到max之间的回文对称来判断i的周围环境，只能给i的回文串长度赋值为1 然后进行迭代扩充
            l[i] = max > i ? Math.min(l[2 * id - i], max - i) : 1;
            //对获取的半径进行迭代扩充回文序列的长度
            while (i - l[i] >= 0 && i + l[i] <= chars.length - 1 && chars[i - l[i]] == chars[i + l[i]]) {
                l[i]++;
            }
            //如果当前的回文序列最右边界位置已经大于了max 则更新max和id为当前回文序列的相关值
            if (i + l[i] - 1 > max) {
                max = i + l[i] - 1;
                id = i;
            }
            //如果当前的回文序列长度为最长，则更新resid的值
            if (l[i] > l[resid]) {
                resid = i;
                //如果当前的回文序列长度和之前记录的最长回文序列的长度相同则存在如下情况：
                // 1、之前最长回文序列长度为1 但是此时中心为扩充值 比如a#b中 #为中心 长度为1 这样的序列并不能当作解来使用，如果发现了以原字符串中字符为中心的长度相同的串则要更新这个值
                // 2、之前最长回文序列中心值为扩充值，例如#a#a#长度为5对应原字符串中子串为aa，但是存在以原字符串的值为中心的序列比如a#b#a 长度为5，此时对应的原字符串为aba 可见长度相同但是最后的结果有差别
                // 所以此处进行判断来避免如上两种问题
            } else if (l[i] == l[resid] && l[i] != 1 && resid % 2 == 0) {
                resid = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        //根据得到的resid和其半径 获取最后的结果
        int resBeg = resid - l[resid] + 1;
        while (resBeg <= resid + l[resid] - 1) {
            if (resBeg % 2 == 0) {
                sb.append(chars[resBeg]);
            }
            resBeg++;
        }
        return sb.toString();
    }

    public static String solution(String s) {
        if (s.length() == 0) {
            return "";
        }
        //我们原有的字符串可能存在两种回文子串，一种是具有基数个元素例如aba 一种是具有偶数个元素例如abba 这样的话分情况判断比较复杂
        //所以我们对原字符串进行扩充 在相邻元素中插入特殊值 插入后的原基数回文子串变成了#a#b#a# 原偶数回文子串变成了#a#b#b#a# 都变成了基数回文子串 便于后续的运算
        char[] chars = new char[s.length() * 2 + 1];
        for (int i = 0; i < s.length(); i++) {
            chars[2 * i] = '#';
            chars[2 * i + 1] = s.charAt(i);
        }
        chars[chars.length - 1] = '#';
        //初始化标识数组，此数组用来表示chars中某个元素的回文子串半径值
        int[] l = new int[chars.length];
        l[0] = 1;
        //其中max为已探明的回文子串中能扩展到最右的边界位置 id为前述回文子串的中心位置 resid为最终解的中心值
        int max = 1, id = 0, resid = 0;
        //循环获取最长回文子串
        for (int i = 1; i < l.length; i++) {
            // 当max>i时当前数组为如下结构：
            //  beg-------min----j-----id-----i----max-----end
            //其中beg和end分别为数组的边界位置 j=2*id-i 是i对于id的对称值 （当max>i时此对称值肯定会有并且肯定大于min，当max<i时此对称值可能已经越界） min是以id为中心的回文子串的最小值，所以min～max为一个对称的回文序列
            //l[j]记录了以j为中心的回文序列半径 因为min～max本来就是一个回文串 所以i存在如下几种情况
            // 1、所以如果以j为中心的回文序列在min～max之间的话 对称的以i为中心的回文序列也在min～max之间
            // 2、如果以j为中心的回文序列超出了min～max的范围的话，假设为jmin~jmax.可以保证min~jmax-(min-jmin)之间的回文串对称到i周围也是回文串
            //根据如上的方法 我们得到了以i为中心的一个回文子串，但这个回文子串不是最终的值 需要继续迭代扩充
            //当max<i时数组为如下结构
            //  beg------min-----id-----max----i-----end
            //此时无法根据min到max之间的回文对称来判断i的周围环境，只能给i的回文串长度赋值为1 然后进行迭代扩充
            l[i] = max > i ? Math.min(l[2 * id - i], max - i) : 1;
            //对获取的半径进行迭代扩充回文序列的长度
            while (i - l[i] >= 0 && i + l[i] <= chars.length - 1 && chars[i - l[i]] == chars[i + l[i]]) {
                l[i]++;
            }
            //如果当前的回文序列最右边界位置已经大于了max 则更新max和id为当前回文序列的相关值
            if (i + l[i] - 1 > max) {
                max = i + l[i] - 1;
                id = i;
            }
            //如果当前的回文序列长度为最长，则更新resid的值
            if (l[i] > l[resid]) {
                resid = i;
                //如果当前的回文序列长度和之前记录的最长回文序列的长度相同则存在如下情况：
                // 1、之前最长回文序列长度为1 但是此时中心为扩充值 比如a#b中 #为中心 长度为1 这样的序列并不能当作解来使用，如果发现了以原字符串中字符为中心的长度相同的串则要更新这个值
                // 2、之前最长回文序列中心值为扩充值，例如#a#a#长度为5对应原字符串中子串为aa，但是存在以原字符串的值为中心的序列比如a#b#a 长度为5，此时对应的原字符串为aba 可见长度相同但是最后的结果有差别
                // 所以此处进行判断来避免如上两种问题
            } else if (l[i] == l[resid] && resid % 2 == 0) {
                resid = i;
            }
        }
        StringBuilder sb = new StringBuilder();
        int resBeg = resid - l[resid] + 1;
        //根据得到的resid和其半径 获取最后的结果
        while (resBeg <= resid + l[resid] - 1) {
            if (resBeg % 2 == 1) {
                sb.append(chars[resBeg]);
            }
            resBeg++;
        }
        return sb.toString();
    }
}
