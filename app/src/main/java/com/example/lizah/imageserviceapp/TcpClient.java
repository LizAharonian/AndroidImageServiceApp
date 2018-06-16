package com.example.lizah.imageserviceapp;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.List;

import static java.lang.Thread.sleep;

public class TcpClient {

    List<File> picsFilesList;
    File file;
    public  TcpClient(File myFile){
        file = myFile;
    }

    public void startCommunication() throws Exception {


        try {
            //here you must put your computer's IP address.
            InetAddress serverAddr = InetAddress.getByName("10.0.2.2");

            try {


                    //create a socket to make the connection with the server
                Socket socket = new Socket(serverAddr, 7999);
                OutputStream output = socket.getOutputStream();
                InputStream input = socket.getInputStream();

                    //write image name to server
                    String name = file.getName();
                    output.write(file.getName().getBytes());
                    //confirm from server he got the name
                    byte[] confirmation = new byte[1];
                    int result = input.read(confirmation);
                    sleep(600);
                    if (result == 1) {
                        output.write(extractBytes(file));
                    }
                    output.flush();
            } catch (Exception e) {
                Log.e("TCP", "S: Error", e);
            } finally {
               //socket.close();
            }
        }catch (Exception e){
            Log.e("TCP", "C: Error", e);
        }
    }

    public static byte[] extractBytes (File file) throws IOException {


        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        FileInputStream fis = new FileInputStream(file);
        try {
            int i;
            while ((i=fis.read(buffer))!=-1) {
                stream.write(buffer, 0, i);
            }

        } catch (IOException ex) {
        }
        return stream.toByteArray();

    }

}
