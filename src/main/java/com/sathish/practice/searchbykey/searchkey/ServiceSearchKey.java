package com.sathish.practice.searchbykey.searchkey;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class ServiceSearchKey {
    public List<String> findListOfFilesInaDirectory(String directoryPath) {
        try (Stream<Path> walk = Files.walk(Paths.get(directoryPath))) {
            List<String> result = walk.map(x -> x.toString())
                    .collect(Collectors.toList());
            return result;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public String searchKeyInFile(String filePath, String searchKey) {
        List<String> list = new ArrayList<>();
        try{
            int i;
            char c;
            InputStream inputStream = new FileInputStream(filePath);
            StringBuilder br = new StringBuilder();
            while((i = inputStream.read())!=-1) {
                c = (char)i;
                br.append(c);
            }
            int index = br.indexOf(searchKey);
            if(index > -1) {
                return filePath;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        ServiceSearchKey test = new ServiceSearchKey();
        String startDir = ("E:\\Technical\\searchbykey");
        List<String> listOfFiles = test.findListOfFilesInaDirectory(startDir);
        List<String> filteredList = new ArrayList<>();
        listOfFiles.forEach((filePath) -> {
            filteredList.add(test.searchKeyInFile(filePath, "contains"));
        });
        filteredList.stream().filter(f -> f != null).collect(Collectors.toList());
        filteredList.forEach(System.out::println);
     }
}
