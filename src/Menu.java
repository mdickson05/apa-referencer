import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Scanner;


public class Menu {
    
    private LinkedList<Reference> references;

    public Menu()
    {
        this.references = new LinkedList<Reference>();
    }

    public LinkedList<Reference> getReferences()
    {
        return references;
    }

    public void setReferences(LinkedList<Reference> inRefs)
    {
        this.references = inRefs;
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
                System.out.println("Goodbye!");
                exit = true;
            } 
            else
            {
                choice(opt);
            }
        }
    }
    
    private void choice(int opt)
    {
        switch(opt)
        {
            case 1:
                addRef();
                break;
            case 2:
                deleteRef();
                break;
            case 3:
                printList();
                break;
            case 4:
                writeListToFile();
                break;
            default:
                System.out.println("Invalid input. Please try again.");
        }
    }

    private void deleteRef() // reformatted with two methods so that I could test more efficiently.
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please enter the title of the reference you would like to delete: ");
        try
        {
            String title = sc.nextLine();
            deleteRef(title);
        }
        catch(InputMismatchException e)
        {
            e.printStackTrace();
        }
    }

    private void printMenu()
    {
        System.out.println("Welcome to APA Referencer.");
        System.out.println("1. Add reference");
        System.out.println("2. Delete reference");
        System.out.println("3. Print references");
        System.out.println("4. Export references to .txt");
        System.out.println("0. Exit");
    }

    private void addRef()
    {
        ReferenceMenu refMenu = new ReferenceMenu();
        refMenu.start();
        
        if(refMenu.getRef() != null)
        {
            Reference newRef = refMenu.getRef();
            addRefToList(newRef);
        }
    }

    public void deleteRefFromList(String title) // made solely for testing purposes
    {
        deleteRef(title);
    }
    
    private void deleteRef(String title) 
    {
        LinkedList<Reference> references = getReferences();
        boolean found = false;
    
        for (int i = 0; i < references.size() && !found; i++) 
        {
            Reference ref = references.get(i);
    
            if (ref.getTitle().equals(title)) 
            {
                references.remove(i);
                System.out.println("Reference removed!");
                found = true;
            }
        }
    }
    
    public void addRefToList(Reference inRef) // just for encapsulation purposes.
    {
        references.add(inRef); 
    }

    public void showList() // wrapper method solely for test harness.
    {
        printList();
    }
    
    private void printList()
    {
        LinkedList<Reference> refs = Sort.sortList(getReferences()); // made my own mergeSort function :)
        setReferences(refs);
        
        System.out.println("References: ");
        for(Reference reference : refs)
        {
            System.out.println(reference.toString());
        }
    }

    public void writeList() // wrapper method for test harness
    {
        writeListToFile();
    }
    
    private void writeListToFile()
    {
        String fileName = "output/references.txt";
        
        LinkedList<Reference> refs = Sort.sortList(getReferences());
        // Collections.sort(refs);
        setReferences(refs);
        
        try 
        {
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            PrintWriter printWriter = new PrintWriter(bufferedWriter);

            printWriter.println("References: ");
            for(Reference reference : refs)
            {
                printWriter.println(reference.toString());
            }

            System.out.println("Output has been written to " + fileName);

            printWriter.close();

        } 
        
        catch (IOException e) 
        {
            e.printStackTrace();
        }

    }

}
