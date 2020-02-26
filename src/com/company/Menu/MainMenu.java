package com.company.Menu;

import com.company.Input;

import java.io.IOException;

public class MainMenu {

    public static void show() throws IOException {
        boolean exit = false;
        do {
            System.out.println("---------------\nChoose your adventure:");
            System.out.print("[1] Search\n" +
                    "[2] Add\n" +
                    "[3] Edit\n" +
                    "[4] Remove\n" +
                    "[5] Exit\n" +
                    "Enter choice> ");
            int menuChoice = Input.getInt();

            switch (menuChoice) {
                case 1:
                    Menu.getInstance().searchMenu();
                    break;
                case 2:
                    Menu.getInstance().addMenu();
                    break;
                case 3:
//                editMenu();
                    break;
                case 4:
//                removeMenu();
                    break;
                case 5:
                    System.out.println("Bye bye :'/");
                    exit =true;
                    break;
            }
        } while(!exit);
    }
}
