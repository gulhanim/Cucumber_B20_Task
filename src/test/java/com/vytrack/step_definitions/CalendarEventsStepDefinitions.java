package com.vytrack.step_definitions;

import com.vytrack.page.CalendarEventsPage;
import com.vytrack.utils.Browser;
import com.vytrack.utils.ConfigurationReader;
import com.vytrack.utils.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

public class CalendarEventsStepDefinitions {

    @Given("user in login page")
    public void user_in_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("url"));
    }

    @When("user login as {string}")
    public void user_login_as(String role) {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.login(role);
    }

    @When("user naivest to {string} and {string}")
    public void user_naivest_to_and(String tab, String module) {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.navigate(tab,module);
    }

    @When("Hover on three dots “...” for “Testers meeting” calendar event")
    public void hover_on_three_dots_for_testers_meeting_calendar_event() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Browser.wait(3);
        calendarEventsPage.threeDotsHover();
    }

    @Then("Verify that “view”, “edit” and “delete” options are available")
    public void verify_that_view_edit_and_delete_options_are_available() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertTrue(calendarEventsPage.threeDots_view.isDisplayed());
        Assert.assertTrue(calendarEventsPage.threeDots_edit.isDisplayed());
        Assert.assertTrue(calendarEventsPage.threeDots_delete.isDisplayed());
    }

    @When("Click on “Grid Options” button")
    public void click_on_grid_options_button() {
    CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
    calendarEventsPage.click_gridOptions();
    }

    @When("Deselect all options except “Title”")
    public void deselect_all_options_except_title() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.selectTitleOnly();
    }

    @Then("Verify that “Title” column still displayed")
    public void verify_that_title_column_still_displayed() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertTrue(calendarEventsPage.columnTitle.isDisplayed());

    }

    @When("Click on “Create Calendar Event” button")
    public void click_on_create_calendar_event_button() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.click_createCalendarEvent();
    }

    @When("Expand “Save And Close” menu")
    public void expand_save_and_close_menu() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Browser.wait(2);
        calendarEventsPage.click_saveAndClose_expand();
    }

    @Then("Verify that “Save And Close”, “Save And New” and “Save” options are available")
    public void verify_that_save_and_close_save_and_new_and_save_options_are_available() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertTrue(calendarEventsPage.saveAndClose_expand_save.isDisplayed());
        Assert.assertTrue(calendarEventsPage.saveAndClose_expand_saveAndClose.isDisplayed());
        Assert.assertTrue(calendarEventsPage.saveAndClose_expand_saveAndNew.isDisplayed());
    }

    @When("Click on “Cancel” button")
    public void click_on_cancel_button() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Browser.wait(2);
        calendarEventsPage.click_cancel();
    }

    @Then("Verify that “All Calendar Events” page subtitle is displayed")
    public void verify_that_all_calendar_events_page_subtitle_is_displayed() {
        Browser.wait(1);
        Assert.assertTrue(Driver.getDriver().getTitle().contains("All - Calendar Events - Activities"));
    }

    //////////////////////////////AC5///////////////////////////////////////////////
