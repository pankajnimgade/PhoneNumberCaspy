package classes;

/**
 *
 * Created by Pankaj Nimgade on 12/26/2015.
 */
public class ListItem {

    private String activity_Name;
    private Class activity_Class;

    public ListItem() {
    }

    public ListItem(String activity_Name, Class activity_Class) {
        this.activity_Name = activity_Name;
        this.activity_Class = activity_Class;
    }

    public String getActivity_Name() {
        return activity_Name;
    }

    public void setActivity_Name(String activity_Name) {
        this.activity_Name = activity_Name;
    }

    public Class getActivity_Class() {
        return activity_Class;
    }

    public void setActivity_Class(Class activity_Class) {
        this.activity_Class = activity_Class;
    }

    @Override
    public String toString() {
        return activity_Name;
    }
}
