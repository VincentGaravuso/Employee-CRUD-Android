
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.filechooser.FileNameExtensionFilter;

public class EmployeeManager {

    List<Employee> empList = new ArrayList<>();
    String empFile = null;

    public boolean addEmployee(String fName, String lName, int ID, int year, int month, int day) throws IOException {
        if (duplicateCheck(ID) == false) {
            return false;
        }
        Employee e = new Employee(fName, lName, ID, year, month, day);
        empList.add(e);
        if (empFile != null) {
            addToFile(e);
        }
        return true;
    }

    private boolean duplicateCheck(int ID) {
        for (Employee e : empList) {
            if (ID == e.getID()) {
                return false;
            }
        }
        return true;
    }

    public void addToFile(Employee e) throws IOException {
        String date[] = e.getHireDate().split("/");
        String year = date[date.length - 1];
        String day = date[date.length - 2];
        String month = date[date.length - 3];
        BufferedWriter writer = new BufferedWriter(new FileWriter(empFile,true));
        writer.newLine(); 
        writer.write(e.getID() + " " + e.getFirstName() + " " + e.getLastName() + " " + year + " " + month + " " + day);
        
        writer.close();
    }

    public void importer() throws FileNotFoundException, IOException {
        JFileChooser choose = new JFileChooser();
        FileNameExtensionFilter filter = new FileNameExtensionFilter("TEXT FILES", "txt", "text");
        choose.setFileFilter(filter);
        String fileName = null;
        int result = choose.showOpenDialog(choose);
        if (result == JFileChooser.APPROVE_OPTION) {
            File f = choose.getSelectedFile();
            empFile = f.getAbsolutePath();
        }
        BufferedReader buf = new BufferedReader(
                new FileReader(empFile));

        String lineJustFetched = null;
        String[] employeeData;
        int count = 0;

        while (true) {
            lineJustFetched = buf.readLine();
            if (lineJustFetched == null) {
                break;
            } else {
                employeeData = lineJustFetched.split("\t+| ");
                int id = (Integer.parseInt(employeeData[0]));
                String fname = (employeeData[1]);
                String lname = employeeData[2];
                int year = Integer.parseInt(employeeData[3]);
                int month = Integer.parseInt(employeeData[4]);
                int day = Integer.parseInt(employeeData[5]);
                Employee e = new Employee(fname,
                        lname, id, year, month, day);
                empList.add(e);
            }
            count++;
        }
        buf.close();

    }
}
