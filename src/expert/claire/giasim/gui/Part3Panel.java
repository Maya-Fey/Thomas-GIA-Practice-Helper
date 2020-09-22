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

import expert.claire.giasim.logic.Part3Helper;

public class Part3Panel extends JPanel implements ActionListener {
	
	private static final long serialVersionUID = 3560439381323394847L;
	
	private final JPanel panel2 = new JPanel();
	private final JPanel panel3 = new JPanel();

	private final JLabel result = new JLabel();
	
	private final Map<JButton, Integer> buttons = new HashMap<>();
	private final JButton next = new JButton("Next");
	
	private Part3Helper helper = new Part3Helper();
	private int[] answers = new int[3];
	private int correct = -1;
	
	public Part3Panel() 
	{
		this.setLayout(new BorderLayout());
		this.result.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		this.panel2.setLayout(new BorderLayout());
		this.panel3.setLayout(new BorderLayout());
		
		JPanel buttonPanel = new JPanel();
		for(int i = 0; i < 3; i++) {
			JButton button = new JButton("");
			button.addActionListener(this);
			this.buttons.put(button, 0);
			buttonPanel.add(button);
		}
		this.panel2.add(buttonPanel, BorderLayout.CENTER);
		
		this.panel3.add(this.result, BorderLayout.NORTH);
		this.panel3.add(this.next, BorderLayout.CENTER);
		
		this.next.addActionListener(this);
		
		this.nextQuestion();
	}
	
	public void newQuestion()
	{
		this.correct = this.helper.generateProblem(this.answers);
		int i = 0; 
		for(JButton button : this.buttons.keySet()) {
			int answer = this.answers[i++];
			this.buttons.put(button, answer);
			button.setText(Integer.toString(answer));
		}
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
