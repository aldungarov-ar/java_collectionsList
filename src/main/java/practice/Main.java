package practice;

import java.util.Iterator;
import java.util.Scanner;

public class Main {

    private static final TodoList todoList = new TodoList();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            String input = scanner.nextLine().strip();
            int index = input.indexOf(' ');
            String command = index != -1 ? input.substring(0, index) : input;
            String todo = input.substring(index + 1);
            int numberOfBusiness;

            switch (command) {
                case "ADD" :
                    if (Character.isDigit(todo.charAt(0))) {
                        index = todo.indexOf(' ');
                        numberOfBusiness = Integer.parseInt(todo.substring(0, index));
                        todo = todo.substring(index + 1);
                        todoList.add(numberOfBusiness, todo);
                    } else {
                        todoList.add(todo);
                    }
                    break;
                case "EDIT" :
                    index = todo.indexOf(' ');
                    numberOfBusiness = Integer.parseInt(todo.substring(0, index));
                    todo = todo.substring(index + 1);
                    todoList.edit(numberOfBusiness, todo);
                    break;
                case "DELETE" :
                    numberOfBusiness = Integer.parseInt(todo);
                    todoList.delete(numberOfBusiness);
                    break;
                case "LIST" :
                    if (todoList.getTodos().isEmpty()) {
                        System.out.println("Список дел пуст");
                    } else {
                        Iterator<String> iterator = todoList.getTodos().iterator();
                        int counter = 0;
                        while (iterator.hasNext()) {
                            System.out.println(counter + " - " + iterator.next());
                            counter++;
                        }
                    }
                    break;
                case "EXIT" :
                    return;
            }
        }
    }
}
