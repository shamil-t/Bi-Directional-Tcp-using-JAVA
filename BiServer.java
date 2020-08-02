//Input OutPut Class for Bufferedreader&PrintWriter Classes
/*
@author:shamil-t
*/
import java.io.*;
//Network Class for Socket&ServerSocket
import java.net.*;

class BiServer
{
    public static void main(String a[]) throws Exception
    {
        //Establishing Connection
        ServerSocket ss = new ServerSocket(9000);
        System.out.println("Waiting for Client");
        Socket s = ss.accept();
        System.out.println("Client Connected");

        //For Reading Message from Client
        BufferedReader br = new BufferedReader(new InputStreamReader(s.getInputStream()));          
        //For Reading Message from Keyboard
        BufferedReader ir = new BufferedReader(new InputStreamReader(System.in));
        //Sending Data to the Client
        PrintWriter pr = new PrintWriter(s.getOutputStream(),true);

        //while loop for sending and reading messages
        while (true) {
            //read message from Client
            String msg = br.readLine();
            System.out.println("Client :-"+msg);
            if(msg.equals("bye"))
            {
                break;
            }
            System.out.println("Enter the message");
            String str = ir.readLine();//read the message
            //send message
            pr.println(str);
            if(str.equals("bye"))
            {
                break;
            }
        }
        //Closing The Connection
        System.out.println("Clossing Connection");
        s.close();
    }
}