public class Main {
    public static void main(String[] args) {
        MyList<String> list = new MyList<>();
        list.push("q");
        list.push("w");
        list.push("e");
        list.pushTo("q", 1);
        list.put("w", 2);
        list.push("e");
        System.out.println("del:" + list.pop());
        System.out.println("del:" + list.pop(1));
        for (int i = 0; i < list.length(); i++) {
            System.out.println(list.getIndexOf(i));
        }


    }
}
