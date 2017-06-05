package sm.educardpartners.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class User {

@SerializedName("name")
@Expose
public String name;
@SerializedName("lastname")
@Expose
public String lastname;
@SerializedName("university")
@Expose
public String university;

}