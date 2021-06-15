import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.swing.plaf.synth.SynthOptionPaneUI;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static String LIST_CONTACT = "C:\\Users\\KiThuat 88\\IdeaProjects\\Module2_BaiThiThucHanh\\contacts.csv";

    public static void main(String[] args) throws IOException {
        ReadWriteContact readWriteContact = new ReadWriteContact();
        ContactManage contactManage = new ContactManage();
        while (true){
            Scanner scanner = new Scanner(System.in);
            menu();
            System.out.println("Nhập lựa chọn");
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice){
                case 1:
                    contactManage.display();
                    break;
                case 2:
                    contactManage.add();
                    break;
                case 3:
                    System.out.println("Nhập số điện thoại cần sửa");
                    String number = scanner.nextLine();
                    contactManage.edit(number);
                    break;
                case 4:
                    System.out.println("Nhập số điện thoại cần xóa");
                    String number1 = scanner.nextLine();
                    contactManage.delete(number1);
                case 5:
                    System.out.println("Chọn cách tìm kiếm: 1. Tìm theo tên   2.Tìm theo số điện thoại");
                    int choice1 = scanner.nextInt();
                    switch (choice1){
                        case 1:
                            String name = scanner.nextLine();
                            contactManage.findByName(name);
                            break;
                        case 2:
                            String phoneNumber = scanner.nextLine();
                            contactManage.findByNum(phoneNumber);
                            break;
                        default:
                            System.out.println("Nhập lại");
                    }
                case 6:
                    System.out.println("Nếu đọc sẽ xóa toàn bộ danh bạ: 1.Xác nhận xóa");
                    int choice2 = scanner.nextInt();
                    scanner.nextLine();
                    switch (choice2){
                        case 1:
                            readWriteContact.readFile(LIST_CONTACT);
                            break;
                        default:
                    }
                    break;
                case 7:
                    readWriteContact.writeContact(LIST_CONTACT, contactManage.contactList);
                    break;
                case 8:
                    System.exit(0);
            }
        }
    }
    public static void menu(){
        System.out.println("-----CHƯƠNG TRÌNH QUẢN LÝ DANH BẠ-----");
        System.out.println("Chọn chức năng theo số (để tiếp tục): ");
        System.out.println("1. Xem danh sách");
        System.out.println("2. Thêm mới");
        System.out.println("3. Cập nhật");
        System.out.println("4. Xóa");
        System.out.println("5. Tìm kiếm");
        System.out.println("6. Đọc từ file");
        System.out.println("7. Ghi dữ liệu vào file");
        System.out.println("8. Thoát");
        System.out.println("Chọn chức năng");
    }
}
