import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class demo02 extends JFrame {
    private PrintWriter printWriter;
    Socket socket;
    private JTextField JTexField=new JTextField();
    private JTextArea JTextArea=new JTextArea();
    Container container;
    public demo02(String title){
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        container=this.getContentPane();
        final JScrollPane JScrollPane=new JScrollPane();
        JScrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(JScrollPane,BorderLayout.CENTER);
        JScrollPane.setViewportView(JTextArea);
        container.add(JTexField,"South");
        JTexField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printWriter.println(JTexField.getText());
                JTextArea.append(JTexField.getText()+"\n");
                JTextArea.setSelectionEnd(JTextArea.getText().length());
                JTexField.setText(null);
            }
        });
    }
    private void connect(){
        JTextArea.append("尝试连接中\n");
        try{
            socket=new Socket("127.0.0.1",8998);
            printWriter=new PrintWriter(socket.getOutputStream(),true);
            JTextArea.setText("已完成连接\n");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        demo02 demo02 = new demo02("向服务器发送数据");
        demo02.setSize(500,200);
        demo02.setVisible(true);
        demo02.connect();
    }

}
