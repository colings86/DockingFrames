package bibliothek.demonstration;

import java.awt.CardLayout;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.util.List;

import javax.swing.DefaultListCellRenderer;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class MainPanel extends JPanel {
	private JList list = new JList();
	private CardLayout layout = new CardLayout();
	private JPanel panel;
	
	public MainPanel( Core core, List<Demonstration> demos ){
		super( new GridBagLayout() );
		
		DefaultListModel model = new DefaultListModel();
		panel = new JPanel( layout );
		int index = 0;
		
		for( Demonstration demo : demos ){
			model.addElement( demo );
			
			DemoPanel demoPanel = new DemoPanel( core, demo );
			panel.add( demoPanel, String.valueOf( index ) );
			
			index++;
		}
		
		add( new JScrollPane( list ), new GridBagConstraints( 0, 0, 1, 1, 1.0, 1.0, 
				GridBagConstraints.CENTER, GridBagConstraints.VERTICAL, 
				new Insets( 2, 2, 2, 2 ), 0, 0 ));
		add( panel, new GridBagConstraints( 1, 0, 1, 1, 100.0, 1.0, 
				GridBagConstraints.CENTER, GridBagConstraints.BOTH,
				new Insets( 2, 2, 2, 2 ), 0, 0 ));
		
		list.addListSelectionListener( new ListSelectionListener(){
			public void valueChanged( ListSelectionEvent e ){
				layout.show( panel, String.valueOf( list.getSelectedIndex()));
			}
		});
		
		list.setModel( model );
		list.setCellRenderer( new Renderer() );
		
		if( model.getSize() > 0 )
			list.setSelectedIndex( 0 );
	}
	
	private class Renderer extends DefaultListCellRenderer{
		@Override
		public Component getListCellRendererComponent( JList list, Object value, int index, boolean isSelected, boolean cellHasFocus ){
			Demonstration demo = (Demonstration)value;
			super.getListCellRendererComponent( list, demo.getName(), index, isSelected, cellHasFocus );
			setIcon( demo.getIcon() );
			return this;
		}
	}
}
