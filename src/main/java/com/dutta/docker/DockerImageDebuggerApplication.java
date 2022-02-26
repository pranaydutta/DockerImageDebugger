package com.dutta.docker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
@RestController
@RequestMapping("/employees")
public class DockerImageDebuggerApplication {


    private EmployeeRepo employeeRepo;

   public DockerImageDebuggerApplication(EmployeeRepo employeeRepo)
   {
       this.employeeRepo=employeeRepo;
   }

    @GetMapping("/{dept}")
    public List<Employee> getEmployee(@PathVariable String dept)
    {
        return employeeRepo.getEmployees()
                .stream()
                .filter(employee -> dept.equals(employee.getDept()))
                .collect(Collectors.toList());
    }

    @GetMapping("/notify/{dept}")
public void sendAnnouncementToEmployees(@PathVariable String dept)
{
    List<String> emailIds = employeeRepo.getEmailIds(dept);
    emailIds.forEach(email -> System.out.println("send email to " + email));


}


    public static void main(String[] args) {
        SpringApplication.run(DockerImageDebuggerApplication.class, args);
    }

}
