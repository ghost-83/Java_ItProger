package com.itProger;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {
	    DB db = new DB();

        try {
            db.insertArticle("Новая статья", "Текст статьи", "2050-12-12", "Admin");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
