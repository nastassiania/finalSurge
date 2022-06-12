package page;

import elements.ActivitySubType;
import elements.DropDown;
import lombok.extern.log4j.Log4j2;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utils.Waiter;

@Log4j2
public class AddWorkoutPage extends BasePage {

    @FindBy(xpath = "//a[@data-code='run']")
    private WebElement runActivity;

    @FindBy(xpath = "//i[@class='icon-calendar']")
    private WebElement calendarField;

    @FindBy(xpath = "//td[@class='day  active']")
    private WebElement today;

    @FindBy(xpath = "//input[@id='WorkoutTime']")
    private WebElement workoutTime;

    @FindBy(xpath = "//input[@id='Name']")
    private WebElement workoutName;

    @FindBy(xpath = "//textarea[@id='Desc']")
    private WebElement workoutDescription;

    @FindBy(xpath = "//input[@id='Distance']")
    private WebElement distance;

    @FindBy(xpath = "//input[@id='Duration']")
    private WebElement duration;

    @FindBy(xpath = "//input[@id='hf_terrible']")
    private WebElement terribleFeelingsRadioButton;

    @FindBy(xpath = "//select[@id='PerEffort']")
    private WebElement perceivedEffort;

    @FindBy(xpath = "//input[@id='saveButton']")
    private WebElement addWorkoutButton;

    public AddWorkoutPage chooseRunActivity() {
        log.info("Choose run activity");
        runActivity.click();
        return this;
    }

    public AddWorkoutPage chooseActivitySubType(String activitySubType) {
        log.info("Choose run activity sub-type - " + activitySubType);
        new ActivitySubType(activitySubType).chooseActivitySubType();
        return this;
    }

    public AddWorkoutPage chooseTodayInCalendar() {
        log.info("Choose today in calendar");
        new Waiter().waitVisibilityOf(calendarField);
        calendarField.click();
        today.click();
        return this;
    }

    public AddWorkoutPage chooseTimeOfDay(String timeOfDay) {
        log.info("Choose time");
        workoutTime.click();
        new DropDown(timeOfDay).chooseTimeOfDay();
        return this;
    }

    public AddWorkoutPage fillInWorkoutName(String nameOfWorkout) {
        log.info("Enter workout name");
        workoutName.clear();
        workoutName.sendKeys(nameOfWorkout);
        return this;
    }

    public AddWorkoutPage fillInWorkoutDescription(String workoutDesc) {
        log.info("Enter workout description");
        workoutDescription.clear();
        workoutDescription.sendKeys(workoutDesc);
        return this;
    }

    public AddWorkoutPage fillInDistance(String distanceToEnter) {
        log.info("Enter distance");
        distance.clear();
        distance.sendKeys(distanceToEnter);
        return this;
    }

    public AddWorkoutPage fillInDuration(String durationToEnter) {
        log.info("Enter duration");
        duration.clear();
        duration.sendKeys(durationToEnter);
        return this;
    }

    public AddWorkoutPage clickTerribleFeelingsRadioButton() {
        log.info("Pick \"How I feel\" - terrible");
        terribleFeelingsRadioButton.click();
        return this;
    }

    public AddWorkoutPage choosePerceivedEffort(String perceivedEffortToChoose) {
        log.info("Choose perceived effort");
        perceivedEffort.click();
        new DropDown(perceivedEffortToChoose).choosePerceivedEffort();
        return this;
    }

    public void clickAddWorkoutButton() {
        log.info("Click \"Add workout\" button");
        addWorkoutButton.click();
    }

}
