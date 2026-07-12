public class Test {
    int vector;

    TestWrite[] writes;

    TestState primary;
    TestState expected;

    String text;
    public Test(String text,int vector,TestState primary,TestState expected)
    {
        this.text=text;
        this.vector=vector;
        this.primary=primary;
        this.expected=expected;
    }
    public void setWrites(TestWrite[] writes)
    {
        this.writes=writes;
    }
    public void setWriteLength(int length)
    {
        writes = new TestWrite[length];
    }
    public void setWrite(int index,TestWrite write)
    {
        writes[index] = write;
    }
    public void executeTest(CPUCore cpu)
    {
        cpu.cpuState.setCPUStateBasedOnTestState(primary);
        cpu.addressBus.applyWrites(writes);
        System.out.print(text);
        cpu.executeInstruction();
        if(cpu.cpuState.doesStateMatchTestState(expected)){
            System.out.println("Ok!");
        }else{
            System.out.println("Error");
            if(expected.resultsInMemory) {
                System.out.println("actual: "+cpu.addressBus.readByte(expected.address)+" expected: "+expected.value);
            }
            System.out.println(Integer.toHexString(expected.AC)+", "+Integer.toHexString(cpu.cpuState.AC));
        }
    }
}
