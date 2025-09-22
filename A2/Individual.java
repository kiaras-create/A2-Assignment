import java.util.ArrayList;
import java.util.Random;

public class Individual {

    // Attributes
    /**
     * Chromosome stores the individual's genetic data as an ArrayList of characters
     * Each character represents a gene
     */
    ArrayList<Character> chromosome;

    /**
     * stores the size of the individual's ArrayList, which represents its genetic data
     */
    int size;


    // TESTED, IT WORKS! 
    /**
     * Inital constructor to generate initial population members
     * @param c_0 The initial chromosome size
     * @param num_letters The number of letters available to choose from
     * @param rng Seed for random number generator
     */
    public Individual(int c_0, int num_letters, Random rng) {
        // initializes chromosome ArrayList to initial size of c_0
        this.chromosome = new ArrayList<>(c_0);
        // adds random characters, meant to represent "genes", to chromosome ArrayList
        for (int i = 0; i < c_0; i++) {
            chromosome.add(randomLetter(num_letters, rng));
        }
        // gets size of chromosome ArrayList and stores in size attribute
        this.size = chromosome.size();
    }


    /**
     * Second constructor to create parents and offspring chromosomes
     * @param parent1 The first parent chromosome
     * @param parent2 The second parent chromosome
     * @param c_max The maximum chromosome size
     * @param m The chances per round of mutation in each gene
     */
    public Individual(Individual parent1, Individual parent2, int c_max, float m, int num_letters, Random rng) {
    }


    /**
     * Provided method to choose a letter at random, in the range from A to the number of states indicated
     * @param num_letters The number of letters available to choose from (number of possible states)
     * @param rng The random number generator being used for the current run
     * @return The letter as a Character
     */
    private Character randomLetter(int num_letters, Random rng) {
        return Character.valueOf((char)(65 + rng.nextInt(num_letters)));
    }


    /**
     * Provided method to determine whether a given gene will mutate based on the parameter ***m***
     * @param m the mutation rate
     * @param rng The random number generator being used for the current run
     * @return true if a number randomly chosen between 0 and 1 is less than ***m***, else false
     */
    private Boolean doesMutate(float m, Random rng) {
        float randomNum = rng.nextInt(100) / 100f;
        return randomNum < m;
    }
    

    /**
     * Expresses the individual's chromosome as a String, for display purposes
     * @return The chromosome as a String
     */
    public String toString() {
        StringBuilder builder = new StringBuilder(chromosome.size());
        for(Character ch: chromosome) {
            builder.append(ch);
        }
        return builder.toString();
    }




    public static void main(String[] args) {
        // This code will set a random seed when you're testing Individual (i.e., running it without GA_Simulation)
        Random rng = new Random(System.currentTimeMillis());

        // You can pass rng, as defined above, to your constructors.
        Individual i = new Individual(8, 4, rng);

        // TO TEST
        // Individual ii = new Individual(8, 5, rng);
        // System.out.println("This is individual i's chromosome: " + i.toString());
        // System.out.println("This is individual ii's chromosome: " + ii.toString());

    }

}
