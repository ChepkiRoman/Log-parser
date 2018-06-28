package by.algosec.test.service;

import by.algosec.test.dao.HostDaoImpl;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HostServiceImpl implements HostService {
    public static final Pattern pattern = Pattern.compile("(https?:\\/\\/)([\\da-z\\.-]+)\\.([a-z\\.]{2,6})");

    public HostDaoImpl hostDao = new HostDaoImpl();
    public final long amountOfLines = hostDao.getCountOfLines();
    Map<String, Integer> resultMap = new HashMap<>();

    @Override
    public Map analyse() {
        for (int i = 0; i < amountOfLines; i++) {
            String receivedLine = hostDao.getLineByNumber(i);
            Matcher matcher = pattern.matcher(receivedLine);
            while (matcher.find()) {
                if (resultMap.containsKey(matcher.group())) {
                    int amountVal = resultMap.get(matcher.group());
                    amountVal++;
                    resultMap.put(matcher.group(), amountVal);
                } else {
                    resultMap.put(matcher.group(), 1);
                }

            }
        }
        return resultMap;
    }


    @Override
    public Map sort(Map<String, Integer> resultMap){
        List<Map.Entry<String, Integer>> list =
                new LinkedList<>(resultMap.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, Integer>>() {
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            sortedMap.put(entry.getKey(), entry.getValue());
        }

        return sortedMap;
    }


}
