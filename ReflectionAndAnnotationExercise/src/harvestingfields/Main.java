package harvestingfields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        Class richSoilLand = pr01HarvestingFields.RichSoilLand.class;
        Field[] declaredFields = richSoilLand.getDeclaredFields();
        StringBuilder sb = new StringBuilder();

        while (true) {
            String cmd = scan.nextLine();

            if(cmd.equals("HARVEST")){
                break;
            }

            if(cmd.equals("all")){
                Arrays.stream(declaredFields).forEach(f -> sb.append(Modifier.toString(f.getModifiers()))
                                .append(" ")
                                .append(f.getType().getSimpleName())
                                .append(" ")
                                .append(f.getName())
                                .append(System.lineSeparator()));
            }

            Arrays.stream(declaredFields).filter(f -> Modifier.toString(f.getModifiers()).equals(cmd))
                    .forEach(f -> sb.append(Modifier.toString(f.getModifiers()))
                    .append(" ")
                    .append(f.getType().getSimpleName())
                    .append(" ")
                    .append(f.getName())
                    .append(System.lineSeparator()));


//            switch (cmd) {
//                case "private":
//                    Arrays.stream(declaredFields).filter(f -> Modifier.isPrivate(f.getModifiers()))
//                            .forEach(f -> sb.append(Modifier.toString(f.getModifiers()))
//                                    .append(" ")
//                                    .append(f.getType().getSimpleName())
//                                    .append(" ")
//                                    .append(f.getName())
//                                    .append(System.lineSeparator()));
//                    break;
//                case "protected":
//                    Arrays.stream(declaredFields).filter(f -> Modifier.isProtected(f.getModifiers()))
//                            .forEach(f -> sb.append(Modifier.toString(f.getModifiers()))
//                                    .append(" ")
//                                    .append(f.getType().getSimpleName())
//                                    .append(" ")
//                                    .append(f.getName())
//                                    .append(System.lineSeparator()));
//                    break;
//                case "public":
//                    Arrays.stream(declaredFields).filter(f -> Modifier.isPublic(f.getModifiers()))
//                            .forEach(f -> sb.append(Modifier.toString(f.getModifiers()))
//                                    .append(" ")
//                                    .append(f.getType().getSimpleName())
//                                    .append(" ")
//                                    .append(f.getName())
//                                    .append(System.lineSeparator()));
//                    break;
//                case "all":
//                    Arrays.stream(declaredFields)
//                            .forEach(f -> sb.append(Modifier.toString(f.getModifiers()))
//                                    .append(" ")
//                                    .append(f.getType().getSimpleName())
//                                    .append(" ")
//                                    .append(f.getName())
//                                    .append(System.lineSeparator()));
//                    break;
//                default:
//                    break;
//            }
        }
        System.out.println(sb);
    }
}
