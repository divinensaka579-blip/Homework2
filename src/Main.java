//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
import java.io.*;

public class Main {
    public static void main(String[] args) {

        String[] gyms = {"GYM 1", "GYM 2", "GYM 3"};
        int[][] weight = {{10, 20, 27}, {22, 5, 20}, {30, 20, 10}};
        String filename = "GymWeightLoss.txt";

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {

            writer.write(" GYM WEIGHTLOSS APPLICATION");
            writer.newLine();
            writer.write("------------------------------------------------------------------");
            writer.newLine();
            writer.write(String.format("%-10s %-10s %-10s %-10s %-10s %-12s %-10s %-10s%n",
                    "GYM", "M1", "M2", "M3", "TOTAL", "AVG", "MIN", "MAX"));
            writer.write("------------------------------------------------------------------");
            writer.newLine();

            for (int i = 0; i < gyms.length; i++) {
                int total = 0;
                int min = weight[i][0];
                int max = weight[i][0];

                for (int j = 0; j < weight[i].length; j++) {
                    total += weight[i][j];
                    if (weight[i][j] < min) min = weight[i][j];
                    if (weight[i][j] > max) max = weight[i][j];
                }

                double avg = (double) total / 3;

                writer.write(String.format("%-10s %-10s %-10s %-10s %-10s %-12s %-10s %-10s%n",
                        gyms[i],
                        weight[i][0] + "kg",
                        weight[i][1] + "kg",
                        weight[i][2] + "kg",
                        total + "kg",
                        String.format("%.2fkg", avg),
                        min + "kg",
                        max + "kg"));
            }

            writer.write("------------------------------------------------------------------");
            writer.newLine();
            System.out.println("Data successfully written to " + filename);

        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }


        System.out.println();
        System.out.println("READING DATA FROM FILE");
        System.out.println("=========================================================================================================================");
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine())!= null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file " + e.getMessage());
        }
    }
}