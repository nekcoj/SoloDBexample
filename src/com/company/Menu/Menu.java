package com.company.Menu;

import java.io.IOException;

public class Menu {

    private static final Menu INSTANCE = new Menu();

    public static Menu getInstance() {
        return Menu.INSTANCE;
    }

    public void showMainMenu() throws IOException {
        MainMenu.show();
    }

    public void searchMenu(){
        SearchMenu.show();
    }

    public void addMenu() throws IOException {
        AddMenu.show();
    }
}

