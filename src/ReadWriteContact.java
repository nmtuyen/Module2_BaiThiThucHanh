import java.io.*;
import java.util.List;

public class ReadWriteContact {
    public void writeContact(String path, List<Contact> contactList) throws IOException {
        FileWriter fileWriter = new FileWriter(path);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
        String str = "Number,Group,Name,Gender,Address,DateOfBirth,Email\n";
        for (Contact contact:contactList) {
            str += contact.getNumber()+","+contact.getGroup()+","+contact.getName()+","+contact.getGender()+","+contact.getAddress()+","+contact.getDateOfBirth()+","+contact.getEmail()+"\n";
        }
        bufferedWriter.write(str);
        bufferedWriter.close();
        fileWriter.close();
    }
    public List<Contact> readFile(String pathFile) throws IOException {
        FileReader fileReader = new FileReader(pathFile);
        BufferedReader bufferedReader = new BufferedReader(fileReader);
        String line = bufferedReader.readLine();
        while ((line = bufferedReader.readLine())!= null) System.out.println(line);
        return null;
    }
}
