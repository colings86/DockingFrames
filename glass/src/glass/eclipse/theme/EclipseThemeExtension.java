package glass.eclipse.theme;

import javax.swing.ImageIcon;

import bibliothek.extension.gui.dock.theme.EclipseTheme;
import bibliothek.gui.DockController;
import bibliothek.gui.DockTheme;
import bibliothek.gui.dock.themes.DockThemeExtension;
import bibliothek.gui.dock.util.IconManager;
import bibliothek.gui.dock.util.Priority;

public class EclipseThemeExtension implements DockThemeExtension{
	private DockTheme trigger;
	private EclipseTheme theme;
	
	public EclipseThemeExtension( DockTheme trigger, EclipseTheme theme ){
		this.trigger = trigger;
		this.theme = theme;
	}
	
	public void install( DockController controller, DockTheme theme ){
		if( theme == this.theme ){
			this.theme.setMovingImageFactory( new CMiniPreviewMovingImageFactory( 128 ), Priority.THEME );
		}
	}
	
	public void installed( DockController controller, DockTheme theme ){
		if( this.trigger == theme ){
			IconManager im = controller.getIcons();
	
			im.setIconTheme("locationmanager.maximize", createIcon("images/maximize.png"));
			im.setIconTheme("locationmanager.normalize", createIcon("images/normalize.png"));
			im.setIconTheme("locationmanager.externalize", createIcon("images/externalize.png"));
			im.setIconTheme("locationmanager.minimize", createIcon("images/minimize.png"));
			im.setIconTheme("close", createIcon("images/close_active.png"));
			im.setIconTheme("flap.hold", createIcon("images/pin_active.png"));
			im.setIconTheme("flap.free", createIcon("images/unpin_active.png"));
			im.setIconTheme("overflow.menu", createIcon("images/overflow_menu.png"));
		}
	}
	
	public void uninstall( DockController controller, DockTheme theme ){
		if( this.trigger == theme ){
			IconManager im = controller.getIcons();
			
			im.clearThemeIcons();
		}
	}
	
	public static ImageIcon createIcon(String path) {
		return new ImageIcon( CGlassEclipseTabPainter.class.getResource( path ));
	}
}
