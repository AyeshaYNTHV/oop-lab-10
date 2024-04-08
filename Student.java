package application;

//Student.java
public class Student {
 private String name;
 private String id;
 private String email;
 private String gender;

 public Student(String name, String id, String email, String gender) {
     this.name = name;
     this.id = id;
     this.email = email;
     this.gender = gender;
 }

 public String getName() {
     return name;
 }

 public void setName(String name) {
     this.name = name;
 }

 public String getId() {
     return id;
 }

 public void setId(String id) {
     this.id = id;
 }

 public String getEmail() {
     return email;
 }

 public void setEmail(String email) {
     this.email = email;
 }

 public String getGender() {
     return gender;
 }

 public void setGender(String gender) {
     this.gender = gender;
 }
}

