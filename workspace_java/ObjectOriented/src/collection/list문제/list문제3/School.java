package collection.list문제.list문제3;

import java.util.ArrayList;
import java.util.List;

public class School {
    StudyClass stc = new StudyClass();
    List<StudyClass> studyClasses = new ArrayList<>();

    public void classAll(List<StudyClass> studyClasses, String tName){
        for (int i = 0; i < studyClasses.size(); i++){
            if (studyClasses.get(i).getTname().equals(tName)){
                System.out.println(studyClasses.get(i).toString());
            }
        }
    }




}
