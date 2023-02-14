package sk.textprocessor.output;

import sk.textprocessor.arguments.ArgumentParser;
import sk.textprocessor.exceptions.InvalidInputFileException;
import sk.textprocessor.exceptions.InvalidOutputFileException;

import java.io.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileHandler {




    public void createNewFile(String fileName,String text) throws InvalidOutputFileException{
        String path = System.getProperty("user.home") + "/Desktop";
        String filename = fileName + ".txt";
        String fullPath = Paths.get(path, filename).toString();

        try{
            Files.createFile(Paths.get(fullPath));
            Files.write(Paths.get(fullPath), text.getBytes());
            System.out.println("Súbor bol úspešne vytvorený");
        }catch(IOException e){
            throw new InvalidOutputFileException("Chyba: súbor sa nepodarilo vytvoriť");
        }
    }

    //   function that overwrites the selected file
    public void changeFile(String rewrite,String path) throws InvalidOutputFileException {
            try {
                FileWriter fw = new FileWriter(path);
                fw.write(rewrite);
                fw.close();
                System.out.println("Súbor bol úspene prepísaný!");
            }
            catch (IOException e) {
                throw new InvalidOutputFileException("Chyba: subor nebol najdeny");
            }

    }





}







