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
        if(name.trim().isEmpty()){
            throw new IllegalArgumentException("A name should not be empty.");
        }
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }

    public void removePlayer(String name){
        if(!containsPlayer(name)){
            String message = String.format("Player %s is not in %s team.",name,this.name);
            throw new IllegalArgumentException(message);
        }
        Player player = getPlayer(name);
        this.players.remove(player);
    }

    public double getRating(){
        double result = 0;

        for(Player player : this.players){
            result += player.overallSkill();
        }
        return result / this.players.size();
    }

    private boolean containsPlayer(String name) {
       for(Player player : this.players){
           if(player.getName().equals(name)){
               return true;
           }
       }
       return false;

    }

    private Player getPlayer(String name) {
        Player searchedPlayer = null;

        for (Player player : this.players){
            if(player.getName().equals(name)){
                searchedPlayer = player;
            }
        }
        return searchedPlayer;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, Math.round(this.getRating()));
    }
}
