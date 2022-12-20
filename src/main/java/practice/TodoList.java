package practice;

import java.util.ArrayList;

public class TodoList {

    private final ArrayList<String> todoList = new ArrayList<>();
    private final String OUT_OF_BOUND_TEXT = "Дело с таким номером не существует";
    private final String BUSINESS_ADDED_TEXT = "Добавлено дело ";

    public void add(String todo) {
        todoList.add(todo);
        System.out.println(BUSINESS_ADDED_TEXT + "\"" + todo + "\"");
    }

    public void add(int index, String todo) {
        if (index >= 0 && index <= todoList.size()) {
            todoList.add(index, todo);
            System.out.println(BUSINESS_ADDED_TEXT + "\"" + todo + "\"");
        } else if (index > todoList.size()) {
            todoList.add(todo);
        } else {
            System.out.println(OUT_OF_BOUND_TEXT);
        }
    }

    public void edit(int index, String todo) {
        if (index < todoList.size() && index >= 0) {
            System.out.println("Дело \"" + todoList.get(index) + "\" заменено на \"" + todo + "\"");
            todoList.set(index, todo);
        } else {
            System.out.println(OUT_OF_BOUND_TEXT);
        }
    }

    public void delete(int index) {
        if (index < todoList.size() && index >= 0) {
            System.out.println("Дело \"" + todoList.get(index) + "\" удалено");
            todoList.remove(index);
        } else {
            System.out.println(OUT_OF_BOUND_TEXT);
        }
    }

    public ArrayList<String> getTodos() {
        return todoList;
    }
}