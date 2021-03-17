package com.vindicta.msrecruiter;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class SpouseList {

    private HashMap<String, Integer> slist;

    public SpouseList() {
        this.slist = new HashMap<String, Integer>();
    }


    public void addResume(String fname, int score) {

        this.slist.put(fname, score);
    }

    public HashMap<String, Integer> returnResume() {

        return this.slist;
    }

    public void printResumes() {
        Iterator rIterator = this.slist.entrySet().iterator();
        while (rIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry)rIterator.next();
            int score = (int)mapElement.getValue();
            double estimate = (score * 5.0 - .01);
            if (estimate > 100.0) {
                estimate = 99.99;
            }
            System.out.println(mapElement.getKey() + " with certainty of " + estimate + "%");
        }
    }
}
