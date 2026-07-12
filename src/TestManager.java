import com.google.gson.Gson;

import java.io.*;

public class TestManager {
    CPUCore cpu;

    Test test;
    Test[] tests;
    public TestManager(CPUCore cpu)
    {
        this.cpu=cpu;
        tests = new Test[2];

        Gson gson = new Gson();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File("Res/tests.json")));
            String loaded = reader.readAllAsString();
            tests = gson.fromJson(loaded,Test[].class);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        for(int i=0;i<tests.length;i++)
        {
            if(tests[i]!=null)tests[i].executeTest(cpu);
        }
        //tests[0].executeTest(cpu);


        //test = new Test(cpu);

        //System.out.println();
    }
}
