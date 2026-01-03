package Behavioural_Design_Pattern.Memento_Pattern.Right_Code;

import Behavioural_Design_Pattern.Memento_Pattern.Wrong_Code.TextEditor;

public class MementoPatternDemo {
    public static void main(String[] args) {
        TextEditor editor=new TextEditor();
        EditorHistory history=new EditorHistory();
        // Initial text
        editor.setText("Hello1");
        System.out.println("Current text: " + editor.getText());
        history.push(editor.save());

        // User types something new
        editor.setText("hello2");
        System.out.println("Current text: " + editor.getText());
        history.push(editor.save());

        // Another change
        editor.setText("Hello3");
        System.out.println("Current text: " + editor.getText());

        // Undo the last change
        Memento previousState =history.pop();
        editor.restore(previousState);
        System.out.println("After undo, text: " + editor.getText());

        // Undo to the initial state
        previousState = history.pop();
        editor.restore(previousState);
        System.out.println("After second undo, text: " + editor.getText());



    }
}
