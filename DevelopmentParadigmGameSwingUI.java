import javax.swing.*;
import java.awt.*;
import java.util.Map;

public class DevelopmentParadigmGameSwingUI {
	private static final Map<Character, String[]> devStyles = Map.ofEntries(
			Map.entry('A', new String[]{"Anxiety Driven Development", "When the deadline is near, all roads lead to it!"}),
			Map.entry('B', new String[]{"Bug Driven Development", "If it compiles, ship it! Fix it later."}),
			Map.entry('C', new String[]{"Conference Driven Development", "You only code after attending a conference!"}),
			Map.entry('D', new String[]{"Deadline Driven Development", "Productivity spikes only near deadlines."}),
			Map.entry('E', new String[]{"Experiment Driven Development", "Keep trying things until something works."}),
			Map.entry('F', new String[]{"Fear Driven Development", "You change code only when your manager isn't watching."}),
			Map.entry('G', new String[]{"Google Driven Development", "If you don't know it, Google it!"}),
			Map.entry('H', new String[]{"Hackathon Driven Development", "You work best when there's free pizza and a timer."}),
			Map.entry('I', new String[]{"Interview Driven Development", "You only study before job interviews."}),
			Map.entry('J', new String[]{"JavaDoc Driven Development", "Code first, documentation later (maybe)."}),
			Map.entry('K', new String[]{"Keyboard Driven Development", "More keystrokes mean better coding!"}),
			Map.entry('L', new String[]{"Log Driven Development", "More logs, more debugging!"}),
			Map.entry('M', new String[]{"Micromanagement Driven Development", "Every line of code must be reviewed twice!"}),
			Map.entry('N', new String[]{"Night Owl Driven Development", "Best code is written at 2 AM."}),
			Map.entry('O', new String[]{"Open Source Driven Development", "If it's open source, it must be good!"}),
			Map.entry('P', new String[]{"Patch Driven Development", "Code first, patch later."}),
			Map.entry('Q', new String[]{"Quick Fix Driven Development", "Make it work first, think later."}),
			Map.entry('R', new String[]{"Refactor Driven Development", "The first version is never good enough."}),
			Map.entry('S', new String[]{"Stack Overflow Driven Development", "90% copy-paste, 10% debugging."}),
			Map.entry('T', new String[]{"Test Driven Development", "Or at least pretending to do so."}),
			Map.entry('U', new String[]{"User Complaint Driven Development", "Fix it only when users notice!"}),
			Map.entry('V', new String[]{"Version Driven Development", "Let's just increment the version number."}),
			Map.entry('W', new String[]{"Wiki Driven Development", "If it’s not on the wiki, does it exist?"}),
			Map.entry('X', new String[]{"XML Driven Development", "Because JSON is too mainstream."}),
			Map.entry('Y', new String[]{"YOLO Driven Development", "Ship now, fix later."}),
			Map.entry('Z', new String[]{"Zero Bug Driven Development", "Close all bugs by marking them 'Won't Fix'."})
	);

	public static void main(String[] args) {
		SwingUtilities.invokeLater(DevelopmentParadigmGameSwingUI::createAndShowGUI);
	}

	private static void createAndShowGUI() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception _) {
		}

		var frame = new JFrame("Development Style Game");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(600, 400);
		frame.setLayout(new BorderLayout());

		var label = new JLabel("What kind of development do you practice?", SwingConstants.CENTER);
		label.setFont(new Font("Arial", Font.BOLD, 18));
		label.setForeground(Color.BLACK);
		frame.add(label, BorderLayout.NORTH);

		var buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(4, 7, 5, 5));
		buttonPanel.setBackground(new Color(230, 230, 230));

		for (char ch = 'A'; ch <= 'Z'; ch++) {
			var button = getButton(ch);
			buttonPanel.add(button);
		}

		frame.add(buttonPanel, BorderLayout.CENTER);
		frame.getContentPane().setBackground(new Color(200, 200, 200));
		frame.setVisible(true);
	}

	private static JButton getButton(char ch) {
		JButton button = new JButton(String.valueOf(ch));
		button.setFont(new Font("Arial", Font.BOLD, 18));
		button.setPreferredSize(new Dimension(50, 50));
		button.setBackground(new Color(70, 130, 180)); // Adjusted color for better visibility
		button.setForeground(Color.WHITE);
		button.setFocusPainted(false);
		button.addActionListener(_ -> {
			String[] messages = devStyles.getOrDefault(button.getText().charAt(0), new String[]{"No definition found!", "Try another letter."});
			showPopup(messages[0], messages[1]);
		});
		return button;
	}

	private static void showPopup(String title, String subtitle) {
		var dialog = new JDialog();
		dialog.setTitle("Your Development Style");
		dialog.setSize(400, 180);
		dialog.setLayout(new BorderLayout());
		dialog.setModal(true);

		var textPanel = new JPanel(new GridLayout(2, 1));
		textPanel.setBackground(Color.WHITE);

		var titleLabel = new JLabel(title, SwingConstants.CENTER);
		titleLabel.setFont(new Font("Arial", Font.BOLD, 18));
		textPanel.add(titleLabel);

		var subtitleLabel = new JLabel(subtitle, SwingConstants.CENTER);
		subtitleLabel.setFont(new Font("Arial", Font.ITALIC, 14));
		subtitleLabel.setForeground(Color.GRAY);
		textPanel.add(subtitleLabel);

		dialog.add(textPanel, BorderLayout.CENTER);

		JButton okButton = new JButton("OK");
		okButton.setFont(new Font("Arial", Font.BOLD, 14));
		okButton.addActionListener(e -> dialog.dispose());
		JPanel buttonPanel = new JPanel();
		buttonPanel.add(okButton);
		dialog.add(buttonPanel, BorderLayout.SOUTH);

		dialog.setLocationRelativeTo(null);
		dialog.setVisible(true);
	}
}