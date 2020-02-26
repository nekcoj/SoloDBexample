package com.company.Menu;

import com.company.Add;
import com.company.App;
import com.company.Input;

public class AddMenu {

    public static void show() {
        System.out.println("---------------\nAdd Menu");
        System.out.print("[1] Artist\n" +
                "[2] Album\n" +
                "[3] Song\n" +
                "[4] Return to main menu\n" +
                "Enter choice> ");

        int menuChoice = Input.getInt();

        switch (menuChoice){
            case 1:
                Add.addArtist(App.artists);
                break;
            case 2:
                Add.addAlbum(App.artists);
                break;
            case 3:
                System.out.println("Add song> ");
                break;
        }
    }
}
