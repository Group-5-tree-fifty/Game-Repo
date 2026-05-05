import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SecondScreen {

    public SecondScreen() {

        JFrame frame = new JFrame("Click Click Boo - Download Page");
        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());

        // TITLE
        JLabel title = new JLabel("Click Click Boo!");
        title.setForeground(Color.RED);
        title.setFont(new Font("Arial", Font.BOLD, 24));

        // WARNING TEXT
        JTextArea warning = new JTextArea(
                "WARNING:\n" +
                "This game contains jumpscares, loud sounds, and horror elements."
        );
        warning.setEditable(false);
        warning.setBackground(Color.BLACK);
        warning.setForeground(Color.PINK);

        // PLAY BUTTON (go to game)
        JButton play = new JButton("Play Game");

        play.addActionListener(e -> {
            frame.dispose();
            new GameScreen(); // goes to third page
        });

        // DOWNLOAD BUTTONS (open links)

        JButton windows = new JButton("Download for Windows (.exe)");
        JButton mac = new JButton("Download for Mac (.dmg)");
        JButton linux = new JButton("Download for Linux (.AppImage)");

        windows.addActionListener(e ->
                openLink("https://github.com/Group-5-tree-fifty/Game-Repo/releases/latest/download/Click.Click.Boo.Setup.1.0.0.exe")
        );

        mac.addActionListener(e ->
                openLink("https://github.com/Group-5-tree-fifty/Game-Repo/releases/latest/download/Click.Click.Boo-1.0.0-arm64.dmg")
        );

        linux.addActionListener(e ->
                openLink("https://github.com/Group-5-tree-fifty/Game-Repo/releases/latest/download/Click.Click.Boo-1.0.0.AppImage")
        );

        // SCREAM BUTTON
        JButton scream = new JButton("😱 Scream");

        scream.addActionListener(e -> {
            JOptionPane.showMessageDialog(frame, "BOO!!!");
        });

        // ADD COMPONENTS
        frame.add(title);
        frame.add(warning);
        frame.add(play);
        frame.add(windows);
        frame.add(mac);
        frame.add(linux);
        frame.add(scream);

        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
    }

    // OPEN LINKS IN BROWSER
    private void openLink(String url) {
        try {
            java.awt.Desktop.getDesktop().browse(java.net.URI.create(url));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
