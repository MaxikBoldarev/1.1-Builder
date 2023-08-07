
public class PersonBuilder {
    protected String name;
    protected String surname;
    protected int age;
    protected String address;

    public PersonBuilder setName(String name) {
        this.name = name;
        return this;
    }

    public PersonBuilder setSurname(String surname) {
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        this.address = address;
        return this;
    }

    public Person build() {
        Person person = new Person(name, surname, age);
        if (person.getName() == null || person.getName().trim().isEmpty()) {
            throw new IllegalStateException("Exception: недостаточное кол-во данных");
        }
        if (person.getAge() == null) {
            person.setAddress(this.address);
            return person;
        }
        if (person.getAge().getAsInt() < 0) {
            throw new IllegalArgumentException("Exception: некорректный возраст");
        } else {
            person.setAddress(this.address);
            return person;
        }
    }
}