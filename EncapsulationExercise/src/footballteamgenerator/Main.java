package footballteamgenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<String,Team> teams = new HashMap<>();

        while(true){
            String input = scan.nextLine();

            if(input.equals("END")){
                break;
            }

            String[] data = input.split(";");
            String teamName = data[1];

            switch (data[0]){
                case "Team":
                    try{
                        Team team = new Team(teamName);
                        teams.putIfAbsent(teamName,team);
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case "Add":
                    if(!teams.containsKey(teamName)){
                        System.out.printf("Team %s does not exist.%n",teamName);
                        continue;
                    }
                    String playerName = data[2];
                    int endurance = Integer.parseInt(data[3]);
                    int sprint = Integer.parseInt(data[4]);
                    int dribble = Integer.parseInt(data[5]);
                    int passing = Integer.parseInt(data[6]);
                    int shooting = Integer.parseInt(data[7]);

                    try {
                        Player player = new Player(playerName,endurance,sprint,dribble,passing,shooting);
                        teams.get(teamName).addPlayer(player);

                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }
                    break;
                case "Remove":
                    try {
                        teams.get(teamName).removePlayer(data[2]);
                    } catch (IllegalArgumentException e){
                        System.out.println(e.getMessage());
                    }

                    break;
                case "Rating":
                    if(!teams.containsKey(teamName)){
                        System.out.printf("Team %s does not exist.%n",teamName);
                        continue;
                    }
                    System.out.println(teams.get(teamName).toString());
                    break;
            }
        }
    }
}
