package com.example.lizah.imageserviceapp;

import android.util.Log;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.Socket;

public class TcpClient {
    public static void main(String argv[]) throws Exception {
        try {
            //here you must put your computer's IP address.
            InetAddress serverAddr = InetAddress.getByName("10.0.0.2");
            //create a socket to make the connection with the server
            Socket socket = new Socket(serverAddr, 1234);
            try {
                OutputStream output = socket.getOutputStream();
                //FileInputStream fis = new FileInputStream(pic);

                output.write(extractBytes("C:\\Users\\lizah\\OneDrive\\תמונות\\Saved Pictures\\אילנה.jpg"));
                output.flush();
            } catch (Exception e) {
                Log.e("TCP", "S: Error", e);
            } finally {
                socket.close();

            }
        }catch (Exception e){
            Log.e("TCP", "C: Error", e);
        }
    }

    public static byte[] extractBytes (String imageName) throws IOException {
        // open image
        File file = new File(imageName);
        System.out.println(file.exists() + "!!");
        FileInputStream fis = new FileInputStream(file);
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        byte[] buf = new byte[1024];
        try {
            for (int readNum; (readNum = fis.read(buf)) != -1;) {
                bos.write(buf, 0, readNum);
                //no doubt here is 0
                /*Writes len bytes from the specified byte array starting at offset
                off to this byte array output stream.*/
                System.out.println("read " + readNum + " bytes,");
            }
        } catch (IOException ex) {
           // Logger.getLogger(ConvertImage.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bos.toByteArray();
    }




/*
        String sentence;
        String modifiedSentence;
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
        Socket clientSocket = new Socket("localhost", 6789);
        DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
        BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
        sentence = inFromUser.readLine();
        outToServer.writeBytes(sentence + '\n');
        modifiedSentence = inFromServer.readLine();
        System.out.println("FROM SERVER: " + modifiedSentence);
        clientSocket.close();*/

}
