package com.vindicta.msrecruiter;
import java.util.HashMap;

public class Keywords {

    HashMap<String, Integer> msKeywords = new HashMap<String, Integer>();

    public Keywords() {
        initializeKeywords();
    }

    private void initializeKeywords() {
        this.msKeywords.put("military", 5);
        this.msKeywords.put("Military", 5);
        this.msKeywords.put("milspouse", 5);
        this.msKeywords.put("Milspouse", 5);
        this.msKeywords.put("MilSpouse", 5);
        this.msKeywords.put("PCS", 4);
        this.msKeywords.put("Permanent Change of Station", 5);
        this.msKeywords.put("Fort", 2);
        this.msKeywords.put("Naval", 3);
        this.msKeywords.put("Navy", 3);
        this.msKeywords.put("Marine", 3);
        this.msKeywords.put("Army", 3);
        this.msKeywords.put("Air Force", 3);
        this.msKeywords.put("Space Force", 3);
        this.msKeywords.put("Coast Guard", 3);
        this.msKeywords.put("Camp", 2);
        this.msKeywords.put("Volunteer", 1);
        this.msKeywords.put("Volunteering", 1);
        this.msKeywords.put("volunteer", 1);
        this.msKeywords.put("volunteering", 1);
        this.msKeywords.put("clearance", 2);
        this.msKeywords.put("Clearance", 2);
        this.msKeywords.put("CLEARANCE", 2);
    }

    public int calculateScore(String text) {
        int score = 0;
        String delims = "[ \n]+";
        String[] resume = text.split(delims);
        for (String s : resume) {
            if (this.msKeywords.containsKey(s)) {
                score += this.msKeywords.get(s);
            }
        }
        return score;
    }
}
