package edu.yu.cs.com1320.se_practice.impl;

import static org.junit.jupiter.api.Assertions.*;

import edu.yu.cs.com1320.se_practice.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class PitcherTest {

    Pitcher p;

    @BeforeEach
    void setUp() {
        p = new Pitcher("Gerrit Cole", "yankees", "sp", 8, 1, 1, 0,51.2,36,13,12,2,16,58,2);
    }

    @Test
    void getWHIP() {
        double whip = p.getWhip();
        assertEquals(0,whip);
    }
}