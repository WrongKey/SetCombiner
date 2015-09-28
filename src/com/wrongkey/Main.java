package com.wrongkey;

import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    private static int count = 0;

    public static void main(String[] args) {
        Set<String> set = new TreeSet<String>();
        Random random = new Random(System.currentTimeMillis());
        while (set.size() < 5000) {
            set.add(random.nextInt() + "");
        }
        long startTime = System.currentTimeMillis();
        Set<Tuple<String, String>> tupleSet = genCombinedSet(set);
        System.out.println("Total cost " + (System.currentTimeMillis() - startTime) + " ms.");
//        System.out.println(tupleSet);
        System.out.println("Total calculate " + count + " times.");
    }

    private static Set<Tuple<String, String>> genCombinedSet(Set<String> set) {
        Set<String> set1 = new TreeSet<String>(set);
        Set<Tuple<String, String>> tupleSet = new HashSet<Tuple<String, String>>();
        for (String s : set) {
            set1.remove(s);
            genTupleElements(tupleSet, s, set1);
        }
        return tupleSet;
    }

    private static void genTupleElements(Set<Tuple<String, String>> tupleSet,
                                         String s, Set<String> set1) {
        for (String str : set1) {
            tupleSet.add(new Tuple<String, String>(s, str));
//            count++;
        }
    }
}
