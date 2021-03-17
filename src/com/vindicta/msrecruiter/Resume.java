package com.vindicta.msrecruiter;

public class Resume {

    private String path;
    private String[] msKeywords;
    private int milScore;


    public Resume(String[] path) {
        initialize();
    }

    private void initialize() {
        this.milScore = 0;
    }

    public void updateScore(int score) {
        this.milScore += score;
    }

    public int returnScore() {
        return this.milScore;
    }
}
