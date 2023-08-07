public class Main {
    public static void main(String[] args) {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Вольф")
                .setAge(30)
                .setAddress("Сидней")
                .build();

        mom.happyBirthday();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();

        son.happyBirthday();

        System.out.println("У " + mom + " есть сын, " + son);

        try {
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}