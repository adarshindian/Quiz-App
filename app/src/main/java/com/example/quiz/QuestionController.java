package com.example.quiz;
import java.util.*;


public class QuestionController {
    ArrayList getQuestion(){
    ArrayList<QuestionModel> arrli
            = new ArrayList<QuestionModel>(3);
    QuestionModel q1=new QuestionModel(1,
            "What is JDBC",
            "Jquery Database Connectivity",
            "Java Database Connectivity",
            "None of them",
            "Both can be particular Scenario",
            2);
    arrli.add(q1);
    QuestionModel q2=new QuestionModel(1,
            "Fullform of OS",
            "Order of Significance",
            "Open Software",
            "Operating System",
            "Optical Sensor",
            3);
        arrli.add(q2);
    QuestionModel q3=new QuestionModel(1,
            "Which among them is JS Library",
            "Django",
            "Laravell",
            "Kotlin",
            "Non of them",4);
        arrli.add(q3);
        QuestionModel q4=new QuestionModel(1,
                "Full form of CPU",
                "Central Processing Unit",
                "Central Programming Unit",
                "Common Procesing Unit",
                "Non of them",1);
        arrli.add(q4);
    return arrli;
};
}
