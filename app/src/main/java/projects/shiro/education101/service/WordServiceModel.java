package projects.shiro.education101.service;

import projects.shiro.education101.models.ObscureWord;

public interface WordServiceModel {
    ObscureWord getWordFromJsonFile();
    ObscureWord getWordFromNetWork();
    void SaveWord(ObscureWord word);
}
