package by.algosec.test.dao;

public interface HostDao {
    /**
     * This method returns the count of lines in source file(log file)
     *
     */
    long getCountOfLines() throws DaoException;

    /**
     * This method returns the line received from file by number
     *
     * @param numberOfLine the number of line with which we get a string from a file
     * @throws DaoException if cannot get string by number of line
     */
    String getLineByNumber(int numberOfLine) throws DaoException;
}
