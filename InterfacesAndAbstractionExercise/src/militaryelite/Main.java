package militaryelite;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Map<Integer, PrivateImpl> privates = new HashMap<>();
        List<SoldierImpl> soldiers = new LinkedList<>();


        while (true) {
            String input = scan.nextLine();

            if (input.equals("End")) {
                break;
            }

            String[] data = input.split(" ");
            String rank = data[0];
            int id = Integer.parseInt(data[1]);
            String firstName = data[2];
            String lastName = data[3];

            if (rank.equals("Private")) {
                PrivateImpl privateSoldier = new PrivateImpl(id, firstName, lastName, Double.parseDouble(data[4]));
                privates.putIfAbsent(id, privateSoldier);
                soldiers.add(privateSoldier);

            } else if (rank.equals("LeutenantGeneral")) {
                LeutenantGeneralImpl leutenantGeneral = new LeutenantGeneralImpl(id, firstName, lastName, Double.parseDouble(data[4]));
                addPrivate(privates, data, leutenantGeneral);
                soldiers.add(leutenantGeneral);

            } else if (rank.equals("Engineer")) {
                try {
                    Engineer engineer = new Engineer(id, firstName, lastName, Double.parseDouble(data[4]), data[5]);
                    addRepairs(data, engineer);
                    soldiers.add(engineer);

                } catch (IllegalArgumentException e) {
                }

            } else if (rank.equals("Commando")) {
                try {
                    Commando commando = new Commando(id, firstName, lastName, Double.parseDouble(data[4]), data[5]);
                    addMission(data, commando);
                    soldiers.add(commando);
                } catch (IllegalArgumentException e) {
                }

            } else if (rank.equals("Spy")) {
                Spy spy = new Spy(id, firstName, lastName, data[4]);
                soldiers.add(spy);
            }
        }
        soldiers.forEach(s -> System.out.println(s.toString()));

    }

    private static void addMission(String[] data, Commando commando) {
        for (int i = 6; i < data.length - 1; i+=2) {
            String codeName = data[i];
            String state = data[i + 1];
            try {
                Mission mission = new Mission(codeName, state);
                commando.addMission(mission);
            } catch (IllegalArgumentException e) {
            }
        }
    }

    private static void addRepairs(String[] data, Engineer engineer) {
        for (int i = 6; i < data.length - 1; i+=2) {
            String partName = data[i];
            int hoursWorked = Integer.parseInt(data[i + 1]);

            Repairs repairs = new Repairs(partName, hoursWorked);
            engineer.addRepairs(repairs);
        }
    }

    private static void addPrivate(Map<Integer, PrivateImpl> privates, String[] data, LeutenantGeneralImpl leutenantGeneral) {
        for (int i = 5; i < data.length; i++) {
            int privateId = Integer.parseInt(data[i]);
            leutenantGeneral.add(privates.get(privateId));
        }
    }
}


























