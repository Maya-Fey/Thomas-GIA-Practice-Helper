package expert.claire.giasim.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;

public class Part2Panel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 3560439381323394847L;
	
	private final JPanel panel2 = new JPanel();
	private final JPanel panel3 = new JPanel();

	private final JTextArea area = new JTextArea();
	private final JLabel result = new JLabel();
	
	private final Map<JButton, Integer> buttons = new HashMap<>();
	private final JButton next = new JButton("Next");
	
	private int correct = -1;
	
	public Part2Panel() 
	{
		this.setLayout(new BorderLayout());
		
		this.area.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.result.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.area.setEditable(false);
		this.area.setRows(3);
		this.area.setColumns(30);
		
		this.panel2.setLayout(new BorderLayout());
		this.panel3.setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel();
		for(int i = 0; i < 5; i++) {
			JButton button = new JButton("" + i);
			button.addActionListener(this);
			this.buttons.put(button, i);
			buttonPanel.add(button);
		}
		this.panel2.add(this.area, BorderLayout.NORTH);
		this.panel2.add(buttonPanel, BorderLayout.CENTER);
		
		this.panel3.add(this.result, BorderLayout.NORTH);
		this.panel3.add(this.next, BorderLayout.CENTER);
		
		this.next.addActionListener(this);
		
		this.nextQuestion();
	}
	
	public void newQuestion()
	{
		this.area.setText("");
		this.correct = Part2Helper.populateTA(this.area);
	}
	
	private void answer(boolean isCorrect)
	{
		this.result.setText(isCorrect ? "Correct" : "Incorrect"); 
		this.removeAll();
		this.add(this.panel3, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}
	
	private void nextQuestion()
	{
		this.removeAll();
		this.add(this.panel2, BorderLayout.CENTER);
		this.newQuestion();
		this.revalidate();
		this.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e == null)
			return;
		if(e.getSource() == this.next) {
			this.nextQuestion();
		} else if(this.buttons.containsKey(e.getSource())) {
			int guess = this.buttons.get(e.getSource());
			this.answer(guess == this.correct);
		}
	}

}
