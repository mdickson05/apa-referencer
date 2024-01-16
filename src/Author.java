public class Author {

    private String firstName;
    private String surname;
    private String name;

    public Author()
    {
        this.firstName = "";
        this.surname = "";
        this.name = "";
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getSurname()
    {
        return surname;
    }
    
    public String getName()
    {
        return name;
    }

    public void setFirstName(String inName)
    {
        this.firstName = inName;
    }

    public void setSurname(String inSurname)
    {
        this.surname = inSurname;
    }

    public void setName(String inFirst, String inLast)
    {
        this.firstName = inFirst;
        this.surname = inLast;
        this.name = inFirst + " " + inLast;
    }

    public String abbreviate()
    {
       String author = surname + ", " + getFirstName().charAt(0) + ".";
       return author; 
    }

    public String toString()
    {
        return getName();
    }
    
}
