import java.util.LinkedList;

public class Sort
{
    public static LinkedList<Reference> sortList(LinkedList<Reference> list)
    {
        return mergeSort(list);
    }

    private static LinkedList<Reference> mergeSort(LinkedList<Reference> list) 
    {
        
        if (list == null || list.size() <= 1) 
        {
            return list; // Already sorted
        }

        int middle = list.size() / 2;
        
        LinkedList<Reference> left = new LinkedList<>(list.subList(0, middle));
        LinkedList<Reference> right = new LinkedList<>(list.subList(middle, list.size()));

        left = mergeSort(left);
        right = mergeSort(right);

        return merge(left, right);
    }

    private static LinkedList<Reference> merge(LinkedList<Reference> left, LinkedList<Reference> right) 
    {
        LinkedList<Reference> result = new LinkedList<>();
        int leftIndex = 0;
        int rightIndex = 0;

        while (leftIndex < left.size() && rightIndex < right.size()) 
        {
            Reference leftRef = left.get(leftIndex);
            Reference rightRef = right.get(rightIndex);

            // Compare based on the author names (you may need to modify this based on your needs)
            if (leftRef.getAuthorSurname().compareTo(rightRef.getAuthorSurname()) < 0) 
            {
                result.add(leftRef);
                leftIndex++;
            } 
            
            else 
            {
                result.add(rightRef);
                rightIndex++;
            }
        }

        // Add remaining elements from both lists (if any)
        result.addAll(left.subList(leftIndex, left.size()));
        result.addAll(right.subList(rightIndex, right.size()));

        return result;
    }

}