/*
 * Copyright (c) 2012 Diamond Light Source Ltd.
 *
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 */
package org.eclipse.richbeans.widgets.table;

import org.eclipse.jface.viewers.ColumnLabelProvider;
import org.eclipse.jface.viewers.DelegatingStyledCellLabelProvider;
import org.eclipse.richbeans.widgets.Activator;
import org.eclipse.swt.graphics.Image;

/**
 * This class may be extended to provide custom rendering.
 * @author Matthew Gerring
 *
 */
public abstract class SeriesItemLabelProvider extends ColumnLabelProvider implements DelegatingStyledCellLabelProvider.IStyledLabelProvider  {

	private Image newImage;
	protected int column;
	
	public SeriesItemLabelProvider(int column) {
		this.column = column;
	}
	
	@Override
	public Image getImage(Object element) {
				
		if (element == ISeriesItemDescriptor.NEW || element == ISeriesItemDescriptor.INSERT) {
			if (newImage == null) newImage = Activator.getImage("icons/new.png");
			return newImage;

		}
		return null;
	}

	@Override
	public String getText(Object element) {
		if (!(element instanceof ISeriesItemDescriptor)) return null;
		if (column==0) return ((ISeriesItemDescriptor)element).getName();
		return null;
	}

	public void dispose() {
		super.dispose();
		if (newImage!=null) newImage.dispose();
	}
}
