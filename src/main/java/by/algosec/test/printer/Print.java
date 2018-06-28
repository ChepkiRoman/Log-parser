package by.algosec.test.printer;

import java.util.Map;

public class Print {
    public static void print(Map<String, Integer> resultMap){
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            System.out.println("Host: " + entry.getKey()+", Count: "+entry.getValue());
        }
    }


}
