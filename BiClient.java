//Input OutPut Class for Bufferedreader&PrintWriter Classes

/*
@author:shamil-t
*/
import java.io.*;
//Network Class for Socket
import java.net.*;

class BiClient 
{
    public static void main(String a[]) throws Exception
    {
        //For Connecting to Port
        //Server:- Localhost
        //Port number:-9000 
        Socket s = new Socket("localhost",9000);
        System.out.println("Server Connected");

        //Read Message From KeyBoard
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Read Message from Server
        BufferedReader ir = new BufferedReader(new InputStreamReader(s.getInputStream()));        

        //Sending Data to the Server
        PrintWriter pr = new PrintWriter(s.getOutputStream(),true);

        //while loop for sending and reading messages
        while (true) {
            System.out.println("Enter the message");
            String str = br.readLine();//read the message
            //send message
            pr.println(str);
            if(str.equals("bye"))
            {
                break;
            }
            //read message from Server
            String msg = ir.readLine();
            System.out.println("Server :-"+msg);
            if(msg.equals("bye"))
            {
                break;
            }
        }
        //Closing The Connection
        System.out.println("Clossing Connection");
        s.close();
    }
} 