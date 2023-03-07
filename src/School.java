import java.util.ArrayList;

public class School {

    private ArrayList<Student> list = new ArrayList<>();

    public String listStudent(String name, int phone, int group) {

        Student st = new Student(name, phone, group);
        list.add(st);
        return "Ученик добавлен. ";

    }

    public String delFromList(String name, int phone) {
        boolean result = false;
        for (Student st : list) {
            if (st.getName().equals(name) && st.getPhone() == phone) {
                list.remove(st);
                result = true;
                break;
            }
        }
        if (result) {
            return "Ученик удален из списка! ";
        } else {
            return "Ученик не обнаружен. ";
        }

    }

    public ArrayList getList(int groupNumber) {
        String res = null;
       ArrayList stud = new ArrayList();
        for (Student st : list) {
            if (st.getGroup() == groupNumber) {
                res = "\n" + st.getName() + " " + st.getPhone();

            }
           stud.add(res);
        }
        return (stud);
    }

        public String editStudent(String name, int phone, int group){
            for (Student st : list) {
                if (st.getName().equals(name)) {
                    st.setName(name);
                    st.setPhone(phone);
                    st.setGroup(group);
                    break;
                }

            }
            return ("Информация обновлена. ");
        }
    }
