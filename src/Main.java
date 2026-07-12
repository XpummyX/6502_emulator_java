public class Main {
    public static void main(String[] args) {
        CPUCore cpuCore = new CPUCore();
        //cpuCore.runCore();

        TestManager testManager = new TestManager(cpuCore);
    }
}
