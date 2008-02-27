package bibliothek.gui.dock.themes.basic.color;

import java.awt.Color;

import bibliothek.gui.Dockable;
import bibliothek.gui.dock.action.DockAction;
import bibliothek.gui.dock.util.color.AbstractDockColor;
import bibliothek.gui.dock.util.color.DockColor;

/**
 * A color used for a {@link DockAction}.
 * @author Benjamin Sigg
 */
public abstract class ActionColor extends AbstractDockColor{
    /** the dockable for which the action is used */
    private Dockable dockable;
    
    /** the action for which this color is used */
    private DockAction action;
    
    /**
     * Creates a new {@link DockColor}.
     * @param id the identifier of this color
     * @param kind which kind of color this is
     * @param dockable the Dockable for which the action is shown
     * @param action the action for which the color is used
     * @param backup a backup in case a color is missing
     */
    public ActionColor( String id, Class<? extends DockColor> kind, Dockable dockable, DockAction action, Color backup ){
        super( id, kind, backup );
        this.action = action;
        this.dockable = dockable;
    }
    
    /**
     * Gets the action for which this color is used.
     * @return the action
     */
    public DockAction getAction() {
        return action;
    }
    
    /**
     * Gets the {@link Dockable} for which the action is shown.
     * @return the owner of the action
     */
    public Dockable getDockable() {
        return dockable;
    }
}
