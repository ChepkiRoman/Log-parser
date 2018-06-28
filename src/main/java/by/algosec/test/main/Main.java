package by.algosec.test.main;

import by.algosec.test.printer.Print;
import by.algosec.test.service.HostServiceImpl;

public class Main {
    public static void main(String[] args) {



        HostServiceImpl hostService = new HostServiceImpl();

        Print.print(hostService.sort(hostService.analyse()));

        //HostDaoImpl hostDao = new HostDaoImpl();
        //hostDao.getLine();

    }
}