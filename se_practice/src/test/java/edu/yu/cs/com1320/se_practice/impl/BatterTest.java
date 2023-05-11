package edu.yu.cs.com1320.se_practice.impl;

import static org.junit.jupiter.api.Assertions.*;

import edu.yu.cs.com1320.se_practice.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class BatterTest {

    ArrayList<Batter> s = new ArrayList<>();
    
    @BeforeEach
    void setUp() {
        s.add(new Batter("Aaron Judge", "yankees", "cf", 118, 21, 27, 6,0, 6, 16, 16, 36, 0));
        s.add(new Batter("DJ Lemahieu", "yankees", "3b", 133, 19, 33,7,1,5,18,11,35,2));
        s.add(new Batter("Anthony Rizzo", "yankees", "1b", 139, 22,42,5,0,6,17,15,33,5));
        s.add(new Batter("Dummy", "yankees", "of", 10, 2,2,0,0,1,1,0,8,0));
    }

    @Test
    void getBattingAverage() {
        Batter dummy = s.get(3);
        assertEquals(0.2, dummy.getBattingAverage());
    }

    @Test
    void getTotalBases() {
        Batter ajudge = s.get(0);
        int total = ajudge.getTotalBases();
        assertEquals(51, total);
    }
    
    @Test
    void getSlugging() {
        Batter ajudge = s.get(0);
        double slugging = ajudge.getSluggingPercentage();
        assertEquals(0.500, slugging);
    }

    @Test
    void getOBP() {
        Batter ajudge = s.get(0);
        double obp = ajudge.getOnBasePercentage();
        assertEquals(0.364, obp);
    }

}