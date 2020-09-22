package expert.claire.giasim.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import expert.claire.giasim.logic.Adjective;
import expert.claire.giasim.logic.Name;
import expert.claire.giasim.logic.RandHelper;

public class Part1Panel extends JPanel implements MouseListener, ActionListener {
	
	private static final long serialVersionUID = 3560439381323394847L;
	
	private final JPanel panel1 = new JPanel();
	private final JPanel panel2 = new JPanel();
	private final JPanel panel3 = new JPanel();

	private final JLabel comparison = new JLabel();
	private final JLabel question = new JLabel();
	private final JLabel result = new JLabel();
	
	private final JButton left = new JButton();
	private final JButton right = new JButton();
	private final JButton next = new JButton("Next");
	
	private boolean leftCorrect = false;
	
	public Part1Panel() 
	{
		this.setLayout(new BorderLayout());
		
		this.comparison.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.question.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		this.result.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
		
		this.panel1.setLayout(new BorderLayout());
		this.panel2.setLayout(new BorderLayout());
		this.panel3.setLayout(new BorderLayout());
		
		this.panel1.add(this.comparison, BorderLayout.CENTER);
		this.panel1.addMouseListener(this);
		
		JPanel buttons = new JPanel();
		buttons.add(this.left);
		buttons.add(this.right);
		this.panel2.add(this.question, BorderLayout.NORTH);
		this.panel2.add(buttons, BorderLayout.CENTER);
		
		this.panel3.add(this.result, BorderLayout.NORTH);
		this.panel3.add(this.next, BorderLayout.CENTER);
		
		this.left.addActionListener(this);
		this.right.addActionListener(this);
		this.next.addActionListener(this);
		
		this.nextQuestion();
	}
	
	public void newQuestion()
	{
		String correct = Name.newName();
		String incorrect = Name.newName();
		String[] questionText = Adjective.newAdjective().inSentence(correct, incorrect);
		this.comparison.setText(questionText[0]);
		this.question.setText(questionText[1]);
		
		this.leftCorrect = RandHelper.bool();
		this.left.setText(this.leftCorrect ? correct : incorrect);
		this.right.setText(!this.leftCorrect ? correct : incorrect);
	}
	
	private void answer(boolean correct)
	{
		this.result.setText(correct ? "Correct" : "Incorrect"); 
		this.removeAll();
		this.add(this.panel3, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}
	
	private void nextQuestion()
	{
		this.removeAll();
		this.add(this.panel1, BorderLayout.CENTER);
		this.newQuestion();
		this.revalidate();
		this.repaint();
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		this.removeAll();
		this.add(this.panel2, BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e == null)
			return;
		if(e.getSource() == this.left) {
			this.answer(this.leftCorrect);
		} else if(e.getSource() == this.right) {
			this.answer(!this.leftCorrect);
		} else if(e.getSource() == this.next) {
			this.nextQuestion();
		}
	}

	@Override
	public void mousePressed(MouseEvent e) { /**/ }

	@Override
	public void mouseReleased(MouseEvent e) { /**/ }

	@Override
	public void mouseEntered(MouseEvent e) { /**/ }

	@Override
	public void mouseExited(MouseEvent e) { /**/ }

	

}
