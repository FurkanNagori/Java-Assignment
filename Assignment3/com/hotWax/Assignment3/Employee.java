import java.util.Date;

public class Employee implements java.io.Serializable,Comparable<Employee>
    {
        private String employeeId;
        private String name;
        private Date dateOfBirth;
        private String emailId;
        private int age;
        public Employee()
        {
            this.employeeId="";
            this.name="";
            this.dateOfBirth=null;
            this.emailId="";
            this.age=0;
        }

        public void setEmployeeId(String employeeId)
        {
            this.employeeId=employeeId;
        }
        public String getEmployeeId()
        {
            return this.employeeId;
        }

        public void setName(String name)
        {
            this.name=name;
        }
        public String getName()
        {
            return this.name;
        }
        public void setDateOfBirth(Date dateOfBirth)
        {
            this.dateOfBirth=dateOfBirth;
        }
        public Date getDateOfBirth()
        {
            return this.dateOfBirth;
        }
        public void setEmailId(String emailId)
        {
            this.emailId=emailId;
        }
        public String getEmailId()
        {
            return this.emailId;
        }
        public void setAge(int age)
        {
            this.age=age;
        }
        public int getAge()
        {
            return this.age;
        }

        public boolean equals(Object object)
        {
            if(!(object instanceof Employee)) return false;
            Employee employee = (Employee)object;
            return this.emailId.equalsIgnoreCase(employee.emailId);
        }
        public int compareTo(Employee other)
        {
            return this.employeeId.compareTo(other.employeeId);
        }
        public int hashCode()
        {
            return employeeId.hashCode();
        }

    }

