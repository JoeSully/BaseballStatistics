package edu.yu.cs.com1320.se_practice;

import java.util.List;

public abstract class Player {
    protected String team;
    protected String position;
    protected String name;

    public String getName() {
        return this.name;
    }

    public String getTeam() {
        return this.team;
    }

    public String getPosition() {
        return this.position;
    }

    public abstract List<String> getAllStats();
}
