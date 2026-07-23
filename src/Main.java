public class Main {
    public static void main(String[] args) {
        CPUCore cpuCore = new CPUCore();
        //cpuCore.runCore();

        System.out.println((byte)(225));
        TestManager testManager = new TestManager(cpuCore);
    }
}
