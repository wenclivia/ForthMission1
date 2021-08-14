import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class demo01 {
    private BufferedReader reader;
    private ServerSocket serverSocket;
    private Socket socket;
    void getserver(){
        try{
            ServerSocket serverSocket= new ServerSocket(8998);
            System.out.println("服务器套接字已经创建成功");
            while (true){
                System.out.println("等待服务器连接：");
                socket=serverSocket.accept();
                reader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                getClientMessage();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void getClientMessage(){
        try{
            while(true){
                System.out.println("客户机传来的信息是："+reader.readLine());

            }
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        demo01 demo01 = new demo01();
        demo01.getserver();

    }
}
