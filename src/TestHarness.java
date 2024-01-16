public class TestHarness
{        
    public static void main(String[] args)
    {
        Reference ref1 = new Reference();
        Reference ref2 = new Reference();
        Reference ref3 = new Reference();

        Menu test = new Menu();

        ref1.setAuthor("Sun", "Tzu");
        ref1.setTitle("The Art of War");
        ref1.setYear(2010);
        ref1.setPublisher("Capstone Publishing");

        test.addRefToList(ref1);

        ref2.setAuthor("Robert", "Greene");
        ref2.setTitle("48 Laws of Power");
        ref2.setYear(2000);
        ref2.setPublisher("Penguin Publishers");

        test.addRefToList(ref2); // should test alphabetical sorting
        
        test.showList();

        ref3.setAuthor("John", "McAfee"); // for the memes
        ref3.setTitle("John McAfee: Introduction To My True Life Story");
        ref3.setYear(2015);
        ref3.setPublisher("Cyber Crime Magazine");
        ref3.setLink("https://cybersecurityventures.com/john-mcafee-introduction-" +
        "to-my-true-life-story/");
        
        test.addRefToList(ref3); // testing links

        test.showList();

        test.deleteRefFromList(ref2.getTitle()); // specifically deleting ref2 to test the for loop

        test.showList();

        test.writeList(); // testing export functionality.
    }
}