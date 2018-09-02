package projects.shiro.education101.fragments.Words;

import java.util.List;

import projects.shiro.education101.models.ObscureWord;

public interface WordsModel {
    ObscureWord getTodaysWord();
    void saveWords();
    List<ObscureWord> getWords();

}
