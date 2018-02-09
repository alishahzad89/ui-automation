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

package mmarquee.automation.controls;

import mmarquee.automation.AutomationException;
import mmarquee.automation.pattern.PatternNotFoundException;
import mmarquee.automation.pattern.Toggle;
import mmarquee.automation.uiautomation.ToggleState;

/**
 * Wrapper for the CheckBox element.
 *
 * @author Mark Humphreys
 * Date 31/01/2016.
 */
public final class AutomationCheckBox
        extends AutomationBase
        implements Toggleable, Focusable {

    /**
     * The toggle pattern.
     */
    private Toggle togglePattern;

    /**
     * <p>
     * Invokes the toggle event for this control.
     * </p>
     * @throws AutomationException Something has gone wrong.
     * @throws PatternNotFoundException Failed to find pattern.
     */
    public void toggle()
            throws AutomationException, PatternNotFoundException {
        if (this.togglePattern == null) {
            togglePattern = this.getTogglePattern();
        }

        this.togglePattern.toggle();
    }

    /**
     * <p>
     * Gets the toggle state of this control.
     * </p>
     * @return The toggle state.
     * @throws AutomationException Something has gone wrong.
     * @throws PatternNotFoundException Failed to find pattern.
     */
    public ToggleState getToggleState()
            throws AutomationException, PatternNotFoundException {
        if (this.togglePattern == null) {
            togglePattern = this.getTogglePattern();
        }

        return this.togglePattern.currentToggleState();
    }

    /**
     * Constructor for the AutomationCheckBox.
     *
     * @param builder The builder
     */
    public AutomationCheckBox(final ElementBuilder builder) {
        super(builder);
        togglePattern = builder.getToggle();
    }

    /**
     * <p>
     * Sets the focus to this control.
     * </p>
     */
    public void focus() {
        this.element.setFocus();
    }
}
