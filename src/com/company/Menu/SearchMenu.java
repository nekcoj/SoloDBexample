package com.company.Menu;

import com.company.App;
import com.company.Input;
import com.company.Search;
import com.company.SearchOption;
import com.company.pojo.MusicObject;

import java.util.List;

public class SearchMenu {

    public static void show(){
        System.out.println("---------------\nSearch Menu");
        System.out.print("[1] Artists\n" +
                "[2] Albums\n" +
                "[3] Songs\n" +
                "[4] Search all\n" +
                "[5] Return to main menu\n" +
                "Enter choice> ");

        int menuChoice = Input.getInt();
        List<MusicObject> results;
        switch (menuChoice){
            case 1:
                System.out.print("Search for artist by name> ");
                results = App.searchByName(SearchOption.ARTIST);
                Search.showResults(results, true);
                break;
            case 2:
                System.out.print("Search for album by title> ");
                results = App.searchByName(SearchOption.ALBUM);
                Search.showResults(results, true);
                break;
            case 3:
                System.out.print("Search for song by title> ");
                results = App.searchByName(SearchOption.SONG);
                Search.showResults(results, true);
                break;
        }
    }
}
