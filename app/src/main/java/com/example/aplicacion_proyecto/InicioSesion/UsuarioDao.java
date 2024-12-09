package com.example.aplicacion_proyecto.InicioSesion;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UsuarioDao {

    private SQLiteDatabase db;
    private DBHelper dbHelper;

    public UsuarioDao(Context context) {
        dbHelper = new DBHelper(context);
    }

    public boolean isUserExists(String username) {
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("users", null, "username = ?", new String[]{username}, null, null, null);
        boolean exists = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return exists;
    }

    public void insertUser(Usuario user) {
        db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("username", user.getUsername());
        values.put("password", user.getPassword());
        db.insert("users", null, values);
        db.close();
    }

    public boolean authenticateUser(String username, String password) {
        db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("users", null, "username = ? AND password = ?", new String[]{username, password}, null, null, null);
        boolean authenticated = cursor.getCount() > 0;
        cursor.close();
        db.close();
        return authenticated;
    }
}
