package com.edu.exception.test2;
/*
    CompileException
    1. 컴파일 X : 컴파일러가 인식
    2. 반드시 명시적으로 예외처리해서 사용해야하는 일종의 문법구조
 */
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

class FileReading{
    public void readFile(String fileName) throws FileNotFoundException, IOException {
        FileReader reader = null;
        /*
         throws FileNotFoundException 해줬기 때문에 관련 try, catch 가 필요없다
         에러를 던지면, 이 코드를 호출한 곳에서 에러가 터짐
         */
//        try {
//            reader = new FileReader(fileName);
//            System.out.println("파일을 찾았습니다.");
//        } catch (FileNotFoundException e) {
//            System.out.println("파일을 찾을 수 없습니다");
//        }
        try{    // close 를 위해 사용됨
            reader = new FileReader(fileName);
            System.out.println("파일을 찾았습니다.");
        }
        finally {
//            try {
                reader.close();
//            } catch (Exception e) {
//
//            }
        }


    }
}

public class CompileExceptionTest2 {
    public static void main(String[] args) throws Exception{
        FileReading fr = new FileReading();

        fr.readFile("/Users/jeong-gil-yeon/Desktop/KB_study/KB_study/workshop_homework/java_01/java_r1_Workshop.pdf");
        fr.readFile("/Users/jeong-gil-yeon/Desktop/KB_study/KB_study/workshop_homework/java_01/java_r1_Workshop.pdfㄴㄴㄴ");


    }
}
