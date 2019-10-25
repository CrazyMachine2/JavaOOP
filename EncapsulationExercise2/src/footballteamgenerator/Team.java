package footballteamgenerator;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String name;
    private List<Player> players;

    public Team(String name) {
        this.setName(name);
        this.players = new ArrayList<>();
    }

    private void setName(String name) {
        if (name.isEmpty() || name.trim().isEmpty()) {
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public void addPlayer(Player player) {
        this.players.add(player);
    }

    public void removePlayer(String player) {
        if (!ifPlayerExists(player)) {
            throw new IllegalArgumentException(String.format("Player %s is not in %s team.", player, this.name));
        }
        Player searchedPlayer = getPlayer(player);
        this.players.remove(searchedPlayer);
    }

    private Player getPlayer(String player) {
        Player searchedPlayer = null;
        for (Player currentPlayer : this.players) {
            if (currentPlayer.getName().equals(player)) {
                searchedPlayer = currentPlayer;
                return searchedPlayer;
            }
        }
        return searchedPlayer;
    }


    private boolean ifPlayerExists(String playerName) {
        for (Player player : this.players) {
            if (player.getName().equals(playerName)) {
                return true;
            }
        }
        return false;
    }

    public double getRating() {
//        double result = 0;
//
//        for (Player player : this.players) {
//            result += player.overallSkillLevel();
//        }
//        return result / this.players.size();

        return Math.round(this.players.stream().mapToDouble(Player::overallSkillLevel).average().orElse(0));
    }



}











