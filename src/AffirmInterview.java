
import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class AffirmInterview {
    /*
tl;dr - 1. Implement methods to grow a decision tree incrementally.
2. Use these methods to construct a given decision tree.
3. Evaluate this decision tree over multiple sets of signals.

A decision tree is a data structure that can be evaluated on a set of signals and return a decision (e.g. Yes or No ("Y" or "N")). Each interior node of the tree is associated with a particular signal and a constant value against which to compare that signal, and each leaf node has a value which will be returned by the tree. To evaluate the tree on a set of signals we traverse the tree, starting at the root and comparing the appropriate signal value to the constant associated with each interior node. If the signal value is less than the constant we proceed down the left subtree and if it is greater than or equal to the constant we proceed down the right subtree. We continue until we reach a leaf at which point we return the value associated with the leaf.

For example, suppose that we have a set of integer-valued signals {X1, X2, X3}. Consider the following decision tree:

           X1 < 3
        ------------
       |            |
    X2 < 1       X1 < 6
 -----------    ---------
|           |  |         |
N           Y  N      X3 < 2
                    ----------
                   |          |
                   Y          N
If we evaluate this tree on signals {X1: 2, X2: 1, X3: 11} the result will be Y. Evaluating on signals {X1: 8, X2: 4, X3: 12} we get N. We can use these to implement decisions that need to be made repeatedly on different input values. For instance, a given decision tree might represent a rule to decide whether or not a given transaction looks fraudulent, and the signals could represent different quantities like X1) the age of the account in days, X2) the dollar value of the transaction, and X3) the time in hours since the last transaction attempt.

In real life, we would probably grow a decision tree via some machine learning algorithm. In this exercise, however, we will manually create the tree that we want. We can grow a decision tree by starting with a single-leaf tree and recursively splitting the leaves of the tree. We do this by associating a split condition to a node, creating two new leaves below it, and associating a return value to each of those leaves.

So to grow the tree above we start with a single-leaf tree:

Y

Then add the split condition X1 < 3 and (optionally) assign return values to the new leaves:

     X1 < 3
  ------------
 |            |
 Y            N

Then add a split condition to the left leaf:

           X1 < 3
        ------------
       |            |
    X2 < 1          N
 -----------
|           |
X           X

Assign return values to the new leaves:

           X1 < 3
        ------------
       |            |
    X2 < 1          N
 -----------
|           |
N           Y


And so on until we are done.

The goal of this question is to implement a decision tree that can be grown incrementally in this fashion and evaluated on a particular set of signals. Concretely you should implement the following pseudocode API in the language of your choice:

```
class DecisionTree:

  method add_split(leaf, signal_name, constant):
    Add a split condition to the given leaf node.
    Return the newly created leaves for future calls.

  method set_leaf_value(leaf, value):
    Set the return value for a leaf node.

  method evaluate(signals):
    Evaluate the tree on a mapping of signal_name -> signal_value.
    Return the value of the leaf node reached by traversing the tree.
```

Afterwards, use your solution to grow the example tree above and write some test cases.

root = BinaryTree.BinaryTree.TreeNode();
add_split(root, "X1", 3);
add_split(root.leftNode, "X2", 1);
set_leaf_value(root.leftNode.leftNode, "N");
....
// Tree is built by now

signals = {"X1": 2, "X2": 1, "X3": 11}
evaluate(root, signals);

signals = {"X1": 99, "X2": 200, "X3": 11}
evaluate(root, signals);

*/


        public class TreeNode{
            // public int id;
            public String signalName;
            public int constant;
            public TreeNode leftNode;
            public TreeNode rightNode;
            public String value;
            public TreeNode(){

            }
            public TreeNode(String signalName, int constant){
                this.signalName = signalName;
                this.constant = constant;
                //this.id = id;
            }
        }

        public TreeNode add_split(TreeNode leaf, String signal_name, int constant){
            leaf.constant = constant;
            leaf.signalName = signal_name;
            TreeNode lNode = new TreeNode();
            TreeNode rNode = new TreeNode();
            leaf.leftNode  = lNode;
            leaf.rightNode= rNode;
            return leaf;
        }

        public void setLeafValue(TreeNode leaf, String value){
            leaf.value = value;
        }


        public String evaluate(TreeNode node, HashMap<String, Integer> signals){
            String result = null;
            String signalName = node.signalName;
            int constant = node.constant;
            if(node.value.equals("Y") || node.value.equals("N")){
                return node.value;
            }
            if(signals.get(signalName) <= constant){
                // go left
                node = node.leftNode;
            } else {
                node = node.rightNode;
            }
            return evaluate(node, signals);
        }

        public static void main(String[] args) {


        }
    }
