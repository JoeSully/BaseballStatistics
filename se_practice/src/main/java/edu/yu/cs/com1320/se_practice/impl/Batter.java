package edu.yu.cs.com1320.se_practice.impl;

import edu.yu.cs.com1320.se_practice.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Batter extends Player {
    //Constructor: ints PA, R, H, 2B, 3B, HR, RBI, BB, SO, HBP, string team, string position
    //	Setters and getters for PA, AB, R, H, 2B, 3B, HR, RBI, BB, SO, BA, OBP, OPS, SLG, HBP, TB

    int pa, doubles, triples, rbi, h, r, bb, hr, so, hbp;
    String team, name, position;

    public Batter(String name, String team, String position, int pa, int r, int h, int doubles, int triples, int hr, int rbi, int bb, int so, int hbp) {
        this.name = name;
        this.team = team;
        this.position = position;
        this.bb = bb;
        this.pa = pa;
        this.doubles = doubles;
        this.triples = triples;
        this.h = h;
        this.rbi = rbi;
        this.r = r;
        this.hr = hr;
        this.so = so;
        this.hbp = hbp;
    }

    public void setWalks(int walks) {
        this.bb = walks;
    }

    public void setPlateAppearances(int pa) {
        this.pa = pa;
    }

    public void setDoubles(int doubles) {
        this.doubles = doubles;
    }

    public void setTriples(int triples) {
        this.triples = triples;
    }

    public void setHits(int h) {
        this.h = h;
    }

    public void setRunsBattedIn(int rbi) {
        this.rbi = rbi;
    }

    public void setRuns(int r) {
        this.r = r;
    }

    public void setHomeRuns(int hr) {
        this.hr = hr;
    }

    public void setStrikeouts(int so) {
        this.so = so;
    }

    public void setHitByPitch(int hbp) {
        this.hbp = hbp;
    }

    public double getBattingAverage() {
        return ((double) this.h / (this.pa - this.bb - this.hbp) * 1000) / 1000.0;
    }

    public double getOnBasePercentage() {
        return (double)((this.h + this.bb + this.hbp) / ((this.pa - this.bb - this.hbp) + this.h + this.bb)) * 1000 / 1000.0;
    }

    public double getOnBasePlusSlugging() {
        return this.getOnBasePercentage() + this.getSluggingPercentage();
    }

    public int getPlateAppearances() {
        return this.pa;
    }

    public int getAtBats() {
        return this.pa - this.bb - this.hbp;
    }

    public int getDoubles() {
        return this.doubles;
    }

    public int getTriples() {
        return this.triples;
    }

    public int getTotalBases() {
        return (this.h - this.doubles - this.triples - this.hr) + this.doubles * 2 + this.triples * 3 + this.hr * 4;
    }

    public double getSluggingPercentage() {
        return ((double) this.getTotalBases() / (this.pa - this.bb - this.hbp)) * 1000 / 1000.0;
    }

    public int getHits() {
        return this.h;
    }

    public int getHitByPitch() {
        return this.hbp;
    }

    public int getHomeRuns() {
        return this.hr;
    }

    public int getRuns() {
        return this.r;
    }

    public int getRunsBattedIn() {
        return this.rbi;
    }

    public int getWalks() {
        return this.bb;
    }

    public int getStrikeouts(){
        return this.so;
    }

    @Override
    public List<String> getAllStats() {
        List<String> results = new ArrayList<>();
        results.add("Name: " + this.name);
        results.add("Team: " + this.team);
        results.add("Position: " + this.position);
        results.add("Plate Appearances: " + this.getPlateAppearances());
        results.add("At Bats: " + this.getAtBats());
        results.add("Runs: " + this.getRuns());
        results.add("Hits: " + this.getHits());
        results.add("Doubles: " + this.getDoubles());
        results.add("Triples: " + this.getTriples());
        results.add("Home Runs: " + this.getHomeRuns());
        results.add("Runs Batted In: " + this.getRunsBattedIn());
        results.add("Walks: " + this.getWalks());
        results.add("Strikeouts: " + this.getStrikeouts());
        results.add("Batting Average: " + this.getBattingAverage());
        results.add("On Base Percentage: " + this.getOnBasePercentage());
        results.add("Slugging Percentage: " + this.getSluggingPercentage());
        results.add("On Base Plus Slugging Percentage: " + this.getOnBasePercentage());
        results.add("Total Bases: " + this.getTotalBases());
        results.add("Hit By Pitch: " + this.getHitByPitch());
        return results;
    }
}
