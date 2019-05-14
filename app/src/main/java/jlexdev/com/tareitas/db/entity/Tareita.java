package jlexdev.com.tareitas.db.entity;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

@Entity(tableName = "tareita_table")
public class Tareita {

    @PrimaryKey//(autoGenerate = true)
    @NonNull
    @ColumnInfo(name = "tareita")
    private String title;
    private String description;


    public Tareita(@NonNull String title, @NonNull String description) {
        this.title = title;
        this.description = description;
    }


    // Setters
    public void setTitle(@NonNull String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // Getters
    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }
}
