/**
 * Bibliothek - DockingFrames
 * Library built on Java/Swing, allows the user to "drag and drop"
 * panels containing any Swing-Component the developer likes to add.
 * 
 * Copyright (C) 2007 Benjamin Sigg
 * 
 * This library is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 2.1 of the License, or (at your option) any later version.
 *
 * This library is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this library; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301  USA
 * 
 * Benjamin Sigg
 * benjamin_sigg@gmx.ch
 * CH - Switzerland
 */

package bibliothek.gui.dock.action;

import bibliothek.gui.Dockable;
import bibliothek.gui.dock.action.views.ActionViewConverter;
import bibliothek.gui.dock.action.views.ViewTarget;
import bibliothek.gui.dock.title.DockTitle;

/**
 * A DockAction is an object that represents an action which can be triggered by the user. Every
 * DockAction has a graphical representation which is shown at many places, for example
 * on a {@link DockTitle} or in a popupmenu.<br>
 * A DockAction may choose their own graphical representation, or use the 
 * {@link ActionViewConverter} to use the default-representations.<br>
 * Every DockAction is associated with some Dockables. The {@link #bind(Dockable)}-method will be invoked
 * before a representation is shown, and the {@link #unbind(Dockable)} when a representation is no
 * longer shown.
 * 
 * @author Benjamin Sigg
 */
public interface DockAction {    
    /**
     * Creates a view for this action, for the platform <code>target</code> and
     * with help of <code>converter</code>. Clients might use their own
     * code to create a new view, but the preferred way is to call
     * {@link ActionViewConverter#createView(ActionType, DockAction, ViewTarget, Dockable)}
     * with an {@link ActionType} that fits to this DockAction.
     * @param <V> the type of view requested
     * @param target The platform on which the view will be used
     * @param converter A set of methods that can be used to create a view
     * @param dockable The Dockable for which the view will be shown. Note that
     * this action may not yet be {@link #bind(Dockable) binded} to this action.
     * @return a new view
     */
    public <V> V createView( ViewTarget<V> target, ActionViewConverter converter, Dockable dockable );
    
    /**
     * Informs this DockAction that icons, text, and other stuff like that,
     * will be requested from this DockAction. This method should be called
     * from the object that will display the view of this action.
     * @param dockable The {@link Dockable} that may be used in the future
     * @see #unbind(Dockable)
     */
    public void bind( Dockable dockable );

    /**
     * Invoked only if the <code>dockable</code> was {@link #bind(Dockable) binded}
     * to this DockAction, and if the <code>dockable</code> will no longer be
     * used for any method calls (except {@link #bind(Dockable) bind}) on 
     * this DockAction.
     * @param dockable The {@link Dockable} that will never be seen again, except
     * it is maybe {@link #bind(Dockable) bind} again.
     */
    public void unbind( Dockable dockable );
}
