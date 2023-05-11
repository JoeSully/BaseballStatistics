package edu.yu.cs.com1320.se_practice.impl;

import edu.yu.cs.com1320.se_practice.Player;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;

public class Statistics {
    private final List<Pitcher> pitchers = new ArrayList<>();
    private final List<Batter> batters = new ArrayList<>();
    private final Trie<Player> trie = new Trie<>();

    public void addPlayer(Player p) {
        if (p instanceof Pitcher) {
            this.pitchers.add((Pitcher)p);
        } else {
            this.batters.add((Batter)p);
        }
        this.trie.put(p.getName(), p);
    }

    public Player removePlayer(Player p) {
        if (p instanceof Pitcher) {
            this.pitchers.remove((Pitcher)p);
        } else {
            this.batters.remove((Batter)p);
        }
        return this.trie.delete(p.getName(), p);
    }

    public List<String> getTeamBattingLeaders(String stat, String team) {
        List<Batter> players = new ArrayList<>();
        for (Batter b : this.batters) {
            if (b.getTeam().equals(team)) {
                players.add(b);
            }
        }
        return this.compareBatters(players, stat);
    }

    public List<String> getTeamPitchingLeaders(String stat, String team) {
        List<Pitcher> players = new ArrayList<>();
        for (Pitcher p : this.pitchers) {
            if (p.getTeam().equals(team)) {
                players.add(p);
            }
        }
        return this.comparePitchers(players, stat);
    }

    /*public List<String> getPositionLeaders(String stat, String position) {
        List<Player> players = new ArrayList<>();
        List<Player> allPlayers = new ArrayList<>(this.batters);
        allPlayers.addAll(this.pitchers);
        for (Player p : allPlayers) {
            if (p.getPosition().equals(position)) {
                players.add(p);
            }
        }
        return this.comparePitchers(players, stat);
    }*/

    public List<String> getLeagueBattingLeaders(String stat) {
        return this.compareBatters(this.batters, stat);
    }

    public List<String> getLeaguePitchingLeaders(String stat) {
        return this.comparePitchers(this.pitchers, stat);
    }

    public List<String> compareBatters(List<Batter> players, String stat) {
        Comparator<Batter> comp;
        Function<Batter, String> getStat;
        switch (stat) {
            case "h" -> {
                comp = Comparator.comparingInt(Batter::getHits);
                getStat = p -> "Hits: " + p.getHits();
            }
            case "r" -> {
                comp = Comparator.comparingDouble(Batter::getRuns);
                getStat = p -> "Runs: " + p.getRuns();
            }
            case "hr" -> {
                comp = Comparator.comparingInt(Batter::getHomeRuns);
                getStat = p -> "Home Runs: " + p.getHomeRuns();
            }
            case "rbi" -> {
                comp = Comparator.comparingInt(Batter::getRunsBattedIn);
                getStat = p -> "Runs Batted In: " + p.getRunsBattedIn();
            }
            case "double", "2b" -> {
                comp = Comparator.comparingInt(Batter::getDoubles);
                getStat = p -> "Doubles: " + p.getDoubles();
            }
            case "triple", "3b" -> {
                comp = Comparator.comparingInt(Batter::getTriples);
                getStat = p -> "Triples: " + p.getTriples();
            }
            case "tb" -> {
                comp = Comparator.comparingInt(Batter::getTotalBases);
                getStat = p -> "Total Bases: " + p.getTotalBases();
            }
            case "hbp" -> {
                comp = Comparator.comparingInt(Batter::getHitByPitch);
                getStat = p -> "Hit By Pitch: " + p.getHitByPitch();
            }
            case "bb" -> {
                comp = Comparator.comparingInt(Batter::getWalks);
                getStat = p -> "Walks: " + p.getWalks();
            }
            case "k", "so" -> {
                comp = Comparator.comparingInt(Batter::getStrikeouts);
                getStat = p -> "Strikeouts: " + p.getStrikeouts();
            }
            case "pa" -> {
                comp = Comparator.comparingInt(Batter::getPlateAppearances);
                getStat = p -> "Plate Appearances: " + p.getPlateAppearances();
            }
            case "ab" -> {
                comp = Comparator.comparingInt(Batter::getAtBats);
                getStat = p -> "At Bats: " + p.getAtBats();
            }
            case "slg" -> {
                comp = Comparator.comparingDouble(Batter::getSluggingPercentage);
                getStat = p -> "Slugging Percentage: " + p.getSluggingPercentage();
            }
            case "avg", "ba" -> {
                comp = Comparator.comparingDouble(Batter::getBattingAverage);
                getStat = p -> "Batting Average: " + p.getBattingAverage();
            }
            case "ops" -> {
                comp = Comparator.comparingDouble(Batter::getOnBasePlusSlugging);
                getStat = p -> "On Base Plus Slugging Percentage: " + p.getOnBasePercentage();
            }
            case "obp" -> {
                comp = Comparator.comparingDouble(Batter::getOnBasePercentage);
                getStat = p -> "On Base Percentage: " + p.getOnBasePercentage();
            }
            default -> throw new IllegalArgumentException("Choose one of the valid stats");
        }
        players.sort(comp);
        List<String> results = new ArrayList<>();
        for (Batter p : players) {
            results.add(p.getName() + ", " + p.getTeam() + ", " + p.getPosition() + ", " + getStat.apply(p));
        }
        return results;
    }

