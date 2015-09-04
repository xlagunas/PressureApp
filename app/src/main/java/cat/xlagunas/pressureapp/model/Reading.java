package cat.xlagunas.pressureapp.model;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by xlagunas on 4/09/15.
 */

@DatabaseTable(tableName = "reading")
public class Reading {
    @DatabaseField(id = true)
    private long id;
    @DatabaseField(canBeNull = false, foreign = true)
    private User user;
    @DatabaseField(canBeNull = false)
    private float dyastolic;
    @DatabaseField(canBeNull = false)
    private float systolic;
    @DatabaseField(canBeNull = true)
    private int hearbeat;
    @DatabaseField(dataType = DataType.DATE_LONG)
    private Date date;

    public Reading() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public float getSystolic() {
        return systolic;
    }

    public void setSystolic(float systolic) {
        this.systolic = systolic;
    }

    public float getDyastolic() {
        return dyastolic;
    }

    public void setDyastolic(float dyastolic) {
        this.dyastolic = dyastolic;
    }

    public int getHearbeat() {
        return hearbeat;
    }

    public void setHearbeat(int hearbeat) {
        this.hearbeat = hearbeat;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}