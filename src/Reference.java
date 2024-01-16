public class Reference {
    private Author author;
    private int year;
    private String title;
    private String publisher;
    private String link;

    public Reference()
    {
        this.author = new Author();
        this.title = "";
        this.publisher = "";
        this.link = "";
        this.year = 0000;
    }
    
    public String getAuthor()
    {
        return author.abbreviate();
    }

    public String getAuthorSurname()
    {
        return author.getSurname();
    }
    
    public String getTitle()
    {
        return title;
    }
    
    public String getPublisher()
    {
        return publisher;
    }
    
    public String getLink()
    {
        return link;
    }

    public int getYear()
    {
        return year;
    }

    public void setAuthor(String inFirst, String inLast)
    {
        this.author.setName(inFirst, inLast);
    }

    
    public void setTitle(String inTitle)
    {
        this.title = inTitle;
    }

    public void setPublisher(String inPublisher)
    {
        this.publisher = inPublisher;
    }
    
    public void setLink(String inLink)
    {
        this.link = inLink;
    }

    public void setYear(int inYear)
    {
        this.year = inYear;
    }

    public String toString()
    {
        String reference = "";
        
        if(link != "")
        {
            reference = author.abbreviate() + " (" + year + "). " + title + ". " + publisher + ". Accessed from " + link;
        } 
        
        else 
        {
            reference = author.abbreviate() + " (" + year + "). " + title + ". " + publisher + ".";
        }
        
        return reference;
    }
}
