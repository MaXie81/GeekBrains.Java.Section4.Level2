package geekgrains.java.section4.level2.lesson7.controller;

import geekgrains.java.section4.level2.lesson7.entity.Student;
import geekgrains.java.section4.level2.lesson7.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class StudentController {
    StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public String findAllStudents(Model model) {
        model.addAttribute("listOfStudents", studentService.findAll());
        return "all_students";
    }
    @GetMapping("/info/{id}")
    public String findStudent(Model model, @PathVariable Long id) {
        model.addAttribute("student", studentService.find(id));
        return "student_info";
    }
    @GetMapping("/add")
    public String addStudent(Model model) {
        model.addAttribute("student", new Student());
        return "add_student";
    }
    @PostMapping("/add")
    public String addStudent(Student student) {
        studentService.add(student);
        return "redirect:/";
    }
    @GetMapping("/edit/{id}")
    public String editStudent(Model model, @PathVariable Long id) {
        model.addAttribute("student", studentService.find(id));
        return "edit_student";
    }
    @PostMapping("/edit")
    public String editStudent(Student student) {
        studentService.edit(student);
        return "redirect:/";
    }
    @GetMapping("/delete/{id}")
    public String deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/";
    }
}
