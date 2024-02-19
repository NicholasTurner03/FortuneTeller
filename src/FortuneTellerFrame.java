import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.util.Random;
public class FortuneTellerFrame extends JFrame {
    ImageIcon icon;
    JPanel mainPnl, titlePnl, displayPnl, cmdPnl;
    JButton quitBtn, fortuneBtn;
    JLabel titleLbl;
    JScrollPane scroller;
    JTextArea fortuneTA;
    String fortunes[]=new String[15];
    int curFortuneDex = -1;
    public FortuneTellerFrame() {
        loadFortunes();
        mainPnl=new JPanel();
        mainPnl.setLayout(new BorderLayout());
        add(mainPnl);
        createTitlePanel();
        createDisplayPanel();
        createControlPanel();
        setTitle("Fortune Teller");
        setSize(550, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    private void loadFortunes(){
        fortunes[0]= "1";
        fortunes[1]= "2";
        fortunes[2]= "3";
        fortunes[3]= "4";
        fortunes[4]= "5";
        fortunes[5]= "6";
        fortunes[6]= "7";
        fortunes[7]= "8";
        fortunes[8]= "9";
        fortunes[9]= "10";
        fortunes[10]= "11";
        fortunes[11]= "12";
        fortunes[12]= "13";
        fortunes[13]= "14";
        fortunes[14]= "15";
    }
    public void createTitlePanel(){
        titlePnl = new JPanel();
        icon = new ImageIcon("src/FortuneTeller.jpg");
        titleLbl= new JLabel(icon);
        titleLbl.setText("Get your Fortune!");
        titleLbl.setHorizontalTextPosition(JLabel.CENTER);
        titleLbl.setVerticalTextPosition(JLabel.BOTTOM);
        titlePnl.add(titleLbl);
        mainPnl.add(titlePnl, BorderLayout.NORTH);
    }
    public void createDisplayPanel() {
        displayPnl = new JPanel();
        fortuneTA = new JTextArea(15,50);
        scroller= new JScrollPane(fortuneTA);
        displayPnl.add(scroller);
        mainPnl.add( displayPnl, BorderLayout.CENTER);
    }
    public void createControlPanel(){
        Random rnd= new Random();
        cmdPnl= new JPanel();
        cmdPnl.setLayout(new GridLayout(1,2));
        fortuneBtn= new JButton("Get a Fortune!");
        quitBtn = new JButton("Quit");
        quitBtn.addActionListener((ActionEvent ae) -> System.exit(0));
        fortuneBtn.addActionListener((ActionEvent ae) -> {
            int newDex=curFortuneDex;
            do{
                newDex=rnd.nextInt(fortunes.length);

            }while(newDex==curFortuneDex);
            curFortuneDex= newDex;
            fortuneTA.append(fortunes[newDex]+ "\n");
        });
        cmdPnl.add(fortuneBtn);
        cmdPnl.add(quitBtn);
        mainPnl.add(cmdPnl,BorderLayout.SOUTH);
    }
}