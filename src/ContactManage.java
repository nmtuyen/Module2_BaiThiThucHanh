import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactManage {
    List<Contact> contactList;

    public ContactManage(List<Contact> contactList) {
        this.contactList = contactList;
    }

    public ContactManage() {
        contactList = new ArrayList<>();
        contactList.add(new Contact("0123456789", "family", "tuyen", "Nữ", "HN", "12/10/1975", "abc@gmail.com"));
        contactList.add(new Contact("0123465465", "it", "chuong", "Nữ", "HN", "12/10/1975", "abc@gmail.com"));
        contactList.add(new Contact("0123546545", "family", "thanh", "Nữ", "HN", "12/10/1975", "abc@gmail.com"));
    }

    public void display(){
        if (contactList.size() == 0){
            System.out.println("Danh bạ rỗng");
        }else {
            for (Contact contact:contactList) {
                System.out.println(contact);
            }
            System.out.println("----------------------------------");
        }
    }
    public Contact input(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập thông tin liên lạc cần thêm vào danh bạ");
        System.out.print("Nhập số điện thoại(vd: 0123456789");
        String number;
        do {
            number = scanner.nextLine();
            if ((!Validate.validate(number, Validate.PHONE_NUMBER_REGEX) || number == null)){
                System.out.println("Sai định dạng, nhập lại");
            }
        }while ((!Validate.validate(number, Validate.PHONE_NUMBER_REGEX) || number == null));
        System.out.print("Nhập nhóm");
        String group = scanner.nextLine();
        System.out.print("Nhập tên ");
        String name = scanner.nextLine();
        System.out.print("Nhập giới tính");
        String gender = scanner.nextLine();
        System.out.print("Nhập địa chỉ");
        String address = scanner.nextLine();
        System.out.print("Nhập ngày sinh");
        String dateOfBirth = scanner.nextLine();
        System.out.print("Nhập email(vd: ten.ho@gmail.com");
        String email;
        do {
            email = scanner.nextLine();
            if ((!Validate.validate(email, Validate.EMAIL_REGEX)|| email == null)){
                System.out.println("Sai định dạng, nhập lại");
            }
        }while ((!Validate.validate(email, Validate.EMAIL_REGEX)|| email == null));
        return new Contact(number,group,name,gender,address,dateOfBirth,email);
    }
    public void add(){
        contactList.add(input());
        System.out.println("Đã thêm");
    }
    public int check(String number){
        for (int i = 0; i < contactList.size(); i++){
            if (contactList.get(i).getNumber().equals(number)){
                return i;
            }
        }
        return -1;
    }
    public void edit(String number){
        int index = check(number);
        if (index == -1){
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
        }else{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Nhập thông tin cần sửa:"+"\n" + "1.Sửa số đt  2.Sửa tên  3.Sửa nhóm  4.Sửa giới tính  5.Sửa địa chỉ  6.Sửa ngày sinh  7.Sửa email");
            int choice = scanner.nextInt();
            switch (choice){
                case 1:
                    System.out.print("Nhập số điện thoại: ");
                    String phoneNumber = scanner.nextLine();
                    contactList.get(index).setNumber(phoneNumber);
                    break;
                case 2:
                    System.out.print("Nhập tên: ");
                    String name = scanner.nextLine();
                    contactList.get(index).setName(name);
                    break;
                case 3:
                    System.out.print("Nhập nhóm: ");
                    String group = scanner.nextLine();
                    contactList.get(index).setGroup(group);
                    break;
                case 4:
                    System.out.print("Nhập giới tính: ");
                    String gender = scanner.nextLine();
                    contactList.get(index).setGender(gender);
                    break;
                case 5:
                    System.out.print("Nhập địa chỉ: ");
                    String address = scanner.nextLine();
                    contactList.get(index).setAddress(address);
                    break;
                case 6:
                    System.out.print("Nhập ngày sinh: ");
                    String dateOfBirth = scanner.nextLine();
                    contactList.get(index).setDateOfBirth(dateOfBirth);
                    break;
                case 7:
                    System.out.print("Nhập email: ");
                    String email = scanner.nextLine();
                    contactList.get(index).setEmail(email);
                    break;
                default:
                    System.out.println("Nhập lại");
            }
        }
    }
    public void delete(String number){
        int index = check(number);
        if (index == -1){
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
        }else{
            System.out.println("Xác nhận xóa: Y.Xóa ");
            Scanner scanner = new Scanner(System.in);
            String choice = scanner.nextLine();
            switch (choice){
                case "y":
                    contactList.remove(index);
                    System.out.println("Đã xóa");
                    break;
                default:
                    break;
            }
        }
    }
    public int checkNumber(String number){
        for (int i = 0; i < contactList.size(); i++){
            if (contactList.get(i).getNumber().contains(number)){
                return i;
            }
        }return -1;
    }
    public Contact findByNum(String number){
        int index = check(number);
        if (index == -1){
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
            return null;
        }
        return contactList.get(index);
    }
    public int checkName(String name){
        for (int i = 0; i < contactList.size(); i++){
            if (contactList.get(i).getName().contains(name)){
                return i;
            }
        }return -1;
    }

    public Contact findByName(String name){
        int index = check(name);
        if (index == -1){
            System.out.println("Không tìm được danh bạ với số điện thoại trên");
            return null;
        }
        return contactList.get(index);
    }


}
