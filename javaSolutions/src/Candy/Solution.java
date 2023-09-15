package Candy;

public class Solution {

    public static class Child {
        protected int candies = 1;
        protected int rating;
        protected Child previousNeighbor;
        protected Child nextNeighbor;
        protected boolean firstChild = false;
        protected boolean lastChild = false;
    }

    public int candy(int[] ratings) {

        if(ratings.length == 1) {                        // If only one rating is given, a single candy is the solution
            return 1;
        }

        Child[] children = new Child[ratings.length];               // Array of Child with the same length as ratings[]
        for(int j = 0; j < ratings.length; j++) {
            children[j] = new Child();
        }

        int i = 0;
        for (int rating : ratings) {
            children[i].rating = rating;                                // Set ratings for each Child
            if(i == 0) {
                children[i].nextNeighbor = children[i + 1];             // Set neighbors for each Child
                children[i].firstChild = true;
            } else if (i == ratings.length - 1) {                       // Consider first and last Child separately
                children[i].previousNeighbor = children[i - 1];
                children[i].lastChild = true;
            } else {
                children[i].nextNeighbor = children[i + 1];
                children[i].previousNeighbor = children[i - 1];
            }
            i++;
        }
        int totalCandies = ratings.length;
        int addedCandies;
        do {                                                    // iterate through children[], adding necessary candies
            addedCandies = 0;
            for(Child child : children) {
                if(child.firstChild) {
                    if(child.rating > child.nextNeighbor.rating && child.candies <= child.nextNeighbor.candies) {
                            child.candies++;
                            addedCandies++;
                    }                                           // consider first child in each iteration
                } else if (child.lastChild) {
                    if(child.rating > child.previousNeighbor.rating && child.candies <= child.previousNeighbor.candies) {
                        child.candies++;
                        addedCandies++;
                    }                                           // consider last child in each iteration
                } else {
                    if(child.rating > child.nextNeighbor.rating && child.candies <= child.nextNeighbor.candies) {
                        child.candies++;
                        addedCandies++;
                    }
                    if(child.rating > child.previousNeighbor.rating && child.candies <= child.previousNeighbor.candies) {
                        child.candies++;
                        addedCandies++;
                    }
                }
            }
            totalCandies += addedCandies;
        } while(addedCandies > 0);                         // loop ends the first iteration which does not add candies

        return totalCandies;
    }

}
