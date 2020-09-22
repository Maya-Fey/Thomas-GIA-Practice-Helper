/**
 * 
 */
package expert.claire.giasim.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 * The main simulation frame
 * 
 * @author Claire
 */
public class SimFrame extends JFrame implements ActionListener {

	private static final long serialVersionUID = 3094580973914085298L;
	
	private final JComboBox<String> combo = new JComboBox<>();
	private final Map<String, JPanel> panels = new HashMap<>();
	
	private final JPanel panel = new JPanel();

	/**
	 * 
	 */
	public SimFrame(){
		super("GIA Test Simulator");
		this.add(this.panel);
		
		this.combo.addActionListener(this);
		
		this.addView("Part 1", new Part1Panel());
		this.addView("Part 2", new Part2Panel());
		this.addView("Part 3", new Part3Panel());
		
		this.combo.setSelectedIndex(0);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 600);
	}
	
	private void addView(String name, JPanel newPanel)
	{
		this.panels.put(name, newPanel);
		this.combo.addItem(name);
	}
	
	public void setView(String view)
	{
		this.panel.removeAll();
		this.panel.setLayout(new BorderLayout());
		this.panel.add(this.combo, BorderLayout.NORTH);
		this.panel.add(this.panels.get(view), BorderLayout.CENTER);
		this.revalidate();
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		this.setView((String) this.combo.getSelectedItem());
	}
	
	public static final void main(String[] args)
	{
		SimFrame frame = new SimFrame();
		frame.setVisible(true);
	}

}
