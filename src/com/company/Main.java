package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        File dirOrigin = new File("C://Games/");
        String strToWriteFile = "";
        StringBuilder stringBuilder = new StringBuilder(strToWriteFile);

        List<String> dirNames = Arrays.asList("//src", "//res", "//savegames", "//temp", "//src//main", "//src//test",
                "//res//drawables","//res//vectors","//res//icons");
        List<String> filesNames = Arrays.asList("//src//main//Main.java", "//src//main//Utils.java", "//temp//temp.txt");

        for (String dir : dirNames) {
            File file = new File(dirOrigin + dir);
            if (file.mkdir()) stringBuilder.append("Папка " + file + " создана;" + '\n');
            else
                stringBuilder.append("Папка " + file + " не создана (либо нет прав, либо уже создана);" + '\n');
        }

        for (String f : filesNames) {
            File file = new File(dirOrigin + f);
            try {
                if (file.createNewFile()) stringBuilder.append("Файл " + file + " создан;" + '\n');
                else
                    stringBuilder.append("Файл " + file + " не создан (либо нет прав, либо уже создан);" + '\n');
            } catch (IOException e) {
                stringBuilder.append(e.getMessage() + '\n');
            }
        }

        try (FileWriter writer = new FileWriter(dirOrigin + "/temp/temp.txt", false)) {
            writer.write(stringBuilder.toString());
            writer.flush();
        } catch (IOException ex) {
            stringBuilder.append(ex.getMessage() + '\n');
        }
        System.out.println(stringBuilder);
    }
}
