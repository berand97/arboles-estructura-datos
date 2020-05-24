package unac.edu.co.poo2;

public class Student implements Comparated {
    long Code;
    String Name;
    String Email;

    public Student() {
        this(0,null,null);
    }

    public Student(long code, String name, String email) {
        Code = code;
        Name = name;
        Email = email;
    }
    public String toString(){
        if (Name != null){
            return Code + " " + Name + " ";
        } else{
            return "No asignado";
        }

    }

    public boolean menorQue(Object op2) {
        Student  p2 = (Student ) op2;
        return Code < p2.Code;
    }

    public boolean menorIgualQue(Object op2){
        Student  p2 = (Student ) op2;
        return Code <= p2.Code;
    }

    public boolean mayorQue(Object op2){
        Student  p2 = (Student ) op2;
        return Code > p2.Code;
    }

    public boolean mayorIgualQue(Object op2){
        Student  p2 = (Student ) op2;
        return Code >= p2.Code;
    }

    public boolean igualQue(Object op2){
        Student  p2 = (Student ) op2;
        return Code == p2.Code;
    }


}
