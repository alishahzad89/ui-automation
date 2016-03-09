/*
 * Copyright 2016 inpwtepydjuf@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mmarquee.automation.controls.stringgrid;

import mmarquee.automation.AutomationElement;
import mmarquee.automation.controls.AutomationBase;
import mmarquee.automation.pattern.*;
import mmarquee.automation.uiautomation.IUIAutomation;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by inpwt on 03/02/2016.
 */
public class AutomationStringGrid extends AutomationBase
{
    private Value valuePattern;
    private Grid grid;
    private Table tablePattern;
    private Selection selectionPattern;

    /**
     * Construct the AutomationStringGrid
     * @param element The element
     * @param uiAuto The automation library
     */
    public AutomationStringGrid(AutomationElement element, IUIAutomation uiAuto) {
        super(element, uiAuto);

        try {
            this.valuePattern = this.getValuePattern();
            this.grid = this.getGridPattern();
            this.tablePattern = this.getTablePattern();
            this.selectionPattern = this.getSelectionPattern();
        } catch (PatternNotFoundException ex) {
            // Handle this nicely somehow
        }
    }

    /**
     * Gets the text associated with the active cell of this element
     * @return The value of the item
     */
    public String getValue() {
        return this.valuePattern.value();
    }

    /**
     * Whether the grid is read only
     * @return Read only?
     */
    public boolean isReadOnly() {
        return this.valuePattern.isReadOnly() == 1;
    }

    /**
     * Gets the selected item from the grid
     * @return AutomationStringGridItem
     */
    public AutomationStringGridCell selected() {
        List<AutomationElement> collection = selectionPattern.getCurrentSelection();

        AutomationStringGridCell item = new AutomationStringGridCell(collection.get(0), uiAuto);

        return item;
    }

    /**
     * Gets the list of the column headers
     * @return List of GridItems
     */
    public List<AutomationStringGridCell> getColumnHeaders () {

        List<AutomationElement> collection = tablePattern.getCurrentColumnHeaders();
        int length = collection.size();

        List<AutomationStringGridCell> items = new ArrayList<AutomationStringGridCell>();

        for (int count = 0; count < length; count++) {
            items.add(new AutomationStringGridCell(collection.get(count), uiAuto));
        }

        return items;
    }

    /**
     * Gets the item associated with the given cell
     * @param x X Offset
     * @param y Y Offset
     * @return The GridItem at the given cell position
     */
    public AutomationStringGridCell getItem(int x, int y) {
        return new AutomationStringGridCell(this.grid.getItem(x, y), uiAuto);
    }
}