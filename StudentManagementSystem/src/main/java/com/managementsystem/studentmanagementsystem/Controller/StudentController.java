package com.managementsystem.studentmanagementsystem.Controller;

import com.managementsystem.studentmanagementsystem.Entity.Student;
import com.managementsystem.studentmanagementsystem.Service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Thymeleaf kullandığından bu bir restcontroller değildir.
@Controller
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    //return ettiği şey aslında templates klasörü altındaki html dosyalarıdır.
    //modelin içindeki verileri html de kyllanabiliyoruz.
    @GetMapping("/students")
    public String listStudents(Model model){
        List<Student> students = studentService.getAllStudents();
        model.addAttribute("students", students);
        return "students";
    }

    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    }

    @PostMapping("/students/new")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }

    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable("id") Long id, Model model){
        Student student = studentService.getStudentById(id);
        model.addAttribute("student", student);
        return "edit_student";
    }

    @PostMapping("/students/edit/{id}")
    public String editStudent(@PathVariable("id") Long id, @ModelAttribute("student") Student student, Model model){
        Student existingStudent = studentService.getStudentById(id);
        existingStudent.setId(student.getId());
        existingStudent.setFirstName(student.getFirstName());
        existingStudent.setLastName(student.getLastName());
        existingStudent.setEmail(student.getEmail());

        studentService.saveStudent(existingStudent);
        return "redirect:/students";
    }

    @GetMapping("/students/delete/{id}")
    public String deleteStudent(@PathVariable("id") Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }



    //https://www.youtube.com/watch?v=VR1zoNomG3w
    //burda kaldın update işlemine başlayacaktı

}
