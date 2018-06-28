package by.algosec.test.dao;

import org.apache.log4j.Logger;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ResourceBundle;

public class HostDaoImpl implements HostDao {
    public final Logger logger = Logger.getLogger(getClass());
    public static final String file_location = ResourceBundle.getBundle("source_name").getString("log_file");

    @Override
    public long getCountOfLines() {
        Path path = Paths.get(file_location);
        long lineCount = -1;
        try {

            lineCount = Files.lines(path).count();

        } catch (IOException e) {
            logger.error("Impossibly to count amount of lines ", e);
        }
        return lineCount;

    }

    @Override
    public String getLineByNumber(int numberOfLine){
        String receivedLine = "";
        try {
            receivedLine = Files.readAllLines(Paths.get(file_location)).get(numberOfLine);
        } catch (IOException e) {
            logger.error("The error has been occured during reading file", e);
        }

        return receivedLine;
    }


}
