package cat.xlagunas.pressureapp.model;

import android.renderscript.Element;

import com.j256.ormlite.field.DataType;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

import java.util.Date;

/**
 * Created by xlagunas on 4/09/15.
 */

@DatabaseTable(tableName = "user")
public class User {
    @DatabaseField(id = true)
    private long id;
    @DatabaseField(canBeNull = false, dataType = DataType.STRING)
    private String name;
    @DatabaseField(canBeNull = false, dataType = DataType.STRING)
    private String surname;
    @DatabaseField(canBeNull = false, dataType = DataType.STRING)
    private String email;
    @DatabaseField(dataType = DataType.DATE_LONG, canBeNull = true)
    private Date alarmReminder;

    public User() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getAlarmReminder() {
        return alarmReminder;
    }

    public void setAlarmReminder(Date alarmReminder) {
        this.alarmReminder = alarmReminder;
    }
}
