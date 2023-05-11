package edu.yu.cs.com1320.se_practice.impl;

import edu.yu.cs.com1320.se_practice.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Pitcher extends Player {
    int g, sv, cg, sho, h, er, r, bb, hr, so, hbp;
    double ip;
    String name, team, position;

    public Pitcher(String name, String team, String position, int g, int sv, int cg, int sho, int h, int er, int r, int bb, int hr, int so, int hbp, double ip) {
        String ipStr = Double.toString(ip).substring(Double.toString(ip).indexOf('.'));
        if (!(ipStr.equals("0") || ipStr.equals("") || ipStr.equals("2") || ipStr.equals("1"))) {
            throw new IllegalArgumentException("Innings pitched must end in a decimal of .0, .1, or .2");
        }
        this.name = name;
        this.team = team;
        this.position = position;
        this.bb = bb;
        this.g = g;
        this.sv = sv;
        this.cg = cg;
        this.h = h;
        this.sho = sho;
        this.er = er;
        this.r = r;
        this.ip = ip;
        this.hr = hr;
        this.so = so;
        this.hbp = hbp;
    }

    public void setWalksAllowed(int walks) {
        this.bb = walks;
    }

    public void setGames(int games) {
        this.g = games;
    }

    public void setSaves(int saves) {
        this.sv = saves;
    }

    public void setCompleteGames(int cg) {
        this.cg = cg;
    }

    public void setHitsAllowed(int h) {
        this.h = h;
    }

    public void setShutouts(int sho) {
        this.sho = sho;
    }

    public void setEarnedRuns(int cg) {
        this.cg = cg;
    }

    public void setRunsAllowed(int r) {
        this.r = r;
    }

    public void setInningsPitched(double ip) {
        String ipStr = Double.toString(ip).substring(Double.toString(ip).indexOf('.'));
        if (!(ipStr.equals("0") || ipStr.equals("") || ipStr.equals("2") || ipStr.equals("1"))) {
            throw new IllegalArgumentException("Innings pitched must end in a decimal of .0, .1, or .2");
        }
        this.ip = ip;
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

    public double getInningsPitched() {
        return this.ip;
    }

    public int getCompleteGames() {
        return this.cg;
    }

    public int getShutouts() {
        return this.sho;
    }

    public int getHitsAllowed() {
        return this.h;
    }

    public int getHitByPitch() {
        return this.hbp;
    }

    public int getHomeRunsAllowed() {
        return this.hr;
    }

    public int getRunsAllowed() {
        return this.r;
    }

    public int getSaves() {
        return this.sv;
    }

    public int getEarnedRuns() {
        return this.er;
    }

    public double getERA() {
        return Math.round(9 * this.er / this.ip * 100) / 100.0;
    }

    public int getGames() {
        return this.g;
    }

    public int getWalks() {
        return this.bb;
    }

    public int getStrikeouts(){
        return this.so;
    }

    public double getWhip() {
        return Math.round((this.bb + this.h) / this.ip * 1000) / 1000.0;
    }

    public double getStrikeoutsPer9() {
        return Math.round(9 * this.so / this.ip * 10) / 10.0;
    }

    public double getHitsPer9() {
        return Math.round(9 * this.h / this.ip * 10) / 10.0;
    }

    public double getHomeRunsPer9() {
        return Math.round(9 * this.hr / this.ip * 10) / 10.0;
    }

    public double getWalksPer9() {
        return Math.round(9 * this.bb / this.ip * 10) / 10.0;
    }

    @Override
    public List<String> getAllStats() {
        List<String> results = new ArrayList<>();
        results.add("Games: " + this.getGames());
        results.add("Hits Allowed: " + this.getHitsAllowed());
        results.add("Innings Pitched: " + this.getInningsPitched());
        results.add("Home Runs Allowed: " + this.getHomeRunsAllowed());
        results.add("Runs Allowed: " + this.getRunsAllowed());
        results.add("Earned Runs Allowed: " + this.getEarnedRuns());
        results.add("Shutouts: " + this.getShutouts());
        results.add("Saves: " + this.getSaves());
        results.add("Earned Run Average: " + this.getERA());
        results.add("Complete Games: " + this.getCompleteGames());
        results.add("Strikeouts: " + this.getStrikeouts());
        results.add("Walks: " + this.getWalks());
        results.add("Hit By Pitch: " + this.getHitByPitch());
        results.add("Walks and Hits Per Inning Pitched: " + this.getWhip());
        results.add("Hits Per 9 Innings: " + this.getHitsPer9());
        results.add("Walks Per 9 Innings: " + this.getWalksPer9());
        results.add("Home Runs Per 9 Innings: " + this.getHomeRunsPer9());
        results.add("Strikeouts Per 9 Innings: " + this.getStrikeoutsPer9());
        return results;
    }
}