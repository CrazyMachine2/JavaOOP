package blackbox;

import blackbox.com.BlackBoxInt;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
		Scanner scan = new Scanner(System.in);
		StringBuilder sb = new StringBuilder();

		Class blackBox = BlackBoxInt.class;

		Constructor constructor = (Constructor) blackBox.getDeclaredConstructor();
		constructor.setAccessible(true);
		BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();

		Method[] declaredMethods = blackBox.getDeclaredMethods();
		Field field = blackBox.getDeclaredField("innerValue");
		field.setAccessible(true);

		while (true){
			String input = scan.nextLine();

			if(input.equals("END")){
				break;
			}

			String[] data = input.split("_");
			String cmd = data[0];
			int number = Integer.parseInt(data[1]);

			for (Method declaredMethod : declaredMethods) {
				if(declaredMethod.getName().startsWith(cmd)){
					declaredMethod.setAccessible(true);
					declaredMethod.invoke(blackBoxInt,number);
					break;
				}
			}
			System.out.println(field.get(blackBoxInt));
		}
	}
}
