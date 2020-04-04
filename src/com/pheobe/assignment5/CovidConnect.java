package com.pheobe.assignment5;

import java.util.ArrayList;

public class CovidConnect {
    private ArrayList<Student> dalStudents;

    public CovidConnect() {
        dalStudents = new ArrayList<>();
    }

    public ArrayList<Student> getDalStudents() {
        return dalStudents;
    }

    public int numberDalStudents() {
        return dalStudents.size();
    }

    public boolean addStudent(Student student) {
        if (!validateStudentID(student.getStudentID())) {
            return false;
        }
        boolean exist = false;
        for (int i = 0; i < dalStudents.size(); i++) {
            if (student.equals(dalStudents.get(i))) {
                exist = true;
                break;
            }
        }
        if (exist) {
            return false;
        } else {
            dalStudents.add(student);
            return true;
        }
    }

    public void removeStudent(Student student) {
        dalStudents.remove(student);
        for (int i = 0; i < dalStudents.size(); i++) {
            dalStudents.get(i).removeContact(student);
        }
    }

    public ArrayList<Student> commonContacts(Student student1, Student student2) {
        ArrayList<Student> commonStudents = new ArrayList<>();
        ArrayList<Student> contacts1 = student1.getContacts();
        ArrayList<Student> contacts2 = student2.getContacts();
        for (int i = 0; i < contacts1.size(); i++) {
            boolean common = false;
            Student c1 = contacts1.get(i);
            for (int j = 0; j < contacts2.size(); j++) {
                Student c2 = contacts2.get(j);
                if (c1.equals(c2)) {
                    common = true;
                    break;
                }
            }
            if (common) {
                commonStudents.add(c1);
            }
        }
        return commonStudents;
    }

    public int mostContacts() {
        int index = 0;
        for (int i = 1; i < dalStudents.size(); i++) {
            if (dalStudents.get(i).getNumberContacts() > dalStudents.get(index).getNumberContacts()) {
                index = i;
            }
        }
        return dalStudents.get(index).getNumberContacts();
    }

    public int numberStudentsFromProgram(String program) {
        int count = 0;
        for (int i = 0; i < dalStudents.size(); i++) {
            if (dalStudents.get(i).getProgram().equals(program)) {
                count++;
            }
        }
        return count;
    }

    public boolean validateStudentID(String id) {
        if (!id.startsWith("B00")) {
            return false;
        }
        if (id.length() != 9) {
            return false;
        }
        for (int i = 3; i < id.length(); i++) {
            if (!Character.isDigit(id.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
