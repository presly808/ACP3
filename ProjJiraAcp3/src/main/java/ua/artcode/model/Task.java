package ua.artcode.model;

import java.util.Date;

/**
 * Created by admin on 07.12.2014.
 */
public class Task {

    enum Status { NEW, IN_PROGRESS, REOPENED, CLOSED, DONE};

    protected Date dateStart;
    protected Date dateFinish;
    protected int hoursEstimate;
    protected int hoursSpent;
    protected String author;

    public int createNewTask(){
        return 0;
    }
    public boolean deleteTask(int id){
        return true;
    }


}
