public class DogWalker
{
    /**
     * The maximum number of dogs this walker can walk simultaneously
     * per hour
     */
    private int maxDogs;
    /** The dog-walking company this dog walker is associated with */
    private DogWalkCompany company;


    /**
     * Assigns max to maxDogs and comp to company
     * Precondition: max > 0
     */
    public DogWalker(int max, DogWalkCompany comp)
    {
        maxDogs = max;
        company = comp;
    }
    public int walkDogs(int hour)
    {
        int dogs = company.numAvailableDogs(hour);
        if (dogs < maxDogs)
        {
            company.updateDogs(hour, dogs);
            return dogs;
        }
        else
        {
            company.updateDogs(hour, maxDogs);
            return maxDogs;
        }
    }
    public int dogWalkShift(int startHour, int endHour)
    {
        int pay = 0;
        while(startHour <= endHour)
        {
            int dogs = walkDogs(startHour);
            pay += dogs * 5;
            if (dogs == maxDogs || startHour >= 9 && startHour <= 17)
                pay += 3;
            startHour++;
        }
        return pay;
    }
}