    public List<String> comparePitchers(List<Pitcher> players, String stat) {
        Comparator<Pitcher> comp;
        Function<Pitcher, String> getStat;
        switch (stat) {
            case "h" -> {
                comp = Comparator.comparingInt(Pitcher::getHitsAllowed);
                getStat = p -> "Hits Allowed: " + p.getHitsAllowed();
            }
            case "ip" -> {
                comp = Comparator.comparingDouble(Pitcher::getInningsPitched);
                getStat = p -> "Innings Pitched: " + p.getInningsPitched();
            }
            case "hr" -> {
                comp = Comparator.comparingInt(Pitcher::getHomeRunsAllowed);
                getStat = p -> "Home Runs Allowed: " + p.getHomeRunsAllowed();
            }
            case "r" -> {
                comp = Comparator.comparingInt(Pitcher::getRunsAllowed);
                getStat = p -> "Runs Allowed: " + p.getRunsAllowed();
            }
            case "er" -> {
                comp = Comparator.comparingInt(Pitcher::getEarnedRuns);
                getStat = p -> "Earned Runs Allowed: " + p.getEarnedRuns();
            }
            case "sho" -> {
                comp = Comparator.comparingInt(Pitcher::getShutouts);
                getStat = p -> "Shutouts: " + p.getShutouts();
            }
            case "sv" -> {
                comp = Comparator.comparingInt(Pitcher::getSaves);
                getStat = p -> "Saves: " + p.getSaves();
            }
            case "era" -> {
                comp = Comparator.comparingDouble(Pitcher::getERA);
                getStat = p -> "Earned Run Average: " + p.getERA();
            }
            case "g" -> {
                comp = Comparator.comparingInt(Pitcher::getGames);
                getStat = p -> "Games: " + p.getGames();
            }
            case "cg" -> {
                comp = Comparator.comparingInt(Pitcher::getCompleteGames);
                getStat = p -> "Complete Games: " + p.getCompleteGames();
            }
            case "k", "so" -> {
                comp = Comparator.comparingInt(Pitcher::getStrikeouts);
                getStat = p -> "Strikeouts: " + p.getStrikeouts();
            }
            case "bb" -> {
                comp = Comparator.comparingInt(Pitcher::getWalks);
                getStat = p -> "Walks: " + p.getWalks();
            }
            case "hbp" -> {
                comp = Comparator.comparingInt(Pitcher::getHitByPitch);
                getStat = p -> "Hit By Pitch: " + p.getHitByPitch();
            }
            case "whip" -> {
                comp = Comparator.comparingDouble(Pitcher::getWhip);
                getStat = p -> "Walks and Hits Per Inning Pitched: " + p.getWhip();
            }
            case "h9" -> {
                comp = Comparator.comparingDouble(Pitcher::getHitsPer9);
                getStat = p -> "Hits Per 9 Innings: " + p.getHitsPer9();
            }
            case "w9", "bb9" -> {
                comp = Comparator.comparingDouble(Pitcher::getWalksPer9);
                getStat = p -> "Walks Per 9 Innings: " + p.getWalksPer9();
            }
            case "hr9" -> {
                comp = Comparator.comparingDouble(Pitcher::getHomeRunsPer9);
                getStat = p -> "Home Runs Per 9 Innings: " + p.getHomeRunsPer9();
            }
            case "k9", "so9" -> {
                comp = Comparator.comparingDouble(Pitcher::getStrikeoutsPer9);
                getStat = p -> "Strikeouts Per 9 Innings: " + p.getStrikeoutsPer9();
            }
            default -> throw new IllegalArgumentException("Choose one of the valid stats");
        }
        players.sort(comp);
        List<String> results = new ArrayList<>();
        for (Pitcher p : players) {
            results.add(p.getName() + ", " + p.getTeam() + ", " + p.getPosition() + ", " + getStat.apply(p));
        }
        return results;
    }

    public List<String> searchPlayerStats(String player) {
        if (player == null) {
            throw new IllegalArgumentException("PLayer cna't be null");
        }
        return this.trie.get(player).getAllStats();
    }
}
