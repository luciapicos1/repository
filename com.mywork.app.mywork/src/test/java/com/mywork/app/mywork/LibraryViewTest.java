package com.mywork.app.mywork;


import static org.junit.Assert.*;
import org.assertj.swing.junit.runner.GUITestRunner;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.runner.RunWith;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.junit.Test;
import org.assertj.swing.core.matcher.JButtonMatcher;

@RunWith(GUITestRunner.class)
public class LibraryViewTest extends AssertJSwingJUnitTestCase{
	private FrameFixture window;
	private LibraryView libraryView;
	@Override
	protected void onSetUp() throws Exception {
		GuiActionRunner.execute(() -> {
			libraryView = new LibraryView();
			return libraryView;
		});
		window = new FrameFixture(robot(), libraryView);
		window.show();
		
	}
	@Test
    public void testButton_Click() {
        // Realiza una acción en la interfaz gráfica
        window.button(withText("Click Me")).click();

        // Verifica si se realizó la acción esperada
        window.label("resultLabel").requireText("Button clicked!");
    }

	
	@Test
	public void test() {
		
	}

}