//    @Then("Verify that difference between end and start time is exactly {int} hour")
//    public void verify_that_difference_between_end_and_start_time_is_exactly_hour(Integer int1) {
//        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
//        System.out.println("start"+calendarEventsPage.starts.getText());
//        System.out.println("end"+calendarEventsPage.end.getText());
//    }
    //////////////////////////////AC6////////////////////////////////////////////////////

    ///////////////////////////////AC7//////////////////////////////////////////////////

    @When("Select “All-Day Event” checkbox")
    public void select_all_day_event_checkbox() {
       CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
       calendarEventsPage.allDayCheckBox.click();
    }

    @Then("Verify that “All-Day Event” checkbox is selected")
    public void verify_that_all_day_event_checkbox_is_selected() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertTrue(calendarEventsPage.allDayCheckBox.isSelected());
    }

    @Then("Verify that start and end time input boxes are not displayed")
    public void verify_that_start_and_end_time_input_boxes_are_not_displayed() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Browser.wait(2);
        Assert.assertTrue(!calendarEventsPage.starts.isDisplayed());


    }

    @Then("Verify that start and end date input boxes are displayed")
    public void verify_that_start_and_end_date_input_boxes_are_displayed() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Browser.wait(2);
        Assert.assertTrue(!calendarEventsPage.end.isDisplayed());
    }

    @When("Select “Repeat” checkbox")
    public void select_repeat_checkbox() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.repeatCheckBox.click();
    }

    @Then("Verify that “Repeat” checkbox is selected")
    public void verify_that_repeat_checkbox_is_selected() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Browser.wait(1);
        Assert.assertTrue(calendarEventsPage.repeatCheckBox.isSelected());
    }

    @Then("Verify that “Daily” is selected by default and following options are available in “Repeats” drop-down:")
    public void verify_that_daily_is_selected_by_default_and_following_options_are_available_in_repeats_drop_down() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Select select = new Select(calendarEventsPage.repeatsSelector);
        Browser.wait(2);
        Assert.assertTrue(select.getFirstSelectedOption().getText().contains("Daily"));
    }

    @Then("Verify that “Repeat Every” radio button is selected")
    public void verify_that_repeat_every_radio_button_is_selected() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        Assert.assertTrue(calendarEventsPage.repeatEveryRadioButton.isSelected());
    }

    @Then("Verify that “Never” radio button is selected as an “Ends” option.")
    public void verify_that_never_radio_button_is_selected_as_an_ends_option() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Browser.wait(1);
        Assert.assertTrue(calendarEventsPage.end_neverRadioButton.isEnabled());
    }

    @Then("Verify that following message as a summary is displayed: “Summary: Daily every {int} day”")
    public void verify_that_following_message_as_a_summary_is_displayed_summary_daily_every_day(Integer int1) {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        String accRes= calendarEventsPage.summaryMessage.getText().trim();
        System.out.println("accRes = " + accRes);

        Assert.assertEquals(accRes,"Summary:\n" +
                "Daily every "+int1+" day");
    }

    @When("Select “After {int} occurrences” as an “Ends” option.")
    public void select_after_occurrences_as_an_ends_option(Integer int1) {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.end_afterEnter(int1);
    }

    @Then("Verify that following message as a summary is displayed: “Summary: Daily every {int} day, endafter {int} occurrences”")
    public void verify_that_following_message_as_a_summary_is_displayed_summary_daily_every_day_endafter_occurrences(Integer int1, Integer int2) {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        String accRes= calendarEventsPage.summaryMessage.getText().trim();
        System.out.println("accRes = " + accRes);

        Assert.assertEquals(accRes,"Summary:\n" +
                "Daily every "+int1+" day, end after "+int2+" occurrences");
    }

    @When("Select {string} options as a “Repeat” option")
    public void select_weekly_options_as_a_repeat_option(String type) {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.repeatsSelector_select(type);

    }

    @When("Select “Monday and Friday” options as a “Repeat On” options")
    public void select_monday_and_friday_options_as_a_repeat_on_options() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        calendarEventsPage.repeatOn_monday.click();
        calendarEventsPage.repeatOn_friday.click();
    }

    @Then("Verify that “Monday and Friday” options are selected")
    public void verify_that_monday_and_friday_options_are_selected() {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();
        Assert.assertTrue(calendarEventsPage.repeatOn_monday.isSelected());
        Assert.assertTrue(calendarEventsPage.repeatOn_friday.isSelected());
    }

    @Then("Verify that following message as a summary is displayed: “Summary: Weekly every {int} week onMonday, Friday”")
    public void verify_that_following_message_as_a_summary_is_displayed_summary_weekly_every_week_on_monday_friday(Integer int1) {
        CalendarEventsPage calendarEventsPage = new CalendarEventsPage();

        String accRes= calendarEventsPage.summaryMessage.getText().trim();
        System.out.println("accRes = " + accRes);

        Assert.assertEquals(accRes,"Summary:\n" +
                "Weekly every "+int1+" week on Monday, Friday");

    }



}
