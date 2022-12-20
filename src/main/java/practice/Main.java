package practice;

import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private static final TodoList TODO_LIST = new TodoList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine().strip();
            int index = input.indexOf(' ');
            String command = index != -1 ? input.substring(0, index) : input;
            String todo = input.substring(index + 1);

            if (executeCommand(command, todo)) {
                return;
            }
        }
    }

    private static boolean executeCommand(String command, String todo) {
        int numberOfBusiness;
        int index;
        switch (command) {
            case "ADD" :
                if (Character.isDigit(todo.charAt(0))) {
                    index = todo.indexOf(' ');
                    numberOfBusiness = Integer.parseInt(todo.substring(0, index));
                    todo = todo.substring(index + 1);
                    TODO_LIST.add(numberOfBusiness, todo);
                } else {
                    TODO_LIST.add(todo);
                }
                break;
            case "EDIT" :
                index = todo.indexOf(' ');
                numberOfBusiness = Integer.parseInt(todo.substring(0, index));
                todo = todo.substring(index + 1);
                TODO_LIST.edit(numberOfBusiness, todo);
                break;
            case "DELETE" :
                numberOfBusiness = Integer.parseInt(todo);
                TODO_LIST.delete(numberOfBusiness);
                break;
            case "LIST" :
                if (TODO_LIST.getTodos().isEmpty()) {
                    System.out.println("Список дел пуст");
                } else {
                    Iterator<String> iterator = TODO_LIST.getTodos().iterator();
                    int counter = 0;
                    while (iterator.hasNext()) {
                        System.out.println(counter++ + " - " + iterator.next());
                    }
                }
                break;
            case "EXIT" :
                return true;
        }
        return false;
    }
}
