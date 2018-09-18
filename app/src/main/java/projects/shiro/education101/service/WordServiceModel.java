package projects.shiro.education101.service;

import java.util.List;

import projects.shiro.education101.models.ObscureWord;

public interface WordServiceModel {
    List<ObscureWord> getWordFromJsonFile();
    ObscureWord getWordFromNetWork();
    void SaveWord(ObscureWord word);
    void saveWords(List<ObscureWord> words);
}
