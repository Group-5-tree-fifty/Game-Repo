import javax.swing.*;
import java.awt.*;

public class IndexScreen {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Click Click Boo - Home");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JLabel title = new JLabel("Welcome to Click Click Boo!", SwingConstants.CENTER);
        title.setForeground(Color.RED);
        title.setFont(new Font("Arial", Font.BOLD, 22));

        JTextArea text = new JTextArea(
                "Hello player, welcome to Click Click Boo!\n\n" +
                "Click objects in the room to find monsters lurking in the dark.\n" +
                "Each level becomes more intense.\n\n" +
                "WARNING: Not for sensitive players."
        );

        text.setEditable(false);
        text.setBackground(Color.BLACK);
        text.setForeground(Color.PINK);

        JButton enter = new JButton("Enter If You Dare!");

        enter.addActionListener(e -> {
            frame.dispose(); // close this screen
            new SecondScreen(); // go to second page
        });

        frame.add(title, BorderLayout.NORTH);
        frame.add(text, BorderLayout.CENTER);
        frame.add(enter, BorderLayout.SOUTH);

        frame.getContentPane().setBackground(Color.BLACK);
        frame.setVisible(true);
    }
}
