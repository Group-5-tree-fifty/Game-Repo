import javax.swing.*;
import java.awt.*;

public class GameScreen {

    public GameScreen() {

        JFrame frame = new JFrame("GOTCHA!!!");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(new BorderLayout());

        // TITLE (optional like your HTML title)
        JLabel title = new JLabel("GOTCHA!!!", SwingConstants.CENTER);
        title.setForeground(new Color(188, 233, 84));
        title.setFont(new Font("Arial", Font.BOLD, 24));

        // IMAGE (same as your HTML img)
        JLabel image = new JLabel();
        image.setHorizontalAlignment(SwingConstants.CENTER);

        ImageIcon icon = new ImageIcon("Crawling through shadows of horror.png");

        // scale image (important so it fits)
        Image scaled = icon.getImage().getScaledInstance(400, 300, Image.SCALE_SMOOTH);
        image.setIcon(new ImageIcon(scaled));

        // ADD TO FRAME
        frame.add(title, BorderLayout.NORTH);
        frame.add(image, BorderLayout.CENTER);

        frame.setVisible(true);
    }
}
