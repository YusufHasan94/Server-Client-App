package project1;

import java.net.*;
import java.io.*;

public class Server {

        public static void main(String[] args){
       
        try{
       ServerSocket ss= new ServerSocket(6000);
       System.out.println("waiting for client....");
       Socket s= ss.accept();
      
       DataInputStream din= new DataInputStream(s.getInputStream());
       DataOutputStream dout=new DataOutputStream(s.getOutputStream());
       BufferedReader br= new BufferedReader(new InputStreamReader(System.in));
      
       String str="",str2="";
      
       while(!str.equals("exit")){
       str=(String) din.readUTF();
       System.out.println("Client Says: "+str);
      
       str2=br.readLine();
       dout.writeUTF(str2);
       dout.flush();
      
       }
      
       //din.close();
       ss.close();
       }catch(Exception e){System.out.println(e);};
    }
}
