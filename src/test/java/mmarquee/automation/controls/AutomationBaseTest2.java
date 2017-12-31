package mmarquee.automation.controls;

import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.IntByReference;
import mmarquee.automation.AutomationElement;
import mmarquee.automation.AutomationException;
import mmarquee.automation.PatternID;
import mmarquee.automation.UIAutomation;
import mmarquee.automation.pattern.ItemContainer;
import mmarquee.automation.pattern.PatternNotFoundException;
import mmarquee.automation.pattern.Window;
import mmarquee.automation.uiautomation.IUIAutomation;
import mmarquee.automation.uiautomation.IUIAutomationElement;
import mmarquee.automation.uiautomation.OrientationType;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.Answer;

import static junit.framework.TestCase.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;
import static org.mockito.Mockito.atLeastOnce;
import static org.mockito.Mockito.verify;

public class AutomationBaseTest2 {
    protected Logger logger = Logger.getLogger(AutomationBaseTest.class.getName());

    @Mock
    AutomationElement element;
    @Mock AutomationElement targetElement;
    @Mock
    Window pattern;
    @Mock
    ItemContainer container;
    @Mock
    User32 user32;

    static {
        ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
    }

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetAriaRole_For_Window() throws Exception {
        when(element.getOrientation()).thenReturn(OrientationType.Horizontal);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        window.getAriaRole();

        verify(element, atLeastOnce()).getAriaRole();
    }

    @Test
    public void testGetClassName_For_Window() throws Exception {
        when(element.getClassName()).thenReturn("CLASS-01");

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        window.getClassName();

        verify(element, atLeastOnce()).getClassName();
    }

    @Test
    public void testGetElement() throws Exception {
        when(element.getOrientation()).thenReturn(OrientationType.Horizontal);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        AutomationElement result = window.getElement();

        assertTrue(result == element);
    }

    @Test
    public void testGetOrientation_For_Window() throws  Exception {
        when(element.getOrientation()).thenReturn(OrientationType.Horizontal);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        OrientationType value = window.getOrientation();

        assertTrue(value == OrientationType.Horizontal);
    }

    @Test
    public void testGetFramework_Gets_Value_From_Element() throws  Exception {
        when(element.getPropertyValue(anyInt())).thenReturn("FRAMEWORK");

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        Object object = window.getFramework();

        assertTrue(object.toString().equals("FRAMEWORK"));
    }

    @Test
    public void testGetFrameworkId_Gets_Value_From_Element() throws  Exception {
        when(element.getFrameworkId()).thenReturn("FRAMEWORK");

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        String name = window.getFrameworkId();

        assertTrue(name.equals("FRAMEWORK"));
    }

    @Test
    public void testIsMultipleViewPatternAvailable () throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isMultipleViewPatternAvailable();

