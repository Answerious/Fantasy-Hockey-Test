import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;

import java.awt.Dimension;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

public class main{

  public static void main(String[] args) {
    JFrame f = new JFrame("Menu");
    f.setTitle("Hockey");
    f.setSize(500, 500);
    f.setLocation(300,300);
    f.getContentPane().setBackground(new java.awt.Color(0, 0, 0));
    final JLabel Title = new JLabel("Hockey");
    //Dimension size1 = Title.getPreferredSize();
    Title.setSize(300,300);
    Title.setBounds(213, 5, 120, 50);
    Title.setFont(new Font("Serif", Font.PLAIN, 24));
    Title.setForeground(new java.awt.Color(255,255,255));
    final JButton Start = new JButton("Start Game");
    Dimension size = Start.getPreferredSize();
    Start.setBounds(210, 50, size.width, size.height);
    Start.setBackground(new java.awt.Color(0,0,0));
    Start.setForeground(new java.awt.Color(255,255,255));
    Start.setSize(80,40);

    final JButton Options = new JButton(" Options ");
    Dimension size2 = Options.getPreferredSize();
    Options.setBounds(210, 120, size2.width, size2.height);
    Options.setBackground(new java.awt.Color(0,0,0));
    Options.setForeground(new java.awt.Color(255,255,255));
    Options.setSize(80,40);

    final JButton Quit = new JButton(" Quit ");
    Dimension size3 = Quit.getPreferredSize();
    Quit.setBounds(210, 190, size3.width, size3.height);
    Quit.setBackground(new java.awt.Color(0,0,0));
    Quit.setForeground(new java.awt.Color(255,255,255));
    Quit.setSize(80,40);

    Quit.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        System.exit(0);
      }
    });

    Start.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        Start.setVisible(false);
        Title.setVisible(false);
        Quit.setVisible(false);
        Options.setVisible(false);
        System.out.println("SUCCESS");
        System.exit(0);
      }
    });

    Options.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        System.out.println("Button was clicked");
      }
    });

    f.setLayout(null);
    f.add(Start);
    f.add(Title);
    f.add(Options);
    f.add(Quit);

    f.setVisible(true);
  }

}

    /*
    final JTextArea textArea = new JTextArea(10, 40);
    f.getContentPane().add(BorderLayout.CENTER, textArea);
    
    final JButton button = new JButton("Click Me");
    f.getContentPane().add(BorderLayout.SOUTH, button);
    button.addActionListener(new ActionListener() {

        @Override
        public void actionPerformed(ActionEvent e) {
            //textArea.append("Button was clicked\n");
            System.out.println("Button was clicked");

        }
    });
    */