import java.util.ArrayList;

class Task {
    String description;
    boolean completed;

    public Task(String description) {
        this.description = description;
        this.completed = false;
    }

    public void markCompleted() {
        this.completed = true;
    }

    @Override
    public String toString() {
        return description + " - " + (completed ? "Completed" : "Pending");
    }
}

class TaskList {
    private ArrayList<Task> tasks;

    public TaskList() {
        tasks = new ArrayList<>();
    }

    public void addTask(String description) {
        Task task = new Task(description);
        tasks.add(task);
    }

    public void markTaskCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.markCompleted();
        } else {
            System.out.println("Invalid task index");
        }
    }

    public void printTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println("Task " + (i + 1) + ": " + tasks.get(i));
        }
    }
}

class User {
    String name;
    TaskList taskList;

    public User(String name) {
        this.name = name;
        this.taskList = new TaskList();
    }

    public void addTask(String description) {
        taskList.addTask(description);
    }

    public void markTaskCompleted(int index) {
        taskList.markTaskCompleted(index);
    }

    public void printTasks() {
        System.out.println("Tasks for user " + name + ":");
        taskList.printTasks();
    }
}

public class TodoListManager {
    public static void main(String[] args) {
        User[] users = new User[5];
        users[0] = new User("Alex");
        users[1] = new User("Riley");
        users[2] = new User("Isaac");
        users[3] = new User("Abi");
        users[4] = new User("Sav");

        users[0].addTask("Work on API ");
        users[1].addTask("Work on program dev ");
        users[2].addTask("Develop array list ");
        users[3].addTask("Work on client program ");
        users[4].addTask("Work on client program ");

        users[2].markTaskCompleted(0); // Marking the first task as completed for Isaac

        for (User user : users) {
            user.printTasks();
        }
    }
}


