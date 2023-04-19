package Userdto;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
@Entity
public class Userdto {
	@Id
	@GeneratedValue(generator="idg")
	@SequenceGenerator(initialValue=4512131,allocationSize=1,name="idg",sequenceName="idg")
	int cid;
String name;
String password;
String email;
long phoneno;
Date dob;
String gender;


public int getCid() {
	return cid;
}
public void setCid(int cid) {
	this.cid = cid;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public long getPhoneno() {
	return phoneno;
}
public void setPhoneno(long phoneno) {
	this.phoneno = phoneno;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public String getGender() {
	return gender;
}
public void setGender(String gender) {
	this.gender = gender;
}
@Override
public String toString() {
	return "Userdto [cid=" + cid + ", name=" + name + ", password=" + password + ", email=" + email + ", phoneno="
			+ phoneno + ", dob=" + dob + ", gender=" + gender + "]";
}

}
