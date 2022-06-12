package model;

public class WorkoutData {

    private String timeOfDay = "09:00 AM";
    private String nameOfWorkout = "Jogging";
    private String workoutDescription = "Jogging is a form of trotting or running at a slow or leisurely pace";
    private String distance = "8";
    private String duration = "01:00:05";
    private String perceivedEffort = "Max Effort";

    public String getTimeOfDay() {
        return timeOfDay;
    }

    public String getNameOfWorkout() {
        return nameOfWorkout;
    }

    public String getWorkoutDescription() {
        return workoutDescription;
    }

    public String getDistance() {
        return distance;
    }

    public String getDuration() {
        return duration;
    }

    public String getPerceivedEffort() {
        return perceivedEffort;
    }
}
