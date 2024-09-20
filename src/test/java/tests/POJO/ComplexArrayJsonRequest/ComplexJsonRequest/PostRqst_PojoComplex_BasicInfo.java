package tests.POJO.ComplexArrayJsonRequest.ComplexJsonRequest;

public class PostRqst_PojoComplex_BasicInfo {
    String FirstName;
    String LastName;
    String Designation;
    String Id;
    String MentorName;
    String CourseName;
    PostRequest_PojoComplex_Adress[] Address;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public PostRequest_PojoComplex_Adress[] getAddress() {
        return Address;
    }

    public void setAddress(PostRequest_PojoComplex_Adress[] Address) {
        this.Address = Address;
    }

    public String getCourseName() {
        return CourseName;
    }

    public void setCourseName(String courseName) {
        CourseName = courseName;
    }

    public String getMentorName() {
        return MentorName;
    }

    public void setMentorName(String mentorName) {
        MentorName = mentorName;
    }

    public String getDesignation() {
        return Designation;
    }

    public void setDesignation(String designation) {
        Designation = designation;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }


}
