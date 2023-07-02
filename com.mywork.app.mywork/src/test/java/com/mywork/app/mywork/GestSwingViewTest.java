package com.mywork.app.mywork;

import static org.junit.Assert.*;

import org.junit.Test;
import org.assertj.swing.junit.runner.GUITestRunner;
import org.assertj.swing.junit.testcase.AssertJSwingJUnitTestCase;
import org.junit.runner.RunWith;
import org.assertj.swing.annotation.GUITest;
import org.assertj.swing.core.matcher.JButtonMatcher;
import org.assertj.swing.core.matcher.JLabelMatcher;
import org.assertj.swing.edt.GuiActionRunner;
import org.assertj.swing.fixture.FrameFixture;
import org.assertj.swing.fixture.JButtonFixture;
import org.assertj.swing.fixture.JTextComponentFixture;
import javax.swing.DefaultListModel;
import javax.swing.JList;


@RunWith(GUITestRunner.class)
public class GestSwingViewTest extends AssertJSwingJUnitTestCase{
	private FrameFixture window;
	private GestSwingView gestSwingView;
	
    

    
    
	@Test
	public void test() {
		fail("Not yet implemented");
	}

	@Override
	protected void onSetUp() throws Exception {
		GuiActionRunner.execute(() -> {
			gestSwingView = new GestSwingView();
			return gestSwingView;
			});
			window = new FrameFixture(robot(), gestSwingView);
			window.show(); // shows the frame to test
		
	}
	
	@Test @GUITest
	public void testControlsInitialStates() {
		window.label(JLabelMatcher.withText("name"));
		window.textBox("nameTextBox").requireEnabled();
		window.label(JLabelMatcher.withText("Public Price"));
		window.textBox("publicPriceTextBox").requireEnabled();
		window.label(JLabelMatcher.withText("Private Price"));
		window.textBox("privatePriceTextBox").requireEnabled();
		window.label(JLabelMatcher.withText("numberOfCopies"));
		window.textBox("copiesTextField").requireEnabled();
		window.button(JButtonMatcher.withText("Add")).requireDisabled();
		window.list("bookList");
		window.button(JButtonMatcher.withText("Remove")).requireDisabled();
		window.button(JButtonMatcher.withText("Buy")).requireDisabled();
		window.label("errorLabel").requireText(" ");
	}
	
	@Test
	public void testWhenEnoughInformationThenAddButtonShouldBeEnabled() {
		window.textBox("nameTextBox").enterText("name");
		window.textBox("publicPriceTextBox").enterText("1");
		window.textBox("privatePriceTextBox").enterText("1");
		window.textBox("copiesTextField").enterText("1");
	}
	
	@Test
	public void testWhenEitherTextIsBlankThenAddButtonShouldBeDisabled() {
		JTextComponentFixture nameTextBox = window.textBox("nameTextBox");
		JTextComponentFixture publicPriceTextBox = window.textBox("publicPriceTextBox");
		JTextComponentFixture privatePriceTextBox = window.textBox("privatePriceTextBox");
		JTextComponentFixture copiesTextField = window.textBox("copiesTextBox");
		
		nameTextBox.enterText("1");
		publicPriceTextBox.enterText("");
		privatePriceTextBox.enterText("12");
		copiesTextField.enterText("5");
		
		window.button(JButtonMatcher.withText("Add")).requireDisabled();
		nameTextBox.enterText("");
		publicPriceTextBox.enterText("1");
		privatePriceTextBox.enterText("12");
		copiesTextField.enterText("5");
		
		window.button(JButtonMatcher.withText("Add")).requireDisabled();
		nameTextBox.enterText("0");
		publicPriceTextBox.enterText("3");
		privatePriceTextBox.enterText("");
		copiesTextField.enterText("5");
		
		window.button(JButtonMatcher.withText("Add")).requireDisabled();
		nameTextBox.enterText("9");
		publicPriceTextBox.enterText("3");
		privatePriceTextBox.enterText("12");
		copiesTextField.enterText("");
		
		window.button(JButtonMatcher.withText("Add")).requireDisabled();
		nameTextBox.enterText("");
		publicPriceTextBox.enterText("");
		privatePriceTextBox.enterText("");
		copiesTextField.enterText("");
		
		window.button(JButtonMatcher.withText("Add")).requireDisabled();
	}
	
	@Test
	public void testRemoveButtonShouldBeEnabledOnlyWhenABookIsSelected() {
		GuiActionRunner.execute(()->getListBooksModel().addElement(new Book("hola",2,3,4)));
		window.list("booksList").selectItem(0);
		JButtonFixture btnRemove = window.button(JButtonMatcher.withText("Remove"));
		btnRemove.requireEnabled();
		window.list("bookList").clearSelection();
		btnRemove.requireDisabled();
	}
	
	@Test
	public void testBuyButtonShouldBeEnabledOnlyWhenABookIsSelected() {
		GuiActionRunner.execute(()->getListBooksModel().addElement(new Book("hola",2,3,4)));
		window.list("booksList").selectItem(0);
		JButtonFixture btnBuy = window.button(JButtonMatcher.withText("Buy"));
		btnBuy.requireEnabled();
		window.list("bookList").clearSelection();
		btnBuy.requireDisabled();
	}
	

}
