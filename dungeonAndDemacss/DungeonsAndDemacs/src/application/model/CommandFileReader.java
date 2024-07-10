package application.model;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;

public class CommandFileReader {
    private final String path = "../resources/configuration.txt";
    public int[] read() throws IOException {
        int[] command = new int[9];
        BufferedReader in = null;
        try {
            in = new BufferedReader(new FileReader(String.valueOf(getClass().getResource(path))));
            for (int i=0; i<command.length; i++){
                command[i]= Integer.parseInt(in.readLine());
            }
        } finally {
            if(in != null)
                in.close();
        }
        System.out.println(Arrays.toString(command));
        return command;
    }
    public void write(int[] command) throws IOException {
        BufferedWriter out = null;
        try {
            out = new BufferedWriter(new FileWriter(path));
            out.write(String.valueOf(command[0]));
            for(int i=1; i<command.length; i++){
                out.newLine();
                out.write(String.valueOf(command[i]));
            }

        } finally {
            if(out != null)
                out.close();
        }
    }


    /*public void read(int[] command) throws IOException {
        try (DataInputStream dis = new DataInputStream(new FileInputStream("src/application/resources/CommandKey.dat"))) {
            for(int i=0; i<command.length; i++){
                command[i] = dis.readInt();
            }
        } catch (IOException e) {
            // aggiungere un codice d'eccezione
            e.printStackTrace();
        }
    }
    public void write(int[] command) throws IOException {
        try (DataOutputStream dos = new DataOutputStream(new FileOutputStream("src/application/resources/CommandKey.dat"))) {
            for (int n:command){
                dos.writeInt(n);
            }
        } catch (IOException e) {
            // aggiungere un codice d'eccezione
            e.printStackTrace();
        }
    }
    public void writeByte(int[] command) throws IOException {
        StringBuilder text = new StringBuilder();
        for (int n:command){
            text.append(String.valueOf(n)).append(System.lineSeparator());
        }
        Files.write(Path.of(path), text.toString().getBytes());
    }

    private byte[] readByte() throws IOException {
        return Files.readAllBytes(Path.of(path));
    }

    public int[] getCommand() throws IOException {
        int[] command = new int[9];
        int i = 0;
        System.out.println(Arrays.toString(readByte()));
        for(byte b: readByte()){
            command[i]=(int) b;
            i++;
        }
        return command;
    }*/
}
