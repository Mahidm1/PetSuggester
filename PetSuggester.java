import java.util.Scanner;

class PetSuggester{
    // This is a method to ask the user yes or no questions
    public static boolean askYesNo(String question) {
        Scanner kbd = new Scanner(System.in);
        System.out.println(question + "[y/n]");
        String answer = kbd.nextLine();
        if (answer.equals("y") || answer.equals("Y")) {
            return true;
        }
        else {
            return false;
        } 
    }

    public static void main(String[] args) {
        // These are the questions that get allocated to the value node
        TreeNode root = new TreeNode("Do you like dogs?",
        new TreeNode("Do you prefer big dogs?", new TreeNode("A golden retriever"), new TreeNode("A Chihuahua")),
        new TreeNode ("an iguana"));
        boolean play_again = true;
        Scanner kbd = new Scanner(System.in);
        
        // This while loop repeats the game until the user is satisfied
        do {
            // This starts from the root node
            TreeNode current = root;
            // This goes through the questions until a leaf node is reached
            while (!current.isLeaf()) {
                if (askYesNo(current.getValue())) {
                    // if the answer is "yes", move to the left child node
                    current = current.getLeft();
                } else {
                    // if the answer is "no", move to the right child node
                    current = current.getRight();
                }
            }
            // This displays the pet suggestion to the user
            System.out.println("You may like " + current.getValue() + ".");
            // This asks the user if the suggestion was satisfactory
            if(!askYesNo("Is this satisfactory?")){
                // This asks the user for a preferred pet if the suggestion wasn't satisfactory
                System.out.println("What would you prefer instead?");
                String pet_preferred = kbd.nextLine();
                // This asks the user for a question to distinguish the preferred pet from the previous suggestion
                System.out.println("Tell me a question that distinguishes " + pet_preferred + " from " + current.getValue() + ".");
                String question = kbd.nextLine();
                // This creates a new leaf node for the preferred pet
                TreeNode new_leaf = new TreeNode(pet_preferred);
                TreeNode old_leaf = current;
                // This replaces the previous leaf node with the new leaf node
                current.setValue(question);
                current.setLeft(new_leaf);
                current.setRight(old_leaf);
            }
            // This asks the user if they want to play again
            System.out.println("Do you want to play again? [y/n]");
            play_again = kbd.nextLine().equals("y");
        } while (play_again);
    }
}
