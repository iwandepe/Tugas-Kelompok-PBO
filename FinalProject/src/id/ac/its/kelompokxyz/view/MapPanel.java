package id.ac.its.kelompokxyz.view;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import id.ac.its.kelompokxyz.util.Commons;

public class MapPanel extends JPanel {
	private static final long serialVersionUID = 1L;

	public MapPanel(ViewListener viewListener) {
		setFocusable(true);
        requestFocusInWindow();
        
		setBorder(new EmptyBorder(10, 10, 10, 10));
		setBackground(new Color(93, 100, 111));
		setLayout(new GridBagLayout());
		setPreferredSize(new Dimension(Commons.WIDTH, Commons.HEIGHT));
		setFocusable(true);
		requestFocusInWindow();
		
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.insets = new Insets(0,10,0,10);
        
        JPanel buttons = new JPanel(new GridBagLayout());
        buttons.setBackground(new Color(93, 100, 111));;
        buttons.add(viewListener.getMap1(), gbc);
        buttons.add(viewListener.getMap2(), gbc);
        buttons.add(viewListener.getMap3(), gbc);

        gbc.weighty = 1;
        
        add(buttons, gbc);

	}
}
