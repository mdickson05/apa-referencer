import java.util.InputMismatchException;
import java.util.Scanner;

public class ReferenceMenu {
    
    private Reference reference;

    public ReferenceMenu()
    {
        reference = new Reference();
    }

    public void start()
    {
        Scanner sc = new Scanner(System.in);
        boolean exit = false;
        int opt = 0;
        
        while(!exit)
        {
            printMenu();
            try
            {
                opt = sc.nextInt();
                
            }
            catch (InputMismatchException e) 
            {
                System.out.println("Invalid input. Please enter a valid integer.");
                sc.next(); // Clears invalid scanner input
            }

            if(opt == 0)
            {
                System.out.println("Exited without saving.");
                setRef(null);
                exit = true;
            } 
            else if(opt == 7)
            {
                System.out.println("Reference saved!");
                exit = true;
            }
            else
            {
                choice(opt);
            }
            // sc.close();
        }
    }

    private void printMenu()
    {
        System.out.println("==== Add reference ====");
        System.out.println("1. Set Author");
        System.out.println("2. Set Year");
        System.out.println("3. Set Title");
        System.out.println("4. Set Publisher");
        System.out.println("5. Set Link");
        System.out.println("6. Print Reference");
        System.out.println("7. Save and quit");
        System.out.println("0. Exit (without saving)");
    }

    private void choice(int opt)
    {
        switch(opt)
        {
            case 1:
                Author author = author();
                reference.setAuthor(author.getFirstName(), author.getSurname());
                break;
            case 2:
                reference.setYear(year());
                break;
            case 3:
                reference.setTitle(title());
                break;
            case 4:
                reference.setPublisher(publisher());
                break;
            case 5:
                reference.setLink(link());
                break;
            case 6:
                System.out.println(reference.toString());
                break;
            default:
                System.out.println("Invalid input. Please try again.");
                break;
        }
        // System.out.println("Test.");
    }

    private Author author()
    {
        Author author = new Author();
        Scanner sc = new Scanner(System.in);
        String firstName, lastName;
        
        System.out.print("Please enter author's first name: ");
        try
        {
            firstName = sc.next();
            System.out.print("Please enter author's surname: ");
            lastName = sc.next();

            author.setName(firstName, lastName);
        }
        catch (InputMismatchException e) 
        {
            System.out.println("Invalid input. Please enter a valid string.");
            sc.next(); // Clears invalid scanner input
        }
        System.out.println("Author is: " + author.toString());

        return author;
    }

    private String title()
    {
        String title = "";
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please enter title: ");
        
        try
        {
            title = sc.nextLine();
        }
        catch (InputMismatchException e) 
        {
            System.out.println("Invalid input. Please enter a valid string.");
            sc.next(); // Clears invalid scanner input
        }
        System.out.println("Title is: " + title);
        return title;
    }

    private String publisher()
    {
        String publisher = "";
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please enter publisher: ");
        
        try
        {
            publisher = sc.nextLine();
        }
        catch (InputMismatchException e) 
        {
            System.out.println("Invalid input. Please enter a valid string.");
            sc.next(); // Clears invalid scanner input
        }
        System.out.println("Publisher is: " + publisher);

        return publisher;
    }

    private String link()
    {
        String link = "";
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please enter link: ");
        
        try
        {
            link = sc.nextLine();
        }
        catch (InputMismatchException e) 
        {
            System.out.println("Invalid input. Please enter a valid string.");
            sc.next(); // Clears invalid scanner input
        }
        System.out.println("Link is: " + link);
        return link;
    }

    private int year()
    {
        int year = 0000;
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Please enter year: ");
        
        try
        {
            year = sc.nextInt();
        }
        catch (InputMismatchException e) 
        {
            System.out.println("Invalid input. Please enter a valid integer.");
            sc.next(); // Clears invalid scanner input
        }
        System.out.println("Year is: " + year);
        return year;
    }

    public Reference getRef()
    {
        return reference;
    }

    public void setRef(Reference inRef)
    {
        this.reference = inRef;
    }
}
