
import java.util.ArrayList;
import java.util.List;

public class EmployeeManager{

    List<Employee> empList = new ArrayList<>();

    public boolean addEmployee(String fName, String lName, int ID, int year, int month, int day) {
        if (duplicateCheck(ID) == false) {
            return false;
        }
        Employee e = new Employee(fName, lName, ID, year, month, day);
        empList.add(e);
        return true;
    }

    private boolean duplicateCheck(int ID) {
        for (Employee e : empList) 
            if (ID == e.getID()) 
                return false;
        return true;
    }
}
