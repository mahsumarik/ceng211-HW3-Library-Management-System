package CENG211_Homeworks.G17_CENG211_HW3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class FileIO {

    private String line;
    private String file;

    public ArrayList<Items> getItems(){
        file="items.csv";
        ArrayList<Items> itemsArrayList= new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        try(BufferedReader bufferedReader = new BufferedReader(new FileReader(file))){
            String[] lineToSplit;
            while ((line=bufferedReader.readLine()) !=null){
                lineToSplit=line.trim().split(";");
                String itemNumber=lineToSplit[0];
                String title= lineToSplit[1];
                String priority=lineToSplit[2];
                String itemType=lineToSplit[3];
                String customerType=lineToSplit[6];
                LocalDate startBorrow=LocalDate.parse(lineToSplit[7],formatter);
                LocalDate endBorrow=LocalDate.parse(lineToSplit[8],formatter);
                itemsArrayList.add(new Items(itemNumber,title,priority,itemType,customerType,startBorrow,endBorrow));
            }

        }catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return itemsArrayList;
    }

}
