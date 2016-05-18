package net.spinel.hexcards.utils;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import net.spinel.hexcards.models.Card;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Spinel on 16/5/16.
 */
public class DBHelper {
    private static DBHelper instance;
    private static SQLiteDatabase database = null;

    private DBHelper() {
    }

    public static DBHelper getInstance() {
        if (instance == null) {
            instance = new DBHelper();
        }
        return instance;
    }

    private void openDatabaseConnection() {
        database = SQLiteDatabase.openOrCreateDatabase(DBManager.DB_PATH + "/" + DBManager.DB_NAME, null);
    }

    public int queryCount(String rawQueryString) {
        if (database == null) {
            openDatabaseConnection();
        }

        Cursor cursor = database.rawQuery(rawQueryString.replace("*", "count(*)"), null);
        int count = 0;
        if (cursor != null) {
            cursor.moveToFirst();
            count = cursor.getInt(0);
            cursor.close();
        }
        return count;
    }

    public List<Card> queryCards(String rawQueryString) {
        if (database == null) {
            openDatabaseConnection();
        }

        Cursor cursor = database.rawQuery(rawQueryString, null);
        if (cursor != null && cursor.getCount() != 0) {
            cursor.moveToFirst();
            List<Card> results = new ArrayList<>();
            if (cursor.moveToFirst()) {
                do {
                    Card card = new Card(
                            cursor.getInt(cursor.getColumnIndex("id")),
                            cursor.getString(cursor.getColumnIndex("version")),
                            cursor.getInt(cursor.getColumnIndex("card_no")),
                            cursor.getString(cursor.getColumnIndex("color")),
                            cursor.getString(cursor.getColumnIndex("name")),
                            cursor.getString(cursor.getColumnIndex("name_en")),
                            cursor.getInt(cursor.getColumnIndex("cost")),
                            cursor.getString(cursor.getColumnIndex("requirement")),
                            cursor.getInt(cursor.getColumnIndex("power")),
                            cursor.getInt(cursor.getColumnIndex("defense")),
                            cursor.getInt(cursor.getColumnIndex("is_unique")) == 1,
                            cursor.getString(cursor.getColumnIndex("type")),
                            cursor.getString(cursor.getColumnIndex("subtype")),
                            cursor.getString(cursor.getColumnIndex("rarity")),
                            cursor.getString(cursor.getColumnIndex("camp")),
                            cursor.getString(cursor.getColumnIndex("rule")),
                            cursor.getString(cursor.getColumnIndex("description")),
                            cursor.getString(cursor.getColumnIndex("img_url"))
                    );
                    results.add(card);
                } while (cursor.moveToNext());
            }
            cursor.close();
            return results;
        } else {
            if (cursor != null) {
                cursor.close();
            }
        }
        return new ArrayList<>();
    }

    public void closeDatabaseConnection() {
        database.close();
        database = null;
    }
}
