import java.util.Scanner;

public class StepTracker {

    MonthData[] monthToData = new MonthData[12];
    Converter converter = new Converter();
    Scanner scanner;
    int goalByStepsPerDay = 10000;

    StepTracker(Scanner scanner) {
        this.scanner = scanner;

        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }

    void addNewNumberStepsPerDay() {
        System.out.println("Введите номер месяца");
        int month = scanner.nextInt();

        System.out.println("Введите день от 1 до 30 (включительно)");
        int day = scanner.nextInt();

        System.out.println("Введите количество шагов");
        int steps = scanner.nextInt();

        if (((1 <= month) && (month <= 12)) & ((1 <= day) && (day <= 30)) & (steps > 0)) {
            // получение соответствующего объекта MonthData из массива
            MonthData monthData = monthToData[month - 1];
            // сохранение полученных данных
            monthData.days[day - 1] = steps;
        } else {
            System.out.println("Введены неверные данные, попробуйте снова.");
            return;
        }
    }

    void changeStepGoal() {
        System.out.println("Введите новую цель.");
        int goalSteps = scanner.nextInt();

        if (goalSteps > 0) {
            goalByStepsPerDay = goalSteps;
        } else {
            System.out.println("Значение не может быть меньше или равно нулю. Попробуйте ввести снова.");
            return;
        }
    }

    void printStatistic() {
        System.out.println("Введите номер месяца за который требуется вывести статистику: ");
        int month = scanner.nextInt();
        if ((1 <= month) && (month <= 12)) {
            // получение соответствующего объекта MonthData из массива
            MonthData monthData = monthToData[month - 1];
            // получение данных
            int sumSteps = monthData.sumStepsFromMonth();
            System.out.println("Количество пройденных шагов по дням:");
            monthData.printDaysAndStepsFromMonth();
            System.out.println("Общее количество шагов за месяц: " + sumSteps);
            System.out.println("Максимальное пройденное количество шагов в месяце: " + monthData.maxSteps());
            System.out.println("Среднее количество шагов: " + sumSteps / 30);
            System.out.println("Пройденная дистанция (в километрах): " + converter.convertToKm(sumSteps));
            System.out.println("Количество сожжённых килокалорий: " + converter.convertStepsToKilocalories(sumSteps));
            System.out.println("Лучшая серия: " + monthData.bestSeries(goalByStepsPerDay));
            System.out.println();
        } else {
            System.out.println("Введены неверные данные, попробуйте снова.");
            return;
        }
    }
}
