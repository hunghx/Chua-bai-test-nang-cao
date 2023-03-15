package navbar;

import model.Student;

import java.util.Scanner;

public class Navbar {

    public static void main(String[] args) {
        Student[] listStudents = new Student[100];
        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.println("***************STUDENT MANAGE***************************\n" +
                    "1. Show List Student. [20 điểm]\n" +
                    "2. Create Student [30 điểm]\n" +
                    "3. Update Student [20 điểm]\n" +
                    "4. Delete Student [10 điểm]\n" +
                    "5. Sort Student By Age ASC (Tăng Dần). [15 điểm]\n" +
                    "6. Exit [05 điểm]");
            System.out.println("Hãy nhập lựa chọn 1-6:");
            int choice = Integer.parseInt(input.nextLine());
            switch (choice) {
                case 1:
                    displayListStudents(listStudents);
                    break;
                case 2:
                    createNewStudent(listStudents, input);
                    break;
                case 3:
                    displayListStudents(listStudents);
                    System.out.println("Nhập vào id muốn sửa");
                    int idEdit = Integer.parseInt(input.nextLine());
                    updateStudent(listStudents, idEdit, input);
                    break;
                case 4:
                    System.out.println("Nhập vào id cần xoá");
                    int idDelete = Integer.parseInt(input.nextLine());
                    deleteStudent(listStudents, idDelete);
                    break;
                case 5:
                    sortByAge(listStudents);
                    break;
                case 6:
                    System.exit(0);
                    break;
                default:
                    System.err.println("Nhập không hợp lệ , vui lòng thử lại");
                    break;
            }


        }
    }

    // hiển thị danh sách sinh viên
    public static void displayListStudents(Student[] list) {
        boolean checkNull= false;
        for (Student std : list) {
            if (std != null) {
                checkNull = true;
                System.out.println(std.toString());
            }
        }
        if (!checkNull) {
            System.out.println("Không có sinh viên nào cả , thêm mới đi !");
        }
        // code
    }

    // tạo mới 1 sinh viên
    public static void createNewStudent(Student[] list, Scanner sc) {
        Student newStudent = inputData(sc);
        boolean check = false;
        boolean checkNull= false;
        int idMax = 0;
        for (Student st : list) {
            if(st!=null){
                checkNull =true;
                if(idMax<st.getStudentId()){
                    idMax = st.getStudentId();
                }
            }
        }
        if (checkNull) {
            newStudent.setStudentId(idMax+1);
        }
        else {
            newStudent.setStudentId(1);
        }
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) {
                list[i] = newStudent;
                check = true;
                break;
            }
        }
        if (check) {
            System.out.println("thêm mới thành công");
        } else {
            System.err.println("Danh sách sinh viên đã đầy");
        }
    }

    // sửa thông tin sinh viên theo id
    public static void updateStudent(Student[] list, int idEdit, Scanner sc) {
        boolean check = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                if (list[i].getStudentId() == idEdit) {
                    System.out.println("Nhập tên mới :");
                    list[i].setStudentName(sc.nextLine());
                    System.out.println("Nhập tuổi :");
                    list[i].setAge(Integer.parseInt(sc.nextLine()));
                    check = true;
                    break;
                }
            }
        }
        if (check) {
            System.out.println("cập nhật thành công");
        } else {
            System.err.println("Khồng tồn tại id cần sửa");
        }
    }

    // xoá sinh viên theo id
    public static void deleteStudent(Student[] list, int idDelete) {
        boolean check = false;
        for (int i = 0; i < list.length; i++) {
            if (list[i] != null) {
                if (list[i].getStudentId() == idDelete) {
                    check = true;
                    list[i] = null;
                }
            }
        }
        if (check) {
            System.out.println("xoá thành công");
        }else {
            System.err.println("Không tồn tại id cần xoá");
        }
    }

    // sắp xếp sinh viên theo tuổi
    public static void sortByAge(Student[] list) {
        for (int i = 0; i < list.length-1 ; i++) {
            for (int j = i+1; j < list.length ; j++) {
                if(list[i]!= null && list[j]!=null){
                    if(list[i].getAge()> list[j].getAge()){
                        Student temp = list[i];
                        list[i] = list[j];
                        list[j] = temp;
                    }
                }
            }

        }
        System.out.println("Mảng đã được sắp xếp");
    }

    public static Student inputData(Scanner sc) {
        Student st = new Student();
        // nhập các thông tin cho đối tượng vừa tạo
//
//        System.out.println("Nhập id cho sinh viên");
//        st.setStudentId(Integer.parseInt(sc.nextLine()));
        System.out.println("nhập vào tên sinh viên");
        st.setStudentName(sc.nextLine());
        System.out.println("Nhập tuổi cho sinh viên");
        st.setAge(Integer.parseInt(sc.nextLine()));
        return st;
    }
}
