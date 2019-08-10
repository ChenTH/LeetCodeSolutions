package com.cth.backup.hashtable.hard;


public class InsertDeleteGetRandomO1 {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RandomizedSet rSet = new RandomizedSet();
        rSet.remove(0);
        rSet.remove(0);
        rSet.insert(0);
        rSet.getRandom();
        rSet.remove(0);
        rSet.insert(0);
    }

}
