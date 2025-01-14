package com.semanticsquare.thrillio.util;

import java.io.*;
import java.util.List;

public class IOUtil {

    public static void read(List<String> data, String filename){

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename), "UTF-8"))){
            String line ;
            while ((line = br.readLine()) != null){
                data.add(line);
            }
        }catch (UnsupportedEncodingException e){
            e.printStackTrace();

        }catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String read(InputStream in) {
        StringBuilder text = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(in, "UTF-8"))){
            String line ;

            while ((line = br.readLine()) != null){
                text.append(line + "\n");
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return text.toString();
    }

    public static void write(String webpage, long id) {
        // Define the directory and file path
        String directoryPath = "/Users/zakihaidari/Documents/projects/thrillio/pages";
        String filePath = directoryPath + "/" + id + ".html";

        try {
            // Ensure the directory exists
            File directory = new File(directoryPath);
            if (!directory.exists()) {
                if (directory.mkdirs()) {
                    System.out.println("Directory created: " + directoryPath);
                } else {
                    System.err.println("Failed to create directory: " + directoryPath);
                    return;
                }
            }

            // Create a BufferedWriter to write the file
            try (BufferedWriter writer = new BufferedWriter(
                    new OutputStreamWriter(new FileOutputStream(filePath), "UTF-8"))) {
                writer.write(webpage); // Write content to the file
                System.out.println("File written successfully: " + filePath);
            }
        } catch (UnsupportedEncodingException e) {
            System.err.println("Encoding not supported: UTF-8");
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            System.err.println("File not found or unable to create file: " + filePath);
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("An I/O error occurred while writing the file.");
            e.printStackTrace();
        }
    }
}
