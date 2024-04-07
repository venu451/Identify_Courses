package stepDefinations;

import java.io.IOException;
import java.util.List;

import org.openqa.selenium.WebDriver;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CourseraHomePage;
import pageObjects.DropDownElements;


public class LanguageLearningTest {
	public DropDownElements dde;
	public CourseraHomePage chp;
	public WebDriver driver;
	
	@When("user clicks on Explore dropdown")
	public void user_clicks_on_explore_dropdown() throws IOException {
		
		driver=Hooks.getDriver();
		
		dde=new DropDownElements(driver);
		chp=new CourseraHomePage(driver);
		try {
			chp.clickOnDropDown();
		}catch(Exception e) {
			chp.clickOnDropDown();
		}
	}
	

	@When("select the language learning subject")
	public void select_the_language_learning_subject() {
		
		try {
			dde.clickOnLanguageLearning();
		}catch(Exception e) {
			chp.closeSurvey();
			chp.clickOnDropDown();	
			dde.clickOnLanguageLearning();
		}
	}
	@When("select All Language Courses section")
	public void select_all_language_courses_section() {
		try {
			dde.clickOnAllLanguages();
		}catch(Exception e) {
			chp.closeSurvey();
			chp.clickOnDropDown();
			dde.clickOnLanguageLearning();
			dde.clickOnAllLanguages();
			
		}    
	}

	@Then("it should load a new page with all courses")
	public void it_should_load_a_new_page_with_all_courses() {
		try {
			dde.verifyLanguagePage();
		}catch(Exception e) {
			chp.closeSurvey();
			chp.clickOnDropDown();
			dde.clickOnLanguageLearning();
			dde.clickOnAllLanguages();
			dde.verifyLanguagePage();
		}
	}

	@Then("take all the available languages for each level and extracting number of courses available for each level")
	public void take_all_the_available_languages_for_each_level_and_extracting_number_of_courses_available_for_each_level() throws InterruptedException, IOException {
		try {
			dde.getCount();
		}catch(Exception e) {
			chp.closeSurvey();
			chp.clickOnDropDown();
			dde.clickOnLanguageLearning();
			dde.clickOnAllLanguages();
			dde.verifyLanguagePage();
			List<String> data=dde.getCount();
			
			
		}
	}

//	@When("select chines language")
//	public void select_chines_language() {
//		try {
//			dde.clickOnchines();
//		}catch(Exception e) {
//			chp.closeSurvey();
//			chp.clickOnDropDown();
//			dde.clickOnLanguageLearning();
//			dde.clickOnchines();
//		}
//	}
//	@When("select english language")
//	public void select_english_language() {
//		try {
//			dde.clickOnEnglish();
//		}catch(Exception e) {
//			chp.closeSurvey();
//			chp.clickOnDropDown();
//			dde.clickOnLanguageLearning();
//			dde.clickOnEnglish();
//		}
//	}
//	@When("select french language")
//	public void select_french_language() {
//		try {
//			dde.clickOnFrench();
//		}catch(Exception e) {
//			chp.closeSurvey();
//			chp.clickOnDropDown();
//			dde.clickOnLanguageLearning();
//			dde.clickOnFrench();
//		}
//	}
//
//	@When("select korean language")
//	public void select_korean_language() {
//		try {
//			dde.clickOnKorean();
//		}catch(Exception e) {
//			chp.closeSurvey();
//			chp.clickOnDropDown();
//			dde.clickOnLanguageLearning();
//			dde.clickOnKorean();
//		}
//	}

//	@Then("it should load a new page with courses")
//	public void it_should_load_a_new_page_with_courses() {
//		try {
//			dde.verifyLanguagePage();
//		}catch(Exception e) {
//			chp.closeSurvey();
//			chp.clickOnDropDown();
//			dde.clickOnLanguageLearning();
//			dde.clickOnchines();
//			dde.verifyLanguagePage();
//		}
//	    
//	}

//	@Then("take the count of number of courses available in each level")
//	public void take_the_count_of_number_of_courses_available_in_each_level() {
//		try {
//			dde.getCount();
//		}catch(Exception e) {
//			chp.closeSurvey();
//			chp.clickOnDropDown();
//			dde.clickOnLanguageLearning();
//			dde.clickOnchines();
//			dde.verifyLanguagePage();
//			dde.getCount();
//		}
//	}
	
}
