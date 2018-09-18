package projects.shiro.education101.models;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

@Entity
public class ObscureWord {
    @PrimaryKey
    private int Id;
    private String Word;
    private String WordDefinition;
    private boolean Used;

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getWord() {
        return Word;
    }

    public void setWord(String word) {
        Word = word;
    }

    public String getWordDefinition() {
        return WordDefinition;
    }

    public void setWordDefinition(String wordDefinition) {
        WordDefinition = wordDefinition;
    }

    public boolean isUsed() {
        return Used;
    }

    public void setUsed(boolean used) {
        Used = used;
    }
}
