public class Main {
    public static void main(String[] args) {
        Experiment experiment = new Experiment();

        System.out.println("Warming up JVM...");
        experiment.warmup();

        System.out.println("Starting experiments...");
        experiment.runMultipleTests(); // [cite: 49, 74]
    }
}