/**
 ����* Rectangle database
 */

/**
 * The class containing the main method.
 * 
 * @author Haosu Wang/whaosu
 * @author Lihui Zhang/lihuiz
 * @version 1.0
 */

// On my honor:
//
// - I have not used source code obtained from another student,
// or any other unauthorized source, either modified or
// unmodified.
//
// - All source code and documentation used in my program is
// either my original work, or was derived by me from the
// source code published in the textbook for this course.
//
// - I have not discussed coding details about this project with
// anyone other than my partner (in the case of a joint
// submission), instructor, ACM/UPE tutors or the TAs assigned
// to this course. I understand that I may discuss the concepts
// of this program with other students, and that another student
// may help me debug my program so long as neither of us writes
// anything during the discussion or modifies any computer file
// during the discussion. I have violated neither the spirit nor
// letter of this restriction.

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class RectangleDB {
    /**
     * @param args
     *     Command line parameters
     * @throws FileNotFoundException 
     */
    public static void main(String[] args) throws FileNotFoundException {

        // scanner object to parse the command file
        Scanner sc;

        try {
            sc = new Scanner(new File(args[0]));
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            return;
        }
        //create a new binary search tree
        BST<Rectangle, String> bst = new BST<Rectangle, String>();
        //A handler object to channel commands to the BST object.
        CommandParser requestHandler = new CommandParser();

        while (sc.hasNext()) {
            String cmd = sc.next();

            if (cmd.equals("dump")) {
                requestHandler.dump(bst);
            }
            /*else if (cmd.equals("intersections")) {
                requestHandler.intersections();
            }
            else if (cmd.equals("regionsearch")) {
                requestHandler.regionsearch(sc.nextLine());
            }*/
            else if (cmd.equals("remove")) {
                requestHandler.remove(bst, sc.nextLine());
            }
            else if (cmd.equals("insert")) {
                requestHandler.insert(bst, sc.next(), sc.nextLine());
            }
            else {
                System.out.println("Unrecognized input: |" + cmd + "|");
            }
        }

        // done with the scanner object
        sc.close();
    }
}
