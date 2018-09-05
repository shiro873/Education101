package projects.shiro.education101.models;

import android.arch.persistence.room.Entity;

@Entity
public class ObscureWord {
    private int Id;
    private String Word;
    private String WordDefinition;
    private boolean IsUsed;

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
        return IsUsed;
    }

    public void setUsed(boolean used) {
        IsUsed = used;
    }
}
