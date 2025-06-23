// Base class: Person
class Person {
    String name;
    int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void displayPerson() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Derived class: Researcher
class Researcher extends Person {
    String field;
    String institution;

    public Researcher(String name, int age, String field, String institution) {
        super(name, age);
        this.field = field;
        this.institution = institution;
    }

    public void displayResearcher() {
        displayPerson();
        System.out.println("Field: " + field);
        System.out.println("Institution: " + institution);
    }
}

// Derived class: DataScientist
class DataScientist extends Researcher {
    String programmingLanguage;
    int yearsOfExperience;

    public DataScientist(String name, int age, String field, String institution,
                         String programmingLanguage, int yearsOfExperience) {
        super(name, age, field, institution);
        this.programmingLanguage = programmingLanguage;
        this.yearsOfExperience = yearsOfExperience;
    }

    public void displayDataScientist() {
        displayResearcher();
        System.out.println("Programming Language: " + programmingLanguage);
        System.out.println("Years of Experience: " + yearsOfExperience);
    }
}

// Main class
public class Main {
    public static void main(String[] args) {
        // Create Researcher object
        Researcher researcher = new Researcher("Alice", 35, "Biology", "University of the Philippines");
        System.out.println("RESEARCHER DETAILS:");
        researcher.displayResearcher();

        System.out.println();

        // Create DataScientist object
        DataScientist dataScientist = new DataScientist("Bob", 29, "AI & Data Science", "DOST", "Python", 5);
        System.out.println("DATA SCIENTIST DETAILS:");
        dataScientist.displayDataScientist();
    }
}