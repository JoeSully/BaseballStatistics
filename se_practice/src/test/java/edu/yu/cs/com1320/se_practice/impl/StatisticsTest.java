package edu.yu.cs.com1320.se_practice.impl;

import static org.junit.jupiter.api.Assertions.*;

import edu.yu.cs.com1320.se_practice.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class StatisticsTest {

    Statistics s = new Statistics();

    @BeforeEach
    void setUp() {
        s.addPlayer(new Batter("Aaron Judge", "yankees", "cf", 118, 21, 27, 6,0, 6, 16, 16, 36, 0));
        s.addPlayer(new Pitcher("Gerrit Cole", "yankees", "sp", 8, 1, 1, 0,51.2,36,13,12,2,16,58,2));
        s.addPlayer(new Batter("DJ Lemahieu", "yankees", "3b", 133, 19, 33,7,1,5,18,11,35,2));
        s.addPlayer(new Batter("Anthony Rizzo", "yankees", "1b", 139, 22,42,5,0,6,17,15,33,5));
        s.addPlayer(new Pitcher("Clay Holmes", "yankees", "cl", 15,0,0,4,13.0,12,7,5,0,6,17,2));
        s.addPlayer(new Pitcher("Wandy Peralta", "yankees", "rp", 16,0,0,0,13.1,11,3,3,1,8,14,2));
        s.addPlayer(new Batter("Paul Goldschmidt", "cardinals", "1b", 167, 24, 45,14,0,7,20,18,31,2));
        s.addPlayer(new Batter("Pete Alonso", "mets", "1b", 157, 25, 33,3,0,13,31,18,36,1));
        s.addPlayer(new Batter("Wander Franco", "rays", "3b", 160, 23, 45,14,0,7,23,12,24,2));
        s.addPlayer(new Pitcher("Sonny Gray", "twins", "sp", 7, 0, 0, 0,40,29,6,6,0,15,47,0));
        s.addPlayer(new Pitcher("Shohei Ohtani", "angels", "sp", 8, 0,0, 0,46,22,14,14,5,20,66,7));
    }


    @Test
    void addPlayer() {
        assertThrows(IllegalArgumentException.class, () -> s.addPlayer(new Pitcher("Gerrit Cole", "yankees", "sp", 8, 1, 1, 0,51.3,36,13,12,2,16,58,2)));
    }

    @Test
    void removePlayer() {
    }

    @Test
    void getTeamBattingLeaders() {
        List<String> l = new ArrayList<>();
        l.add("Anthony Rizzo, yankees, 1b, Batting Average: 0.302");
        l.add("DJ Lemahieu, yankees, 3b, Batting Average: 0.277");
        l.add("Aaron Judge, yankees, cf, Batting Average: 0.273");
        s.getTeamBattingLeaders("ba", "yankees");
    }

    @Test
    void getTeamPitchingLeaders() {
    }

    @Test
    void getPitcherPositionLeaders() {
    }

    @Test
    void getBatterPositionLeaders() {
    }

    @Test
    void getLeagueBattingLeaders() {
    }

    @Test
    void getLeaguePitchingLeaders() {
    }

    @Test
    void compareBatters() {
    }

    @Test
    void comparePitchers() {
    }

    @Test
    void searchPlayerStats() {
    }
}