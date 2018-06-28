package by.algosec.test.service;

import java.util.Map;

public interface HostService {
    /**
     * This method returns Map and checks the string for the presence of url
     */
    Map analyse();

    /**
     * This method returns Map and sorts incoming Map in descending order
     *
     * @param resultMap map which we will sort
     */
    Map sort(Map<String, Integer> resultMap);
}
