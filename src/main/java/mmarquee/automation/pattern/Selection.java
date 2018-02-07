/*
 * Copyright 2016-17 inpwtepydjuf@gmail.com
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
package mmarquee.automation.pattern;

import com.sun.jna.platform.win32.COM.COMUtils;
import com.sun.jna.platform.win32.Guid;
import com.sun.jna.platform.win32.WinNT;
import com.sun.jna.ptr.IntByReference;
import com.sun.jna.ptr.PointerByReference;
import mmarquee.automation.AutomationElement;
import mmarquee.automation.AutomationException;
import mmarquee.automation.uiautomation.*;

import java.util.List;

/**
 *
 * Wrapper for the Selection pattern.
 *
 * @author Mark Humphreys
 * Date 25/02/2016.
 */
public class Selection extends BasePattern {

    /**
     * Constructor for the Selection pattern.
     */
    public Selection() {
        this.IID = IUIAutomationSelectionPattern.IID;
    }

    private IUIAutomationSelectionPattern rawPattern;

    /**
     * Constructor for the Selection pattern.
     * @param rawPattern The raw pattern to use
     */
    public Selection(IUIAutomationSelectionPattern rawPattern) {
        this.IID = IUIAutomationSelectionPattern.IID;
        this.rawPattern = rawPattern;
    }

    /**
     * Gets the pointer.
     * @return Underlying pointer
     * @throws AutomationException Automation has gone wrong
     */
    private IUIAutomationSelectionPattern getPattern() throws AutomationException {
        if (this.rawPattern != null) {
            return this.rawPattern;
        } else {
            PointerByReference pbr = new PointerByReference();

            WinNT.HRESULT result0 = this.getRawPatternPointer(pbr);

            if (COMUtils.SUCCEEDED(result0)) {
                return this.convertPointerToInterface(pbr);
            } else {
                throw new AutomationException(result0.intValue());
            }
        }
    }

    /**
     * Gets the current selection.
     * @return The current selection
     * @throws AutomationException Something has gone wrong
     */
    public List<AutomationElement> getCurrentSelection() throws AutomationException {

        PointerByReference pbr = new PointerByReference();

        final int res = this.getPattern().getCurrentSelection(pbr);
        if (res != 0) {
            throw new AutomationException(res);
        }

        return collectionToList(getAutomationElementArrayFromReference(pbr));
    }

    /**
     * Convert the unknown pointer to selection pattern.
     *
     * @param pUnknown The unknown pointer
     * @return IUIAutomationSelectionPattern the converted pointer
     */
    public IUIAutomationSelectionPattern convertPointerToInterface(PointerByReference pUnknown) {
        return IUIAutomationSelectionPatternConverter.PointerToInterface(pUnknown);
    }

    /**
     * Convert the unknown pointer to an array.
     *
     * @param pUnknown The unknown pointer
     * @return IUIAutomationSelectionPattern the converted pointer
     */
    public IUIAutomationElementArray convertPointerToElementArray(PointerByReference pUnknown) {
        return IUIAutomationElementArrayConverter.PointerToInterface(pUnknown);
    }

    /**
     * Gets the current selection.
     * @return List of selected items
     * @throws AutomationException Something has gone wrong
     */
    public List<AutomationElement> getSelection() throws AutomationException {
        return getCurrentSelection();
    }

    /**
     * Returns whether the selection supports multiple selection.
     * @return Value from automation
     * @throws AutomationException Something has gone wrong
     */
    public boolean canSelectMultiple() throws AutomationException {
        IntByReference ibr = new IntByReference();

        final int res = this.getPattern().getCurrentCanSelectMultiple(ibr);
        if (res != 0) {
            throw new AutomationException(res);
        }

        return (ibr.getValue() == 1);
    }

    /**
     * Gets the currently selected item from the IUIAutomationSelectionPattern2 interface.
     * @return The currently selected element, if possible
     * @throws AutomationException Error, or unable to convert to IUIAutomationSelectionPattern2
     */
    public AutomationElement getCurrentSelectedItem() throws AutomationException {
        PointerByReference pbr = new PointerByReference();

        IUIAutomationSelectionPattern2 pattern2 = this.getPattern2();

        final int res = pattern2.getCurrentSelection(pbr);
        if (res != 0) {
            throw new AutomationException(res);
        }

        PointerByReference pUnknown = new PointerByReference();

        WinNT.HRESULT result = this.rawPattern.QueryInterface(
                new Guid.REFIID(IUIAutomationElement.IID), pUnknown);

        if (COMUtils.SUCCEEDED(result)) {
            return new AutomationElement(IUIAutomationElementConverter.PointerToInterface(pUnknown));
        } else {
            throw new AutomationException("Failed to convert to IUIAutomationElement");
        }
    }

    /**
     * Gets the IUIAutomationSelectionPattern2 interface, if possible.
     * @return The IUIAutomationSelectionPattern2 interface
     * @throws AutomationException Not able to convert interface
     */
    private IUIAutomationSelectionPattern2 getPattern2()
            throws AutomationException {

        PointerByReference pUnknown = new PointerByReference();

        WinNT.HRESULT result = this.getPattern().QueryInterface(
                new Guid.REFIID(IUIAutomationSelectionPattern2.IID), pUnknown);

        if (COMUtils.SUCCEEDED(result)) {
            return IUIAutomationSelectionPattern2Convertor.PointerToInterface(pUnknown);
        }

        throw new AutomationException("Failed to convert to IUIAutomationSelectionPattern2");
    }
}
