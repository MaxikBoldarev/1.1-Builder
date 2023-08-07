import java.util.OptionalInt;

public class Person {
    private final String name;
    private final String surname;
    private OptionalInt age;
    private String address;


    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public Person(String name, String surname, int age) {
        this.name = name;
        this.surname = surname;
        this.age = OptionalInt.of(age);
    }

    public boolean hasAge() {
        return age != null;
    }

    public boolean hasAddress() {
        return address != null || !address.trim().isEmpty();
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age = OptionalInt.of(age.getAsInt() + 1);
        }
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("Имя ").append(name)
                .append(", Фамилия ").append(surname)
                .append(", Возраст ").append(age)
                .append(", Адрес ").append(address);
        return builder.toString();
    }

    @Override
    public int hashCode() {
        int i = name.hashCode() * surname.hashCode() * age.getAsInt();
        return i;
    }

    public PersonBuilder newChildBuilder() {
        return new PersonBuilder()
                .setName(this.name)
                .setSurname(this.surname)
                .setAge(1)
                .setAddress(this.address);
    }
}
