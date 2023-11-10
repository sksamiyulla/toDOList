import java.util.ArrayList;
import java.util.Scanner;

class Task {
    private String description;
    private boolean isCompleted;

    public Task(String description) {
        this.description = description;
        this.isCompleted = false;
    }

    public String getDescription() {
        return description;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}

class TodoList {
    private ArrayList<Task> tasks;

    public TodoList() {
        this.tasks = new ArrayList<>();
    }

    public void addTask(Task task) {
        tasks.add(task);
        System.out.println("Task added: " + task.getDescription());
    }

    public void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.setCompleted(true);
            System.out.println("Task marked as completed: " + task.getDescription());
        } else {
            System.out.println("Invalid index");
        }
    }

   
     public Task[] getAllTasks() {
        return tasks.toArray(new Task[0]);
    }

    public String displayTasks() {
        StringBuilder stringBuilder = new StringBuilder("----- Your To-Do List -----\n");
        for (int i = 0; i < tasks.size(); i++) {
            Task task = tasks.get(i);
            stringBuilder.append(i + 1).append(". ").append(task.isCompleted() ? "[X] " : "[ ] ").append(task.getDescription()).append("\n");
        }
        stringBuilder.append("---------------------------");
        return stringBuilder.toString();
    }
}


public class toDOList {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TodoList todoList = new TodoList();

        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Mark Task as Completed");
            System.out.println("3. Display Tasks");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter task description: ");
                    String taskDescription = scanner.nextLine();
                    Task newTask = new Task(taskDescription);
                    todoList.addTask(newTask);
                    break;
                case 2:
                    System.out.print("Enter the index of the task to mark as completed: ");
                    int taskIndex = scanner.nextInt();
                    todoList.markTaskAsCompleted(taskIndex - 1); // Adjust for 0-based indexing
                    break;
                case 3:
                    todoList.displayTasks();
                    break;
                case 4:
                    System.out.println("Exiting the program. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.");
                
            }
            scanner.close();
        }
    }
}
