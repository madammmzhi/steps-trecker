import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker(scanner);

        while (true) {
            printMenu();
            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    stepTracker.addNewNumberStepsPerDay();
                    break;
                case 2:
                    stepTracker.changeStepGoal();
                    break;
                case 3:
                    stepTracker.printStatistic();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Такой команды в меню нет, давайте попробуем выбрать снова.");
            }

        }
    }

    public static void printMenu() {
        System.out.println("Выберите пункт меню, который необходимо выполнить:");
        System.out.println("1. Ввести количество шагов за определённый день.");
        System.out.println("2. Изменить цель по количеству шагов в день.");
        System.out.println("3. Напечатать статистику за определённый период.");
        System.out.println("0. Выйти из приложения.");
    }
}