package com.cth.test;

import java.text.DecimalFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Scanner;

public class enrtopy {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String n = in.next();
		char[] chars = n.toCharArray();
		int length = chars.length;
		HashMap<Character, Integer> map = new HashMap<>();
		for (char c : chars) {
			if (!map.containsKey(c)) {
				map.put(c, 1);
			} else {
				map.put(c, map.get(c) + 1);
			}
		}
		double entropy = 0;
		Iterator iterator = map.entrySet().iterator();
		while (iterator.hasNext()) {
			Entry<Character, Integer> entry = (Entry) iterator.next();
			double p = (entry.getValue() * 1.0) / length;

			entropy += -p * Math.log(p) / Math.log(2);
		}
		DecimalFormat df = new DecimalFormat("0.0000000");
		String db=df.format(entropy);
		double result=Double.valueOf(db);
		System.out.print(result);
	}
}
