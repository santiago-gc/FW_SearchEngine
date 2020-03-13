package com.findwise.implementation;

import com.findwise.IndexEntry;

public class IndexEntryImpl implements IndexEntry {

    private String id;
    private double score;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getScore() {
        return score;
    }

    public void setScore(double score) {
        this.score = score;
    }

    public IndexEntryImpl(String id, double score) {
        this.id = id;
        this.score = score;
    }

}