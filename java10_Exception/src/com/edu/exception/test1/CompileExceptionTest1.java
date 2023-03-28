package com.edu.exception.test1;
/*
    CompileException
    1. 컴파일 X : 컴파일러가 인식
    2. 반드시 명시적으로 예외처리해서 사용해야하는 일종의 문법구조
 */
import java.io.FileNotFoundException;
import java.io.FileReader;

class FileReading{
    public void readFile(String fileName) {
//        FileReader reader = new FileReader(fileName);   컴파일 Exception (Unhandled exception) : 원래는 비정상 종료. 컴파일자체가 안됨
        try {
            FileReader reader = new FileReader(fileName);
            System.out.println("파일을 찾았습니다.");
        } catch (FileNotFoundException e) {
            System.out.println("파일을 찾을 수 없습니다");
        }

    }
}
public class CompileExceptionTest1 {
    public static void main(String[] args) {
        FileReading fr = new FileReading();
        fr.readFile("/Users/jeong-gil-yeon/Desktop/KB_study/KB_study/workshop_homework/java_01/java_r1_Workshop.pdf");
        fr.readFile("/Users/jeong-gil-yeon/Desktop/KB_study/KB_study/workshop_homework/java_01/java_r1_Workshop.pdfㄴㄴㄴ");
    }
}
