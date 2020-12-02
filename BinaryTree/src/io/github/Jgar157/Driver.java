package io.github.Jgar157;
import java.io.File;
import java.io.IOException;

public class Driver {
    public static void main(String[] args) throws IOException {


        File file = new File("src/io/github/Jgar157/text");
        YesNoGame test = new YesNoGame(file.getAbsolutePath());

    }
}