        assertTrue(value);
    }

    @Test
    public void testIsGridItemPatternAvailable () throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isGridItemPatternAvailable();

        assertTrue(value);
    }

    @Test
    public void test_isSelectionItemPatternAvailable  () throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isSelectionItemPatternAvailable ();

        assertTrue(value);
    }

    @Test
    public void test_isRangeValuePatternAvailable () throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isRangeValuePatternAvailable();

        assertTrue(value);
    }

    @Test
    public void testIsTableItemPatternAvailable () throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isTableItemPatternAvailable();

        assertTrue(value);
    }

    @Test
    public void test_isItemContainerPatternAvailable () throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isItemContainerPatternAvailable();

        assertTrue(value);
    }

    @Test
    public void test_isTogglePatternAvailable() throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isTogglePatternAvailable();

        assertTrue(value);
    }

    @Test
    public void test_isSelectionPatternAvailable() throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isSelectionPatternAvailable();

        assertTrue(value);
    }

    @Test
    public void test_isTextPatternAvailable () throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isTextPatternAvailable();

        assertTrue(value);
    }

    @Test
    public void testIsTablePatternAvailable () throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isTablePatternAvailable();

        assertTrue(value);
    }

    @Test
    public void testIsValuePatternAvailable () throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isValuePatternAvailable();

        assertTrue(value);
    }

    @Test
    public void testIsGridPatternAvailable () throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isGridPatternAvailable();

        assertTrue(value);
    }

    @Test
    public void testisScrollPatternAvailable() throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isScrollPatternAvailable();

        assertTrue(value);
    }

    @Test
    public void testisOffScreen_Get_Value_From_Element() throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isOffScreen();

        assertTrue(value);
    }

    @Test
    public void testisTableItemPatternAvailable() throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(0);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isMultipleViewPatternAvailable();

        assertFalse(value);
    }

    @Test
    public void testisScrollItemPatternAvailable () throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isScrollItemPatternAvailable();

        assertTrue(value);
    }

    @Test
    public void testisTransformPatternAvailable() throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isTransformPatternAvailable();

        assertTrue(value);
    }

    @Test
    public void testisGridItemPatternAvailable() throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isGridItemPatternAvailable();

        assertTrue(value);
    }

    @Test
    public void testisGridItemPatternAvailable_Returns_False_When_Property_Is_Zero() throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(0);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean value = window.isGridItemPatternAvailable();

        assertFalse(value);
    }

    @Test
    public void testIsDockPatternPatternAvailable_Returns_True_When_Value_Is_One() throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).itemContainer(container).user32(user32).automation(instance).window( pattern));

        boolean value = window.isDockPatternAvailable();

        assertTrue(value);
    }

    @Test(expected = AutomationException.class)
    public void testgetRuntimeIdThrowsException() throws Exception {
        when(element.getPropertyValue(anyInt())).thenReturn(1);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        window.getRuntimeId();
    }

    @Test
    public void testGetProviderDescription_Gets_Value_From_Element() throws Exception {
        when(element.getProviderDescription()).thenReturn("DESCRIPTION");

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        String value = window.getProviderDescription();

        assertTrue(value.equals("DESCRIPTION"));
    }

    @Test
    public void testGetAcceleratorKey_Gets_Value_From_Element() throws Exception {
        when(element.getAcceleratorKey()).thenReturn("KEY");

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        String value = window.getAcceleratorKey();

        assertTrue(value.equals("KEY"));
    }

    @Test
    public void testgetItemStatus_Gets_Value_From_Element() throws Exception {
        when(element.getItemStatus()).thenReturn("STATUS");

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        String value = window.getItemStatus();

        assertTrue(value.equals("STATUS"));
    }

    @Test
    public void testisEnabled_Gets_Value_From_Element() throws Exception {
        when(element.isEnabled()).thenReturn(new WinDef.BOOL(true));

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).itemContainer(container).user32(user32).automation(instance).window( pattern));

        boolean value = window.isEnabled();

        assertTrue(value);

    }

    @Test
    public void testGetProcessId_Gets_Value_From_Element() throws Exception {
        when(element.getProcessId()).thenReturn(99);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        Object object = window.getProcessId();

        assertTrue(object.equals(99));
    }

    @Test
    public void testGetClickablePoint_Gets_Value_From_Element() throws Exception {
        when(element.getProcessId()).thenReturn(99);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        window.getClickablePoint();

        verify(element, atLeastOnce()).getClickablePoint();
    }

    @Test
    @Ignore("Throws odd exception")
    public void test_isOffScreen_returns_False_When_Element_Throws_Exeception() throws Exception {
        when(element.getProcessId()).thenReturn(99);

        doThrow(AutomationException.class)
                .when(element)
                .getPropertyValue(any());

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        boolean val = window.isOffScreen();

        assertFalse(val);
    }

    @Test(expected= PatternNotFoundException.class)
    public void test_getPattern_throws_PatterNotFoundException_When_Pattern_Not_Found () throws Exception {
        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        window.getPattern(PatternID.Text.getValue());

        verify(element, atLeastOnce()).getPattern(anyInt());
    }

    @Test
    public void testGetBoundingRect_Gets_Value_From_Element() throws Exception {
        when(element.getProcessId()).thenReturn(99);

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        window.getBoundingRectangle();

        verify(element, atLeastOnce()).getBoundingRectangle();
    }

    @Test
    @Ignore("Need to mock variants somehow")
    public void test_getSelectItemPattern() throws Exception {
        IUIAutomationElement el = Mockito.mock(IUIAutomationElement.class);

        AutomationElement element = Mockito.mock(AutomationElement.class);
        element.setElement(el);

        Window pattern = Mockito.mock(Window.class);
        ItemContainer container = Mockito.mock(ItemContainer.class);

        doAnswer((Answer<Integer>) invocation -> {

            Object[] args = invocation.getArguments();
            IntByReference reference = (IntByReference)args[1];

            reference.setValue(0);

            return 0;
        }).when(el).getCurrentPropertyValue(any(), any());

        IUIAutomation mocked_automation = Mockito.mock(IUIAutomation.class);
        UIAutomation instance = new UIAutomation(mocked_automation);

        AutomationWindow window = new AutomationWindow(
                new ElementBuilder(element).user32(user32).itemContainer(container).automation(instance).window( pattern));

        window.getSelectItemPattern();

        verify(element, atLeastOnce()).getBoundingRectangle();
    }
}
