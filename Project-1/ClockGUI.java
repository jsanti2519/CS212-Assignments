import java.awt.*;
import javax.swing.*;

public class ClockGUI extends JFrame {
		public static void setClockGUI() {
			ClockGUI pane = new ClockGUI();
		      pane.setTitle("Project 1");
		      pane.setLayout(new GridLayout(1, 2));
		      JTextArea clockText = new JTextArea(Project1.unsort); //JLabel won't recognize a new line
		      pane.getContentPane().add(clockText, BorderLayout.WEST); //layout of sorted array in left side
		      clockText = new JTextArea(Project1.sort);
		      clockText.setEditable(false);
		      pane.getContentPane().add(clockText, BorderLayout.EAST); //layout of sorted array in right side
		      pane.setSize(1000, 1000);
		      pane.setLocation(100, 100);
		      pane.setDefaultCloseOperation(ClockGUI.EXIT_ON_CLOSE);
		      pane.setVisible(true);
		}
	
}
