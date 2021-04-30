import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.WindowConstants;

import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.*;
import java.io.FileReader;




public class main{
  public static void main(String[] args) {
    var Team = "";
    var Week = "0";
    try {
      File myObj = new File("playerteam.txt");
      if (myObj.createNewFile()) {
        System.out.println("File created: " + myObj.getName());
      } else {
        System.out.println("File already exists.");
      }
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }

    JFrame f = new JFrame("Game");
    f.setTitle("Hockey");
    f.setSize(500, 500);
    f.setLocation(300,300);
    f.getContentPane().setBackground(new java.awt.Color(0, 0, 0));
    final JLabel Title = new JLabel("Hockey");
    Title.setSize(300,300);
    Title.setBounds(213, 5, 120, 50);
    Title.setFont(new Font("Serif", Font.PLAIN, 24));
    Title.setForeground(new java.awt.Color(255,255,255));

    /* Team Selector */

    final JLabel teamsel = new JLabel("Select Team");
    teamsel.setSize(300,300);
    teamsel.setBounds(190, 5, 140, 50);
    teamsel.setFont(new Font("Serif", Font.PLAIN, 24));
    teamsel.setForeground(new java.awt.Color(255,255,255));

    final JButton Back2 = new JButton(" Back ");
    Dimension size5 = Back2.getPreferredSize();
    Back2.setBounds(210, 400, size5.width, size5.height);
    Back2.setBackground(new java.awt.Color(0,0,0));
    Back2.setForeground(new java.awt.Color(255,255,255));
    Back2.setSize(80,40);

    final JButton ArC = new JButton("    Coyotes    ");
    Dimension link = ArC.getPreferredSize();
    ArC.setBounds(15, 50, link.width, link.height);
    ArC.setBackground(new java.awt.Color(0,0,0));
    ArC.setForeground(new java.awt.Color(255,255,255));
    ArC.setSize(120,40);

    final JButton BoB = new JButton("Bruins");
    BoB.setBounds(130, 50, link.width, link.height);
    BoB.setBackground(new java.awt.Color(0,0,0));
    BoB.setForeground(new java.awt.Color(255,255,255));
    BoB.setSize(120,40);

    final JButton BuS = new JButton("Sabres");
    BuS.setBounds(245, 50, link.width, link.height);
    BuS.setBackground(new java.awt.Color(0,0,0));
    BuS.setForeground(new java.awt.Color(255,255,255));
    BuS.setSize(120,40);

    final JButton ClF = new JButton("Flames");
    ClF.setBounds(360, 50, link.width, link.height);
    ClF.setBackground(new java.awt.Color(0,0,0));
    ClF.setForeground(new java.awt.Color(255,255,255));
    ClF.setSize(120,40);

    final JButton CaH = new JButton("Hurricanes");
    CaH.setBounds(15, 84, link.width, link.height);
    CaH.setBackground(new java.awt.Color(0,0,0));
    CaH.setForeground(new java.awt.Color(255,255,255));
    CaH.setSize(120,40);

    final JButton CBh = new JButton("Blackhawks");
    CBh.setBounds(130, 84, link.width, link.height);
    CBh.setBackground(new java.awt.Color(0,0,0));
    CBh.setForeground(new java.awt.Color(255,255,255));
    CBh.setSize(120,40);

    final JButton CoA = new JButton("Avalanche");
    CoA.setBounds(245, 84, link.width, link.height);
    CoA.setBackground(new java.awt.Color(0,0,0));
    CoA.setForeground(new java.awt.Color(255,255,255));
    CoA.setSize(120, 40);

    final JButton CoB = new JButton("Blue Jackets");
    CoB.setBounds(360, 84, link.width, link.height);
    CoB.setBackground(new java.awt.Color(0,0,0));
    CoB.setForeground(new java.awt.Color(255,255,255));
    CoB.setSize(120,40);

    final JButton DaS = new JButton("Stars");
    DaS.setBounds(15, 118, link.width, link.height);
    DaS.setBackground(new java.awt.Color(0,0,0));
    DaS.setForeground(new java.awt.Color(255,255,255));
    DaS.setSize(120,40);

    final JButton DeR = new JButton("Red Wings");
    DeR.setBounds(130,118, link.width, link.height);
    DeR.setBackground(new java.awt.Color(0,0,0));
    DeR.setForeground(new java.awt.Color(255,255,255));
    DeR.setSize(120,40);

    final JButton EDO = new JButton("Oilers");
    EDO.setBounds(245, 118, link.width, link.height);
    EDO.setBackground(new java.awt.Color(0,0,0));
    EDO.setForeground(new java.awt.Color(255,255,255));
    EDO.setSize(120,40);

    final JButton FLP = new JButton("Panthers");
    FLP.setBounds(360, 118, link.width, link.height);
    FLP.setBackground(new java.awt.Color(0,0,0));
    FLP.setForeground(new java.awt.Color(255,255,255));
    FLP.setSize(120,40);

    final JButton LOA = new JButton("Kings");
    LOA.setBounds(15, 152, link.width, link.height);
    LOA.setBackground(new java.awt.Color(0,0,0));
    LOA.setForeground(new java.awt.Color(255,255,255));
    LOA.setSize(120,40);

    final JButton MIW = new JButton("Wild");
    MIW.setBounds(130, 152, link.width, link.height);
    MIW.setBackground(new java.awt.Color(0,0,0));
    MIW.setForeground(new java.awt.Color(255,255,255));
    MIW.setSize(120,40);

    final JButton MOC = new JButton("Canadiens");
    MOC.setBounds(245, 152, link.width, link.height);
    MOC.setBackground(new java.awt.Color(0,0,0));
    MOC.setForeground(new java.awt.Color(255,255,255));
    MOC.setSize(120,40);

    final JButton NAP = new JButton("Predators");
    NAP.setBounds(360, 152, link.width, link.height);
    NAP.setBackground(new java.awt.Color(0,0,0));
    NAP.setForeground(new java.awt.Color(255,255,255));
    NAP.setSize(120,40);

    final JButton NJD = new JButton("Jersey Devils");
    NJD.setBounds(15, 186, link.width, link.height);
    NJD.setBackground(new java.awt.Color(0,0,0));
    NJD.setForeground(new java.awt.Color(255,255,255));
    NJD.setSize(120,40);

    final JButton NYI = new JButton("Islanders");
    NYI.setBounds(130, 186, link.width, link.height);
    NYI.setBackground(new java.awt.Color(0,0,0));
    NYI.setForeground(new java.awt.Color(255,255,255));
    NYI.setSize(120,40);

    final JButton NYR = new JButton("Rangers");
    NYR.setBounds(245, 186, link.width, link.height);
    NYR.setBackground(new java.awt.Color(0,0,0));
    NYR.setForeground(new java.awt.Color(255,255,255));
    NYR.setSize(120,40);

    final JButton OTS = new JButton("Senators");
    OTS.setBounds(360,186, link.width, link.height);
    OTS.setBackground(new java.awt.Color(0,0,0));
    OTS.setForeground(new java.awt.Color(255,255,255));
    OTS.setSize(120,40);

    final JButton PHF = new JButton("Flyers");
    PHF.setBounds(15,220, link.width, link.height);
    PHF.setBackground(new java.awt.Color(0,0,0));
    PHF.setForeground(new java.awt.Color(255,255,255));
    PHF.setSize(120,40);

    final JButton PIP = new JButton("Penguins");
    PIP.setBounds(130, 220, link.width, link.height);
    PIP.setBackground(new java.awt.Color(0,0,0));
    PIP.setForeground(new java.awt.Color(255,255,255));
    PIP.setSize(120,40);

    final JButton SJS = new JButton("Sharks");
    SJS.setBounds(245, 220, link.width, link.height);
    SJS.setBackground(new java.awt.Color(0,0,0));
    SJS.setForeground(new java.awt.Color(255,255,255));
    SJS.setSize(120,40);

    final JButton SLB = new JButton("Blues");
    SLB.setBounds(360, 220, link.width, link.height);
    SLB.setBackground(new java.awt.Color(0,0,0));
    SLB.setForeground(new java.awt.Color(255,255,255));
    SLB.setSize(120,40);

    final JButton TBL = new JButton("Lightning");
    TBL.setBounds(15,254, link.width, link.height);
    TBL.setBackground(new java.awt.Color(0,0,0));
    TBL.setForeground(new java.awt.Color(255,255,255));
    TBL.setSize(120,40);

    final JButton TML = new JButton("Maple Leafs");
    TML.setBounds(130, 254, link.width, link.height);
    TML.setBackground(new java.awt.Color(0,0,0));
    TML.setForeground(new java.awt.Color(255,255,255));
    TML.setSize(120,40);

    final JButton VAC = new JButton("Canucks");
    VAC.setBounds(245, 254, link.width, link.height);
    VAC.setBackground(new java.awt.Color(0,0,0));
    VAC.setForeground(new java.awt.Color(255,255,255));
    VAC.setSize(120,40);

    final JButton VGK = new JButton("Golden Knights");
    VGK.setBounds(360, 254, link.width, link.height);
    VGK.setBackground(new java.awt.Color(0,0,0));
    VGK.setForeground(new java.awt.Color(255,255,255));
    VGK.setSize(120,40);

    final JButton WAC = new JButton("Capitals");
    WAC.setBounds(130,288, link.width, link.height);
    WAC.setBackground(new java.awt.Color(0,0,0));
    WAC.setForeground(new java.awt.Color(255,255,255));
    WAC.setSize(120,40);

    final JButton WIJ = new JButton("Jets");
    WIJ.setBounds(245, 288, link.width, link.height);
    WIJ.setBackground(new java.awt.Color(0,0,0));
    WIJ.setForeground(new java.awt.Color(255,255,255));
    WIJ.setSize(120,40);

    /* Below is credit labels */

    final JLabel cre1 = new JLabel("Made by");
    cre1.setSize(300,300);
    cre1.setBounds(213, 30, 120, 50);
    cre1.setFont(new Font("Serif", Font.PLAIN, 24));
    cre1.setForeground(new java.awt.Color(255,255,255));

    final JLabel cre2 = new JLabel("Jake Leroux");
    cre2.setSize(300,300);
    cre2.setBounds(195, 70, 120, 50);
    cre2.setFont(new Font("Serif", Font.PLAIN, 24));
    cre2.setForeground(new java.awt.Color(255,255,255));

    final JLabel cre3 = new JLabel("2021-2022(c)");
    cre3.setSize(300,300);
    cre3.setBounds(190, 120, 140, 50);
    cre3.setFont(new Font("Serif", Font.PLAIN, 24));
    cre3.setForeground(new java.awt.Color(255,255,255));

    final JButton Back1 = new JButton(" Back ");
    Dimension size4 = Back1.getPreferredSize();
    Back1.setBounds(210, 400, size4.width, size4.height);
    Back1.setBackground(new java.awt.Color(0,0,0));
    Back1.setForeground(new java.awt.Color(255,255,255));
    Back1.setSize(80,40);

    /* Start Menu */

    final JButton Start = new JButton("Start Game");
    Dimension size = Start.getPreferredSize();
    Start.setBounds(210, 50, size.width, size.height);
    Start.setBackground(new java.awt.Color(0,0,0));
    Start.setForeground(new java.awt.Color(255,255,255));
    Start.setSize(80,40);

    final JButton Options = new JButton(" Credits ");
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

     /* Team info */
    final JLabel team = new JLabel(Team);
    team.setSize(300,300);
    team.setBounds(203,5,link.width,link.height);
    team.setFont(new Font("Serif", Font.PLAIN, 24));
    team.setForeground(new java.awt.Color(255,255,255));


    /* Actions */

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
        teamsel.setVisible(true);
        Back2.setVisible(true);
        ArC.setVisible(true);
        BoB.setVisible(true);
        BuS.setVisible(true);
        ClF.setVisible(true);
        CaH.setVisible(true);
        CBh.setVisible(true);
        CoA.setVisible(true);
        CoB.setVisible(true);
        DaS.setVisible(true);
        DeR.setVisible(true);
        EDO.setVisible(true);
        FLP.setVisible(true);
        LOA.setVisible(true);
        MIW.setVisible(true);
        MOC.setVisible(true);
        NAP.setVisible(true);
        NJD.setVisible(true);
        NYI.setVisible(true);
        NYR.setVisible(true);
        OTS.setVisible(true);
        PHF.setVisible(true);
        PIP.setVisible(true);
        SJS.setVisible(true);
        SLB.setVisible(true);
        TBL.setVisible(true);
        TML.setVisible(true);
        VAC.setVisible(true);
        VGK.setVisible(true);
        WAC.setVisible(true);
        WIJ.setVisible(true);
      }
    });

    Back1.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        Start.setVisible(true);
        Title.setVisible(true);
        Quit.setVisible(true);
        Options.setVisible(true);
        Back1.setVisible(false);
        cre1.setVisible(false);
        cre2.setVisible(false);
        cre3.setVisible(false);
      }
    });

    Options.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        Start.setVisible(false);
        Title.setVisible(false);
        Quit.setVisible(false);
        Options.setVisible(false);
        Back1.setVisible(true);
        cre1.setVisible(true);
        cre2.setVisible(true);
        cre3.setVisible(true);
      }
    });

    Back2.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        Start.setVisible(true);
        Title.setVisible(true);
        Quit.setVisible(true);
        Options.setVisible(true);
        Back2.setVisible(false);
        teamsel.setVisible(false);
        ArC.setVisible(false);
        BoB.setVisible(false);
        BuS.setVisible(false);
        ClF.setVisible(false);
        CaH.setVisible(false);
        CBh.setVisible(false);
        CoA.setVisible(false);
        CoB.setVisible(false);
        DaS.setVisible(false);
        DeR.setVisible(false);
        EDO.setVisible(false);
        FLP.setVisible(false);
        LOA.setVisible(false);
        MIW.setVisible(false);
        MOC.setVisible(false);
        NAP.setVisible(false);
        NJD.setVisible(false);
        NYI.setVisible(false);
        NYR.setVisible(false);
        OTS.setVisible(false);
        PHF.setVisible(false);
        PIP.setVisible(false);
        SJS.setVisible(false);
        SLB.setVisible(false);
        TBL.setVisible(false);
        TML.setVisible(false);
        VAC.setVisible(false);
        VGK.setVisible(false);
        WAC.setVisible(false);
        WIJ.setVisible(false);
      }
    });



    ArC.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        Back2.setVisible(false);
        teamsel.setVisible(false);
        f.getContentPane().removeAll();
        f.repaint();
        var Team = "Coyotes";
        f.add(team);
        team.setText(Team);
        team.setVisible(true);
        try {
          FileWriter myWriter = new FileWriter("playerteam.txt");
          myWriter.write("Arizona Coyotes");
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException l) {
          System.out.println("An error occurred.");
          l.printStackTrace();
        } catch(Throwable ex){
          System.out.println("An error occurred.");
          ex.printStackTrace();
        }
        try{
          ProcessBuilder builder = new ProcessBuilder("go", "run", "teamorganizer.go");
          builder.redirectErrorStream(true);
          Process p = builder.start();
          BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
          String line;
          while (true){
            line = r.readLine();
            if (line == null){ break ; }
            System.out.println(line);
            }
          }catch(IOException t){
            System.out.println("An error occurred.");
            t.printStackTrace();
          }
      }
    });

    BoB.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        Back2.setVisible(false);
        teamsel.setVisible(false);
        f.getContentPane().removeAll();
        f.repaint();
        var Team = "Bruins";
        f.add(team);
        team.setText(Team);
        team.setVisible(true);
        try {
          FileWriter myWriter = new FileWriter("playerteam.txt");
          myWriter.write("Boston Bruins");
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException l) {
          System.out.println("An error occurred.");
          l.printStackTrace();
        } catch(Throwable ex){
          System.out.println("An error occurred.");
          ex.printStackTrace();
        }
        try{
          ProcessBuilder builder = new ProcessBuilder("go", "run", "teamorganizer.go");
          builder.redirectErrorStream(true);
          Process p = builder.start();
          BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
          String line;
          while (true){
            line = r.readLine();
            if (line == null){ break ; }
            System.out.println(line);
            }
          }catch(IOException t){
            System.out.println("An error occurred.");
            t.printStackTrace();
          }
      }
    });

    BuS.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        Back2.setVisible(false);
        teamsel.setVisible(false);
        f.getContentPane().removeAll();
        f.repaint();
        var Team = "Sabres";
        f.add(team);
        team.setText(Team);
        team.setVisible(true);
        try {
          FileWriter myWriter = new FileWriter("playerteam.txt");
          myWriter.write("Buffalo Sabres");
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException l) {
          System.out.println("An error occurred.");
          l.printStackTrace();
        } catch(Throwable ex){
          System.out.println("An error occurred.");
          ex.printStackTrace();
        }
        try{
          ProcessBuilder builder = new ProcessBuilder("go", "run", "teamorganizer.go");
          builder.redirectErrorStream(true);
          Process p = builder.start();
          BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
          String line;
          while (true){
            line = r.readLine();
            if (line == null){ break ; }
            System.out.println(line);
            }
          }catch(IOException t){
            System.out.println("An error occurred.");
            t.printStackTrace();
          }
      }
    });

    ClF.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        Back2.setVisible(false);
        teamsel.setVisible(false);
        f.getContentPane().removeAll();
        f.repaint();
        var Team = "Flames";
        f.add(team);
        team.setText(Team);
        team.setVisible(true);
        try {
          FileWriter myWriter = new FileWriter("playerteam.txt");
          myWriter.write("Calgary Flames");
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException l) {
          System.out.println("An error occurred.");
          l.printStackTrace();
        } catch(Throwable ex){
          System.out.println("An error occurred.");
          ex.printStackTrace();
        }
        try{
          ProcessBuilder builder = new ProcessBuilder("go", "run", "teamorganizer.go");
          builder.redirectErrorStream(true);
          Process p = builder.start();
          BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
          String line;
          while (true){
            line = r.readLine();
            if (line == null){ break ; }
            System.out.println(line);
            }
          }catch(IOException t){
            System.out.println("An error occurred.");
            t.printStackTrace();
          }
      }
    });

    CaH.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        Back2.setVisible(false);
        teamsel.setVisible(false);
        f.getContentPane().removeAll();
        f.repaint();
        var Team = "Hurricanes";
        f.add(team);
        team.setText(Team);
        team.setVisible(true);
        try {
          FileWriter myWriter = new FileWriter("playerteam.txt");
          myWriter.write("Carloina Hurricanes");
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException l) {
          System.out.println("An error occurred.");
          l.printStackTrace();
        } catch(Throwable ex){
          System.out.println("An error occurred.");
          ex.printStackTrace();
        }
        try{
          ProcessBuilder builder = new ProcessBuilder("go", "run", "teamorganizer.go");
          builder.redirectErrorStream(true);
          Process p = builder.start();
          BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
          String line;
          while (true){
            line = r.readLine();
            if (line == null){ break ; }
            System.out.println(line);
            }
          }catch(IOException t){
            System.out.println("An error occurred.");
            t.printStackTrace();
          }
      }
    });

    CBh.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        Back2.setVisible(false);
        teamsel.setVisible(false);
        f.getContentPane().removeAll();
        f.repaint();
        var Team = "Blackhawks";
        f.add(team);
        team.setText(Team);
        team.setVisible(true);
        try {
          FileWriter myWriter = new FileWriter("playerteam.txt");
          myWriter.write("Chicago Blackhawks");
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException l) {
          System.out.println("An error occurred.");
          l.printStackTrace();
        } catch(Throwable ex){
          System.out.println("An error occurred.");
          ex.printStackTrace();
        }
        try{
          ProcessBuilder builder = new ProcessBuilder("go", "run", "teamorganizer.go");
          builder.redirectErrorStream(true);
          Process p = builder.start();
          BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
          String line;
          while (true){
            line = r.readLine();
            if (line == null){ break ; }
            System.out.println(line);
            }
          }catch(IOException t){
            System.out.println("An error occurred.");
            t.printStackTrace();
          }
      }
    });

    CoA.addActionListener(new ActionListener(){
      @Override
      public void actionPerformed(ActionEvent e){
        Back2.setVisible(false);
        teamsel.setVisible(false);
        f.getContentPane().removeAll();
        f.repaint();
        var Team = "Avalanche";
        f.add(team);
        team.setText(Team);
        team.setVisible(true);
        try {
          FileWriter myWriter = new FileWriter("playerteam.txt");
          myWriter.write("Colorado Avalanche");
          myWriter.close();
          System.out.println("Successfully wrote to the file.");
        } catch (IOException l) {
          System.out.println("An error occurred.");
          l.printStackTrace();
        } catch(Throwable ex){
          System.out.println("An error occurred.");
          ex.printStackTrace();
        }
        try{
          ProcessBuilder builder = new ProcessBuilder("go", "run", "teamorganizer.go");
          builder.redirectErrorStream(true);
          Process p = builder.start();
          BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
          String line;
          while (true){
            line = r.readLine();
            if (line == null){ break ; }
            System.out.println(line);
            }
          }catch(IOException t){
            System.out.println("An error occurred.");
            t.printStackTrace();
          }
      }
    });

    f.setLayout(null);
    f.add(Start);
    f.add(Title);
    f.add(Options);
    f.add(Quit);
    f.add(Back1);
    f.add(cre1);
    f.add(cre2);
    f.add(cre3);
    f.add(teamsel);
    f.add(Back2);
    /* Teams */
    f.add(ArC);
    f.add(BoB);
    f.add(BuS);
    f.add(ClF);
    f.add(CaH);
    f.add(CBh);
    f.add(CoA);
    f.add(CoB);
    f.add(DaS);
    f.add(DeR);
    f.add(EDO);
    f.add(FLP);
    f.add(LOA);
    f.add(MIW);
    f.add(MOC);
    f.add(NAP);
    f.add(NJD);
    f.add(NYI);
    f.add(NYR);
    f.add(OTS);
    f.add(PHF);
    f.add(PIP);
    f.add(SJS);
    f.add(SLB);
    f.add(TBL);
    f.add(TML);
    f.add(VAC);
    f.add(VGK);
    f.add(WAC);
    f.add(WIJ);

    Back1.setVisible(false);
    cre1.setVisible(false);
    cre2.setVisible(false);
    cre3.setVisible(false);
    Back2.setVisible(false);
    teamsel.setVisible(false);

    ArC.setVisible(false);
    BoB.setVisible(false);
    BuS.setVisible(false);
    ClF.setVisible(false);
    CaH.setVisible(false);
    CBh.setVisible(false);
    CoA.setVisible(false);
    CoB.setVisible(false);
    DaS.setVisible(false);
    DeR.setVisible(false);
    EDO.setVisible(false);
    FLP.setVisible(false);
    LOA.setVisible(false);
    MIW.setVisible(false);
    MOC.setVisible(false);
    NAP.setVisible(false);
    NJD.setVisible(false);
    NYI.setVisible(false);
    NYR.setVisible(false);
    OTS.setVisible(false);
    PHF.setVisible(false);
    PIP.setVisible(false);
    SJS.setVisible(false);
    SLB.setVisible(false);
    TBL.setVisible(false);
    TML.setVisible(false);
    VAC.setVisible(false);
    VGK.setVisible(false);
    WAC.setVisible(false);
    WIJ.setVisible(false);
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
            textArea.append("Button was clicked\n");
            System.out.println("Button was clicked");

        }
    });

    String line;
    try (BufferedReader br = new BufferedReader(new FileReader("file.txt"))) {
        for (int i = 0; i < n; i++)
            br.readLine();
        line = br.readLine();
    }
    */

    