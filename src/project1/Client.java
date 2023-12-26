package project1;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Client {
    public static void main(String[] args){
       
        try{
       Socket s= new Socket("localhost",6000);
      
       DataInputStream din= new DataInputStream(s.getInputStream());
       DataOutputStream dout=new DataOutputStream(s.getOutputStream());
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      
       String str="",str2="";
      
       while(!str.equals("exit")){
       str=br.readLine();
       dout.writeUTF(str);
       dout.flush();
      
       str2=(String) din.readUTF();
       System.out.println("Server Says: "+str2);
       }
       dout.close();
       s.close();
       }catch(Exception e){System.out.println(e);};
    }
}
