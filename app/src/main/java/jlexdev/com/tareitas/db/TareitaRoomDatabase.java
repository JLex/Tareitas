package jlexdev.com.tareitas.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.support.annotation.NonNull;

import jlexdev.com.tareitas.db.dao.TareitaDao;
import jlexdev.com.tareitas.db.entity.Tareita;

@Database(entities = {Tareita.class}, version = 1)
public abstract class TareitaRoomDatabase extends RoomDatabase {

    public final static String DATABASE_NAME = "tareita_database";

    public abstract TareitaDao tareitaDAO();

    private static TareitaRoomDatabase INSTANCE;

    public static TareitaRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (TareitaRoomDatabase.class) {
                if (INSTANCE == null) {
                    // Create database here!
                    INSTANCE = Room.databaseBuilder(
                            context.getApplicationContext(),
                            TareitaRoomDatabase.class,
                            DATABASE_NAME)
                            .addCallback(roomDatabaseCallback)
                            .build();
                }
            }
        }
        return INSTANCE;
    }

    // Creating Callback
    private static RoomDatabase.Callback roomDatabaseCallback = new RoomDatabase.Callback() {
/*
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
        }
*/
        @Override
        public void onOpen(@NonNull SupportSQLiteDatabase db) {
            super.onOpen(db);
        }
    };





}
