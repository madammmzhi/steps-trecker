public class MonthData {
    int[] days = new int[30];

    void printDaysAndStepsFromMonth() {
        System.out.println("Количество пройденных шагов: ");
        for (int i = 0; i < days.length; i++) {
            System.out.println((i + 1) + " день: " + days[i]);
        }
    }

    int sumStepsFromMonth() {
        System.out.println("Общее количество пройденных шагов за месяц: ");
        int sumSteps = 0;
        for (int i = 0; i < days.length; i++) {
            sumSteps += days[i];
        }
        return sumSteps;
    }

    int maxSteps() {
        int maxCountSteps = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] > maxCountSteps) {
                maxCountSteps = days[i];
            }
        }
        return maxCountSteps;
    }

    int bestSeries(int goalByStepsPerDay) {
        int currentSeries = 0;
        int finalSeries = 0;
        for (int i = 0; i < days.length; i++) {
            if (days[i] >= goalByStepsPerDay && days[i + 1] >= goalByStepsPerDay) {
                currentSeries++;
            } else {
                if (currentSeries > finalSeries) {
                    finalSeries = currentSeries;
                }
                currentSeries = 0;
            }
        }
        return finalSeries;
    }
}
