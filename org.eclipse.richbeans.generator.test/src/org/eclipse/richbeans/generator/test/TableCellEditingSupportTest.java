/*-
 * Copyright © 2016 Diamond Light Source Ltd.
 *
 * This file is part of GDA.
 *
 * GDA is free software: you can redistribute it and/or modify it under the
 * terms of the GNU General Public License version 3 as published by the Free
 * Software Foundation.
 *
 * GDA is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU General Public License for more
 * details.
 *
 * You should have received a copy of the GNU General Public License along
 * with GDA. If not, see <http://www.gnu.org/licenses/>.
 */

package org.eclipse.richbeans.generator.test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

import org.eclipse.jface.viewers.TableViewer;
import org.eclipse.richbeans.generator.TableCellEditingSupport;
import org.eclipse.swt.widgets.Shell;
import org.junit.Test;

public class TableCellEditingSupportTest {
	@Test
	public void testSetsStringProperties(){
		TestBean bean = new TestBean();
		new TableCellEditingSupport(new TableViewer(new Shell()), null, "string").setValue(bean, "value");
		assertThat(bean.string, is("value"));
	}

	@Test
	public void testSetsIntegerProperties(){
		TestBean bean = new TestBean();
		new TableCellEditingSupport(new TableViewer(new Shell()), null, "integer").setValue(bean, "1234");
		assertThat(bean.integer, is(1234));
	}

	@Test
	public void testSetsIntProperties(){
		TestBean bean = new TestBean();
		new TableCellEditingSupport(new TableViewer(new Shell()), null, "intValue").setValue(bean, "1234");
		assertThat(bean.intValue, is(1234));
	}

	@Test
	public void testSetsDoubleProperties(){
		TestBean bean = new TestBean();
		new TableCellEditingSupport(new TableViewer(new Shell()), null, "doubleObject").setValue(bean, "1234.5");
		assertThat(bean.doubleObject, is(1234.5));
	}

	@Test
	public void testSetsDoubleTypeProperties(){
		TestBean bean = new TestBean();
		new TableCellEditingSupport(new TableViewer(new Shell()), null, "doubleValue").setValue(bean, "1234.5");
		assertThat(bean.doubleValue, is(1234.5));
	}

	@SuppressWarnings("unused")
	private class TestBean {
		String string;
		Integer integer;
		int intValue;
		Double doubleObject;
		double doubleValue;

		public void setString(String string){
			this.string = string;
		}
		public void setInteger(Integer integer){
			this.integer = integer;
		}
		public void setIntValue(int intValue){
			this.intValue = intValue;
		}
		public void setDoubleObject(Double doubleObject) {
			this.doubleObject = doubleObject;
		}
		public void setDoubleValue(double doubleValue) {
			this.doubleValue = doubleValue;
		}
	}
}
